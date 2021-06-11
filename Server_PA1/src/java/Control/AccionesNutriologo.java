/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Nutriologo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adrai
 */
public class AccionesNutriologo {
    public static int registrarNutriologo(Nutriologo nutri){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "insert into nutriologo(nombre,apellido_pat,apellido_mat,nombre_usu,contrasena,email,tel,sexo,fecha_nacimiento,cedula) "
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, nutri.getNom());
            ps.setString(2, nutri.getAppat());
            ps.setString(3, nutri.getApmat());
            ps.setString(4, nutri.getUsu());
            ps.setString(5, nutri.getPass());
            ps.setString(6, nutri.getEmail());
            ps.setString(7, String.valueOf(nutri.getTel()));
            ps.setString(8, nutri.getSex());
            ps.setString(9, nutri.getFN());
            ps.setString(10, String.valueOf(nutri.getCed()));
           
            estatus = ps.executeUpdate();
            System.out.println("Registro de nutriologo exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar al nutriologo");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public Nutriologo verificarENutriologo(String nutri) throws ClassNotFoundException{
        Nutriologo objNutri = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from nutriologo where nombre_usu = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, nutri);
            rs = ps.executeQuery();
            while(rs.next()){
                objNutri = new Nutriologo();
                objNutri.setId_nutri(rs.getInt("id_nutriologo"));
                objNutri.setNom(rs.getString("nombre"));
                objNutri.setAppat(rs.getString("apellido_pat"));
                objNutri.setApmat(rs.getString("apellido_mat"));
                objNutri.setUsu(rs.getString("nombre_usu"));
                objNutri.setPass(rs.getString("contrasena"));
                objNutri.setEmail(rs.getString("email"));
                objNutri.setTel(rs.getInt("tel"));
                objNutri.setSex(rs.getString("sexo"));
                objNutri.setFN(rs.getString("fecha_nacimiento"));
                objNutri.setCed(rs.getInt("cedula"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al nutriologo");
            System.out.println(sq.getMessage());
            objNutri = null;
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
            
            }catch(Exception e){
                System.out.println("No encontro la clase");
                System.out.println(e.getMessage());
            
            }
        }
        return objNutri;
    }
    
    public Nutriologo verificarUsuario(String usu, String pass) throws ClassNotFoundException{
        Nutriologo objNutri = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from nutriologo where nombre_usu = ? AND contrasena = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, usu);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                objNutri = new Nutriologo();
                objNutri.setId_nutri(rs.getInt("id_nutriologo"));
                objNutri.setNom(rs.getString("nombre"));
                objNutri.setAppat(rs.getString("apellido_pat"));
                objNutri.setApmat(rs.getString("apellido_mat"));
                objNutri.setUsu(rs.getString("nombre_usu"));
                objNutri.setPass(rs.getString("contrasena"));
                objNutri.setEmail(rs.getString("email"));
                objNutri.setTel(rs.getInt("tel"));
                objNutri.setSex(rs.getString("sexo"));
                objNutri.setFN(rs.getString("fecha_nacimiento"));
                objNutri.setCed(rs.getInt("cedula"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al nutriologo");
            System.out.println(sq.getMessage());
            objNutri = null;
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
            
            }catch(Exception e){
                System.out.println("No encontro la clase");
                System.out.println(e.getMessage());
            
            }
        }
        return objNutri;
    }
}
