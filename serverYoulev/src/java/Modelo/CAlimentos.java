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
public class CAlimentos {
    private int id;
    private String nombre,estado;

    public CAlimentos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Vector<CAlimentos> listaAlimentos() throws ClassNotFoundException{
        Vector<CAlimentos> listaAlimentos = new Vector<CAlimentos>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from calimentos";
            
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                CAlimentos alim = new CAlimentos();
                alim.setId(rs.getInt("id_alimento"));
                alim.setNombre(rs.getString("nombre"));
                alim.setEstado(rs.getString("estado"));
                listaAlimentos.add(alim);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaAlimentos = null;
        
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
        return listaAlimentos;
    }
}
