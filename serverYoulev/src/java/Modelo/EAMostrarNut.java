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
public class EAMostrarNut {
    private String usu,ejer,inten,rep,obs;
    private int numS,id_ejer;

    public EAMostrarNut() {
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getEjer() {
        return ejer;
    }

    public void setEjer(String ejer) {
        this.ejer = ejer;
    }

    public String getInten() {
        return inten;
    }

    public void setInten(String inten) {
        this.inten = inten;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public int getNumS() {
        return numS;
    }

    public void setNumS(int numS) {
        this.numS = numS;
    }

    public int getId_ejer() {
        return id_ejer;
    }

    public void setId_ejer(int id_ejer) {
        this.id_ejer = id_ejer;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    public Vector<EAMostrarNut> listaEjerANut(int id,int idU) throws ClassNotFoundException{
        Vector<EAMostrarNut> listaEjerANut = new Vector<EAMostrarNut>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select ea.id_ejercicio, usu.nombre_usu, ejer.nombre, inten.descripcion, repeticiones, num_series from " +
                        "usuario usu, mejercicios_asignados ea, cejercicios ejer, cintensidad inten " +
                        "where (ejer.id_ejercicio = ea.id_ejercicio) and (ea.id_usu = usu.id_usu) " +
                        "and (inten.id_intensidad = ea.id_intensidad) and (ea.id_nutriologo = ?) and (ea.id_usu = ?);";
            
            ps = con.prepareStatement(q);

            ps.setString(1, String.valueOf(id));
            ps.setString(2, String.valueOf(idU));

            rs = ps.executeQuery();
            while(rs.next()){
                EAMostrarNut eaNut = new EAMostrarNut();
                eaNut.setId_ejer(rs.getInt("id_ejercicio"));
                eaNut.setUsu(rs.getString("usu.nombre_usu"));
                eaNut.setEjer(rs.getString("ejer.nombre"));
                eaNut.setInten(rs.getString("descripcion"));
                eaNut.setRep(rs.getString("repeticiones"));
                eaNut.setNumS(rs.getInt("num_series"));
                listaEjerANut.add(eaNut);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaEjerANut = null;
        
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
        return listaEjerANut;
    }
    
    public Vector<EAMostrarNut> listaEjerAu(int id) throws ClassNotFoundException{
        Vector<EAMostrarNut> listaEjerAu = new Vector<EAMostrarNut>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select ea.id_ejercicio, ejer.nombre, inten.descripcion, repeticiones, num_series, observaciones from " +
                        "usuario usu, mejercicios_asignados ea, cejercicios ejer, cintensidad inten " +
                        "where (ejer.id_ejercicio = ea.id_ejercicio) and (ea.id_usu = usu.id_usu) " +
                        "and (inten.id_intensidad = ea.id_intensidad) and (ea.id_usu = ?);";
            
            ps = con.prepareStatement(q);

            ps.setString(1, String.valueOf(id));

            rs = ps.executeQuery();
            while(rs.next()){
                EAMostrarNut eaNut = new EAMostrarNut();
                eaNut.setId_ejer(rs.getInt("id_ejercicio"));
                eaNut.setEjer(rs.getString("ejer.nombre"));
                eaNut.setInten(rs.getString("descripcion"));
                eaNut.setRep(rs.getString("repeticiones"));
                eaNut.setNumS(rs.getInt("num_series"));
                eaNut.setObs(rs.getString("ea.observaciones"));
                listaEjerAu.add(eaNut);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaEjerAu = null;
        
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
        return listaEjerAu;
    }
}
