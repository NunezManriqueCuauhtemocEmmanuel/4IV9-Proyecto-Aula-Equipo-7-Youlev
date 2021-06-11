/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Nutriologo;
import Modelo.Usuario;
import java.sql.*;

/**
 *
 * @author Emiliano
 */

public class accUsu {
    public static int cambiarNutriologo(int idU,int idN){
        int estatus = 0;
        try{
                
            
                Connection con = Conexion.getConection();
                String q = "update usuario set id_nutriologo = ?"
                        + " where (id_usu = ?);";
                
                String k = "delete from mejercicios_asignados where id_nutriologo = ? and id_usu = ?";

                String j = "delete from malimentos_asignados where id_nutriologo = ? and id_usu = ?";
                
                PreparedStatement ps = con.prepareStatement(q);
                ps.setString(1, String.valueOf(idN));
                ps.setString(2, String.valueOf(idU));
                estatus = ps.executeUpdate();
                
                ps = con.prepareStatement(k);
                ps.setString(1, String.valueOf(idN));
                ps.setString(2, String.valueOf(idU));
                estatus = ps.executeUpdate();
                
                ps = con.prepareStatement(j);
                ps.setString(1, String.valueOf(idN));
                ps.setString(2, String.valueOf(idU));
                estatus = ps.executeUpdate();
                
                System.out.println("Actualizacion ejercicio asignado exitosa");
                con.close();
        }catch(Exception ed){
            System.out.println("Error al actualizar el ejercicio asignado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    }

