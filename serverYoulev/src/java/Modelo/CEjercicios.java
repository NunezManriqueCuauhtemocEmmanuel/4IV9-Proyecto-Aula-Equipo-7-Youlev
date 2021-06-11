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
public class CEjercicios {
    private int id;
    private String nombre,descr;

    public CEjercicios() {
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
    
    public Vector<CEjercicios> listaEjercicios() throws ClassNotFoundException{
        Vector<CEjercicios> listaEjercicios = new Vector<CEjercicios>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from cejercicios";
            
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                CEjercicios ejer = new CEjercicios();
                ejer.setId(rs.getInt("id_ejercicio"));
                ejer.setNombre(rs.getString("nombre"));
                ejer.setDescr(rs.getString("descripcion"));
                listaEjercicios.add(ejer);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaEjercicios = null;
        
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
        return listaEjercicios;
    }
}
