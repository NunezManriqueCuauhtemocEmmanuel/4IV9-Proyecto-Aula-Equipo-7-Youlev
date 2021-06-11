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
public class UsuMostrarNut {
    private int id;
    private String  nom, fn, dia, can;
    private float peso,imc,est;

    public UsuMostrarNut() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getCan() {
        return can;
    }

    public void setCan(String can) {
        this.can = can;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public float getEst() {
        return est;
    }

    public void setEst(float est) {
        this.est = est;
    }
    
    public Vector<UsuMostrarNut> listaUsuariosNut(int id) throws ClassNotFoundException{
        Vector<UsuMostrarNut> listaUsuariosNut = new Vector<UsuMostrarNut>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select usu.id_usu, nombre_usu, Fecha_Nacimiento, tipo_diabetes, sitio_origen, peso, imc, estatura " +
                        "from usuario usu, mdatos_medicos dm, ctipo_diabetes dia, ctipo_cancer can " +
                        "where (dm.id_usu = usu.id_usu) and (dm.id_diabetes = dia.id_diabetes) " +
                        "and (dm.id_cancer = can.id_cancer) and (usu.id_nutriologo = ?);";
            
            ps = con.prepareStatement(q);

            ps.setString(1, String.valueOf(id));

            rs = ps.executeQuery();
            while(rs.next()){
                UsuMostrarNut usu = new UsuMostrarNut();
                usu.setId(rs.getInt("id_usu"));
                usu.setNom(rs.getString("nombre_usu"));
                usu.setFn(rs.getString("Fecha_Nacimiento"));
                usu.setDia(rs.getString("tipo_diabetes"));
                usu.setCan(rs.getString("sitio_origen"));
                usu.setPeso(rs.getFloat("peso"));
                usu.setImc(rs.getFloat("imc"));
                usu.setEst(rs.getFloat("estatura"));
                listaUsuariosNut.add(usu);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaUsuariosNut = null;
        
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
        return listaUsuariosNut;
    }
}
