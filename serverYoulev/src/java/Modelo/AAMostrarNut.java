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
public class AAMostrarNut {
    private int id_alim;
    private String usu, obs, alim, estado, hora, cant;

    public AAMostrarNut() {
    }

    public String getAlim() {
        return alim;
    }

    public void setAlim(String alim) {
        this.alim = alim;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public int getId_alim() {
        return id_alim;
    }

    public void setId_alim(int id_alim) {
        this.id_alim = id_alim;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    

    public Vector<AAMostrarNut> listaAlimANut(int id,int idU) throws ClassNotFoundException{
        Vector<AAMostrarNut> listaAlimANut = new Vector<AAMostrarNut>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select aa.id_alimento, usu.nombre_usu, alim.nombre, alim.estado, aa.hora, aa.cantidad " +
                        "from malimentos_asignados aa, usuario usu, calimentos alim where " +
                        "(usu.id_usu = aa.id_usu) and (alim.id_alimento = aa.id_alimento) " +
                        "and (aa.id_nutriologo = ?) and (aa.id_usu = ?);";
            
            ps = con.prepareStatement(q);

            ps.setString(1, String.valueOf(id));
            ps.setString(2, String.valueOf(idU));

            rs = ps.executeQuery();
            while(rs.next()){
                AAMostrarNut aaNut = new AAMostrarNut();
                aaNut.setId_alim(rs.getInt("id_alimento"));
                aaNut.setUsu(rs.getString("usu.nombre_usu"));
                aaNut.setAlim(rs.getString("alim.nombre"));
                aaNut.setEstado(rs.getString("estado"));
                aaNut.setHora(rs.getString("hora"));
                aaNut.setCant(rs.getString("cantidad"));
                listaAlimANut.add(aaNut);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaAlimANut = null;
        
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
        return listaAlimANut;
    }
    
    public Vector<AAMostrarNut> listaAlimAu(int id) throws ClassNotFoundException{
        Vector<AAMostrarNut> listaAlimANut = new Vector<AAMostrarNut>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select aa.id_alimento, usu.nombre_usu, alim.nombre, alim.estado, aa.hora, aa.cantidad, aa.observaciones " +
                        "from malimentos_asignados aa, usuario usu, calimentos alim where " +
                        "(usu.id_usu = aa.id_usu) and (alim.id_alimento = aa.id_alimento) " +
                        "and (aa.id_usu = ?);";
            
            ps = con.prepareStatement(q);

            ps.setString(1, String.valueOf(id));

            rs = ps.executeQuery();
            while(rs.next()){
                AAMostrarNut aaNut = new AAMostrarNut();
                aaNut.setId_alim(rs.getInt("id_alimento"));
                aaNut.setUsu(rs.getString("usu.nombre_usu"));
                aaNut.setAlim(rs.getString("alim.nombre"));
                aaNut.setEstado(rs.getString("estado"));
                aaNut.setHora(rs.getString("hora"));
                aaNut.setCant(rs.getString("cantidad"));
                aaNut.setObs(rs.getString("observaciones"));
                listaAlimANut.add(aaNut);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaAlimANut = null;
        
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
        return listaAlimANut;
    }
}
