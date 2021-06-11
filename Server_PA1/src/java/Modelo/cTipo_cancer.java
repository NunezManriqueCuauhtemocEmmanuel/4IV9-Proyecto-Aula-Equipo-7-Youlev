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
public class cTipo_cancer {
    private int id_cancer;
    private String sitio_origen, descripcion;

    public int getId_cancer() {
        return id_cancer;
    }

    public void setId_cancer(int id_cancer) {
        this.id_cancer = id_cancer;
    }

    public String getSitio_origen() {
        return sitio_origen;
    }

    public void setSitio_origen(String sitio_origen) {
        this.sitio_origen = sitio_origen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Vector<cTipo_cancer> listaTipo_cancer() throws ClassNotFoundException{
        Vector<cTipo_cancer> listaTipo_cancer = new Vector<cTipo_cancer>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from ctipo_cancer";
            
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                cTipo_cancer tcan = new cTipo_cancer();
                tcan.setId_cancer(rs.getInt("id_cancer"));
                tcan.setSitio_origen(rs.getString("sitio_origen"));
                tcan.setDescripcion(rs.getString("descripcion"));
                listaTipo_cancer.add(tcan);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaTipo_cancer = null;
        
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
        return listaTipo_cancer;
    }
    
}
