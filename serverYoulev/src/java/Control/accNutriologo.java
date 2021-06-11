/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Emiliano
 */

import Modelo.*;
import java.sql.*;

public class accNutriologo {
    
    //Ejercicios Asignados
    
    public static int registrarEjercicioA(MEjerciciosA ejerA){
        int estatus = 0;
        try{
            
            Connection con = Conexion.getConection();
            String q = "insert into mejercicios_asignados(id_usu,id_nutriologo,id_ejercicio,id_intensidad,fecha,repeticiones,num_series,observaciones) "
                    + "values(?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(ejerA.getId_usu()));
            ps.setString(2, String.valueOf(ejerA.getId_nut()));
            ps.setString(3, String.valueOf(ejerA.getId_ejer()));
            ps.setString(4, String.valueOf(ejerA.getId_inten()));
            ps.setString(5, ejerA.getFecha());
            ps.setString(6, ejerA.getRep());
            ps.setString(7, String.valueOf(ejerA.getNumS()));
            ps.setString(8, ejerA.getObs());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro de ejercicio asignado exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar el ejercicio asignado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public MEjerciciosA repetidosEjerciciosA(String idUsu,String idNut,String idEjer, String idInten) throws ClassNotFoundException{
        MEjerciciosA objEjerA = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from mejercicios_asignados where id_usu = ? AND id_nutriologo = ? AND id_ejercicio = ? AND id_intensidad = ?";
            ps = con.prepareStatement(q);
            
            ps.setString(1, idUsu);
            ps.setString(2, idNut);
            ps.setString(3, idEjer);
            ps.setString(4, idInten);
            
            rs = ps.executeQuery();
            while(rs.next()){
                objEjerA = new MEjerciciosA();
                objEjerA.setId_usu(rs.getInt("id_usu"));
                objEjerA.setId_nut(rs.getInt("id_nutriologo"));
                objEjerA.setId_ejer(rs.getInt("id_ejercicio"));
                objEjerA.setId_inten(rs.getInt("id_intensidad"));
                objEjerA.setFecha(rs.getString("fecha"));
                objEjerA.setRep(rs.getString("repeticiones"));
                objEjerA.setNumS(rs.getInt("num_series"));                  
                objEjerA.setObs(rs.getString("observaciones"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al ejercicio asignado");
            System.out.println(sq.getMessage());
            objEjerA = null;
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
        return objEjerA;
    }
    
    public static int eliminarEjercicioA(int idUsu,int idNut,int idEjer, int idInten){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "delete from mejercicios_asignados where id_usu = ? AND id_nutriologo = ? AND id_ejercicio = ? AND id_intensidad = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(idUsu));
            ps.setString(2, String.valueOf(idNut));
            ps.setString(3, String.valueOf(idEjer));
            ps.setString(4, String.valueOf(idInten));
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminar producto ejercicio asignado");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al eliminar ejercicio asignado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public MEjerciciosA recogerEjercicioA(int idUsu,int idNut,int idEjer, int idInten) throws ClassNotFoundException{
        MEjerciciosA objEjerA = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from mejercicios_asignados where id_usu = ? AND id_nutriologo = ? AND id_ejercicio = ? AND id_intensidad = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, String.valueOf(idUsu));
            ps.setString(2, String.valueOf(idNut));
            ps.setString(3, String.valueOf(idEjer));
            ps.setString(4, String.valueOf(idInten));
            rs = ps.executeQuery();
            while(rs.next()){
                objEjerA = new MEjerciciosA();
                objEjerA.setId_usu(rs.getInt("id_usu"));
                objEjerA.setId_nut(rs.getInt("id_nutriologo"));
                objEjerA.setId_ejer(rs.getInt("id_ejercicio"));
                objEjerA.setId_inten(rs.getInt("id_intensidad"));
                objEjerA.setFecha(rs.getString("fecha"));
                objEjerA.setRep(rs.getString("repeticiones"));
                objEjerA.setNumS(rs.getInt("num_series"));                  
                objEjerA.setObs(rs.getString("observaciones"));
                break;
            }
        }catch(SQLException sq){
            System.out.println("Error al verificar al producto");
            System.out.println(sq.getMessage());
            objEjerA = null;
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
        return objEjerA;
    }
    
    public static int actualizarEjercicioA(MEjerciciosA ejerA){
        int estatus = 0;
        boolean bool = false;
        try{
            accNutriologo acc = new accNutriologo();
            
            MEjerciciosA rec = acc.recogerEjercicioA(ejerA.getId_usu(),ejerA.getId_nut(),ejerA.getId_ejer(),ejerA.getId_inten());
             
            if(rec.getId_usu()==ejerA.getId_usu()&rec.getId_nut()==ejerA.getId_nut()&rec.getId_ejer()==ejerA.getId_ejer()&rec.getId_inten()==ejerA.getId_inten()){
                bool = true;
            }else{
                MEjerciciosA rep = acc.repetidosEjerciciosA(String.valueOf(ejerA.getId_usu()),String.valueOf(ejerA.getId_nut()),String.valueOf(ejerA.getId_ejer()),String.valueOf(ejerA.getId_inten()));
                if(rep==null){
                    bool = true;
                }
            }
            
            if(bool){
                Connection con = Conexion.getConection();
                String q = "update mejercicios_asignados set id_ejercicio = ?, id_intensidad = ?, fecha = ?, repeticiones = ?, num_series = ?, observaciones = ?"
                        + " where id_usu = ? AND id_nutriologo = ? AND id_ejercicio = ? AND id_intensidad = ?";

                PreparedStatement ps = con.prepareStatement(q);

                ps.setString(1, String.valueOf(ejerA.getId_ejer()));
                ps.setString(2, String.valueOf(ejerA.getId_inten()));
                ps.setString(3, String.valueOf(ejerA.getFecha()));
                ps.setString(4, String.valueOf(ejerA.getRep()));
                ps.setString(5, String.valueOf(ejerA.getNumS()));
                ps.setString(6, String.valueOf(ejerA.getObs()));
                ps.setString(7, String.valueOf(ejerA.getId_usu()));
                ps.setString(8, String.valueOf(ejerA.getId_nut()));
                ps.setString(9, String.valueOf(ejerA.getId_ejer()));
                ps.setString(10, String.valueOf(ejerA.getId_inten()));

                estatus = ps.executeUpdate();
                System.out.println("Actualizacion ejercicio asignado exitosa");
                con.close();
            }
        }catch(Exception ed){
            System.out.println("Error al actualizar el ejercicio asignado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    //Catalogo Alimentos
    
    public static int registrarAlimento(CAlimentos alimento){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "insert into calimentos(nombre,estado) "
                    + "values(?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, alimento.getNombre());
            ps.setString(2, alimento.getEstado());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro de alimento exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar el alimento");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public CAlimentos repetidosAlimentos(String nom, String est) throws ClassNotFoundException{
        CAlimentos objAlim= null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from calimentos where nombre = ? AND estado = ?";
            ps = con.prepareStatement(q);
            
            ps.setString(1, nom);
            ps.setString(2, est);
            
            rs = ps.executeQuery();
            while(rs.next()){
                objAlim = new CAlimentos();
                objAlim.setId(rs.getInt("id_alimento"));
                objAlim.setNombre(rs.getString("nombre"));
                objAlim.setEstado(rs.getString("estado"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar el Alimento");
            System.out.println(sq.getMessage());
            objAlim = null;
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
        return objAlim;
    }
    
    public static int eliminarAlimento(int id){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "delete from calimentos where id_alimento = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(id));
            
            estatus = ps.executeUpdate();
            System.out.println("Alimento eliminado exitosamente");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al eliminar alimento");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public CAlimentos recogerAlimento(int id) throws ClassNotFoundException{
        CAlimentos objAlim = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from calimentos where id_alimento = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();
            while(rs.next()){
                objAlim = new CAlimentos();
                objAlim.setId(rs.getInt("id_alimento"));
                objAlim.setNombre(rs.getString("nombre"));
                objAlim.setEstado(rs.getString("estado"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar el Alimento");
            System.out.println(sq.getMessage());
            objAlim = null;
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
        return objAlim;
    }
    
    public static int actualizarAlimento(CAlimentos alimento){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "update calimentos set nombre = ?, estado = ?"
                    + " where id_alimento = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, alimento.getNombre());
            ps.setString(2, alimento.getEstado());
            ps.setString(3, String.valueOf(alimento.getId()));
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion alimento exitosa");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al actualizar el alimento");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    //Catalogo Ejercicios
    
    public static int registrarEjercicio(CEjercicios ejercicio){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "insert into cejercicios(nombre,descripcion) "
                    + "values(?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, ejercicio.getNombre());
            ps.setString(2, ejercicio.getDescr());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro de ejercicio exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar el ejercicio");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public CEjercicios repetidosEjercicios(String nom) throws ClassNotFoundException{
        CEjercicios objEjer= null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from cejercicios where nombre = ?";
            ps = con.prepareStatement(q);
            
            ps.setString(1, nom);
            
            rs = ps.executeQuery();
            while(rs.next()){
                objEjer = new CEjercicios();
                objEjer.setId(rs.getInt("id_ejercicio"));
                objEjer.setNombre(rs.getString("nombre"));
                objEjer.setDescr(rs.getString("descripcion"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar el Ejercicio");
            System.out.println(sq.getMessage());
            objEjer = null;
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
        return objEjer;
    }
    
    public static int eliminarEjercicio(int id){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "delete from cejercicios where id_ejercicio = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(id));
            
            estatus = ps.executeUpdate();
            System.out.println("Ejercicio eliminado exitosamente");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al eliminar ejercicio");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public CEjercicios recogerEjercicio(int id) throws ClassNotFoundException{
        CEjercicios objEjer = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from cejercicios where id_ejercicio = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();
            while(rs.next()){
                objEjer = new CEjercicios();
                objEjer.setId(rs.getInt("id_ejercicio"));
                objEjer.setNombre(rs.getString("nombre"));
                objEjer.setDescr(rs.getString("descripcion"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar el ejercicio");
            System.out.println(sq.getMessage());
            objEjer = null;
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
        return objEjer;
    }
    
    public static int actualizarEjercicio(CEjercicios ejercicio){
        int estatus = 0;
        boolean bool = false;
        try{
            accNutriologo acc = new accNutriologo();
            
            CEjercicios rec = acc.recogerEjercicio(ejercicio.getId());
             
            System.out.println(rec.getNombre());
            System.out.println(ejercicio.getNombre());
            
            if(rec.getNombre().equals(ejercicio.getNombre())){
                bool = true;
            }else{
                CEjercicios rep = acc.repetidosEjercicios(ejercicio.getNombre());
                if(rep==null){
                    bool = true;
                }
            }
            
            if(bool){
                Connection con = Conexion.getConection();
                String q = "update cejercicios set nombre = ?, descripcion = ?"
                        + " where id_ejercicio = ?";

                PreparedStatement ps = con.prepareStatement(q);

                ps.setString(1, ejercicio.getNombre());
                ps.setString(2, ejercicio.getDescr());
                ps.setString(3, String.valueOf(ejercicio.getId()));

                estatus = ps.executeUpdate();
                System.out.println("Actualizacion de ejercicio exitosa");
                con.close();
            }
        }catch(Exception ed){
            System.out.println("Error al actualizar el ejercicio");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    //Catalogo Intensidades
    
    public static int registrarIntensidad(CIntensidad intensidad){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "insert into cintensidad(descripcion) "
                    + "values(?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, intensidad.getDescr());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro de intensidad exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar la intensidad");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public CIntensidad repetidosIntensidades(String descr) throws ClassNotFoundException{
        CIntensidad objInt = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from cintensidad where descripcion = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, descr);
            rs = ps.executeQuery();
            while(rs.next()){
                objInt = new CIntensidad();
                objInt.setId(rs.getInt("id_intensidad"));
                objInt.setDescr(rs.getString("descripcion"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar la intensidad");
            System.out.println(sq.getMessage());
            objInt = null;
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
        return objInt;
    }
    
    public static int eliminarIntensidad(int intensidad){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "delete from cintensidad where id_intensidad = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(intensidad));
            
            estatus = ps.executeUpdate();
            System.out.println("Intensidad eliminada exitosamente");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al eliminar intensidad");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public CIntensidad recogerIntensidad(int id) throws ClassNotFoundException{
        CIntensidad objInt = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from cintensidad where id_intensidad = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();
            while(rs.next()){
                objInt = new CIntensidad();
                objInt.setId(rs.getInt("id_intensidad"));
                objInt.setDescr(rs.getString("descripcion"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar la intensidad");
            System.out.println(sq.getMessage());
            objInt = null;
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
        return objInt;
    }

    public static int actualizarIntensidad(CIntensidad intensidad){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "update cintensidad set descripcion = ?"
                    + " where id_intensidad = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, intensidad.getDescr());
            ps.setString(2, String.valueOf(intensidad.getId()));
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion intensidad exitosa");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al actualizar la intensidad");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
}
