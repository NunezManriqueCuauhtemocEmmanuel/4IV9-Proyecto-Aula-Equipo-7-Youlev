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
 * @author Emiliano
 */
public class CIntensidad {
    private int id;
    private String descr;

    public CIntensidad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
    
    public Vector<CIntensidad> listaIntensidades() throws ClassNotFoundException{
        Vector<CIntensidad> listaIntensidades = new Vector<CIntensidad>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from cintensidad";
            
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                CIntensidad inten = new CIntensidad();
                inten.setId(rs.getInt("id_intensidad"));
                inten.setDescr(rs.getString("descripcion"));
                listaIntensidades.add(inten);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaIntensidades = null;
        
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
        return listaIntensidades;
    }
}
