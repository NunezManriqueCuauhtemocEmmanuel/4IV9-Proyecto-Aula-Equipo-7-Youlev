/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.Conexion;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Emiliano
 */
public class Nutriologo {
    private int id;
    private String nombre,appat,apmat,nomUsu,pass,email,sexo,FN,cedula;
    private long tel;

    public Nutriologo() {
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

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getApmat() {
        return apmat;
    }

    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    public String getNomUsu() {
        return nomUsu;
    }

    public void setNomUsu(String nomUsu) {
        this.nomUsu = nomUsu;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFN() {
        return FN;
    }

    public void setFN(String FN) {
        this.FN = FN;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }
    
    public Vector<Nutriologo> listaNutriologos() throws ClassNotFoundException{
        Vector<Nutriologo> listaNutriologos = new Vector<Nutriologo>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from nutriologo";
            
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                Nutriologo nutri = new Nutriologo();
                nutri.setId(rs.getInt("id_nutriologo"));
                nutri.setNombre(rs.getString("nombre"));
                nutri.setAppat(rs.getString("apellido_pat"));
                nutri.setApmat(rs.getString("apellido_mat"));
                listaNutriologos.add(nutri);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los nutriologos");
            System.out.println(sq.getMessage());
            listaNutriologos = null;
        
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
        return listaNutriologos;
    }
}
