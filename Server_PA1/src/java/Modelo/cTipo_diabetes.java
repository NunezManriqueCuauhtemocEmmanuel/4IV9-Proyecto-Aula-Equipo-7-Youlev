/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author adrai
 */
public class cTipo_diabetes {
    private int id_diab;
    private String tipo_diab, descri;

    public int getId_diab() {
        return id_diab;
    }

    public void setId_diab(int id_diab) {
        this.id_diab = id_diab;
    }

    public String getTipo_diab() {
        return tipo_diab;
    }

    public void setTipo_diab(String tipo_diab) {
        this.tipo_diab = tipo_diab;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }
    
    public Vector<cTipo_diabetes> listaTipo_diabetes() throws ClassNotFoundException{
        Vector<cTipo_diabetes> listaTipo_diabetes = new Vector<cTipo_diabetes>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from ctipo_diabetes";
            
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                cTipo_diabetes tdia = new cTipo_diabetes();
                tdia.setId_diab(rs.getInt("id_diabetes"));
                tdia.setTipo_diab(rs.getString("Tipo_diabetes"));
                tdia.setDescri(rs.getString("descripcion"));
                listaTipo_diabetes.add(tdia);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaTipo_diabetes = null;
        
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
            
            }catch(Exception e){
                System.out.println("Error no encuentra la clase");
                System.out.println(e.getMessage());
            }
        }
        return listaTipo_diabetes;
    }
}
