/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adrai
 */
public class AccionesRyL {
    public static int registrarUsuario(Usuario usu){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "insert into usuario(nombre,apellido_pat,apellido_mat,nombre_usu,contrasena,email,tel,sexo,fecha_nacimiento) "
                    + "values(?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, usu.getNom());
            ps.setString(2, usu.getAppat());
            ps.setString(3, usu.getApmat());
            ps.setString(4, usu.getUsu());
            ps.setString(5, usu.getPass());
            ps.setString(6, usu.getEmail());
            ps.setString(7, String.valueOf(usu.getTel()));
            ps.setString(8, usu.getSexo());
            ps.setString(9, usu.getFN());
           
            estatus = ps.executeUpdate();
            System.out.println("Registro de usuario exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar al usuario");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public Usuario verificarEUsuario(String usu) throws ClassNotFoundException{
        Usuario objUsu = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from usuario where nombre_usu = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, usu);
            rs = ps.executeQuery();
            while(rs.next()){
                objUsu = new Usuario();
                objUsu.setId_usu(rs.getInt("id_usu"));
                objUsu.setNom(rs.getString("nombre"));
                objUsu.setAppat(rs.getString("apellido_pat"));
                objUsu.setApmat(rs.getString("apellido_mat"));
                objUsu.setUsu(rs.getString("nombre_usu"));
                objUsu.setPass(rs.getString("contrasena"));
                objUsu.setEmail(rs.getString("email"));
                objUsu.setTel(rs.getInt("tel"));
                objUsu.setSexo(rs.getString("sexo"));
                objUsu.setFN(rs.getString("fecha_nacimiento"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            objUsu = null;
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
        return objUsu;
    }
    
    public Usuario verificarUsuario(String usu, String pass) throws ClassNotFoundException{;
        Usuario objUsu = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{ 
            con = Conexion.getConection();
            String q = "select * from usuario where nombre_usu = ? AND contrasena = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, usu);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                objUsu = new Usuario(); 
                objUsu.setId_usu(rs.getInt("id_usu")); 
                objUsu.setNom(rs.getString("nombre"));
                objUsu.setAppat(rs.getString("apellido_pat"));
                objUsu.setApmat(rs.getString("apellido_mat"));
                objUsu.setUsu(rs.getString("nombre_usu"));
                objUsu.setPass(rs.getString("contrasena"));
                objUsu.setEmail(rs.getString("email"));
                objUsu.setTel(rs.getInt("tel"));
                objUsu.setSexo(rs.getString("sexo"));
                objUsu.setFN(rs.getString("fecha_nacimiento"));
                break;
            }
            System.out.println("D");
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            objUsu = null;
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
        return objUsu;
    }
}
