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
    
    //Alimentos Asignados
    
    public static int registrarAlimentoA(MAlimentosA ejerA){
        int estatus = 0;
        try{
            
            Connection con = Conexion.getConection();
            String q = "insert into malimentos_asignados(id_usu,id_nutriologo,id_alimento,fecha,hora,cantidad,observaciones) "
                    + "values(?,?,?,CURDATE(),?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(ejerA.getId_usu()));
            ps.setString(2, String.valueOf(ejerA.getId_nut()));
            ps.setString(3, String.valueOf(ejerA.getId_alimento()));
            ps.setString(4, ejerA.getHora());
            ps.setString(5, ejerA.getCant());
            ps.setString(6, ejerA.getObs());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro de ejercicio asignado exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar el ejercicio asignado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public MAlimentosA repetidosAlimentosA(String idUsu,String idNut,String idAlim) throws ClassNotFoundException{
        MAlimentosA objAlimA = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from malimentos_asignados where id_usu = ? AND id_nutriologo = ? AND id_alimento = ?";
            ps = con.prepareStatement(q);
            
            ps.setString(1, idUsu);
            ps.setString(2, idNut);
            ps.setString(3, idAlim);
            
            rs = ps.executeQuery();
            while(rs.next()){
                objAlimA = new MAlimentosA();
                objAlimA.setId_usu(rs.getInt("id_usu"));
                objAlimA.setId_nut(rs.getInt("id_nutriologo"));
                objAlimA.setId_alimento(rs.getInt("id_alimento"));
                objAlimA.setFecha("fecha");
                objAlimA.setHora(rs.getString("hora"));
                objAlimA.setCant(rs.getString("cantidad"));
                objAlimA.setObs("observaciones");                  
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al ejercicio asignado");
            System.out.println(sq.getMessage());
            objAlimA = null;
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
        return objAlimA;
    }
    
    public static int eliminarAlimentoA(int idUsu,int idNut,int idAlim){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "delete from malimentos_asignados where id_usu = ? AND id_nutriologo = ? AND id_alimento = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(idUsu));
            ps.setString(2, String.valueOf(idNut));
            ps.setString(3, String.valueOf(idAlim));
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminar alimento asignado con exito");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al eliminar alimento asignado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public MAlimentosA recogerAlimA(int idUsu,int idNut,int idAlim) throws ClassNotFoundException{
        MAlimentosA objAlimA = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from malimentos_asignados where id_usu = ? AND id_nutriologo = ? AND id_alimento = ?";

            ps = con.prepareStatement(q);
            ps.setString(1, String.valueOf(idUsu));
            ps.setString(2, String.valueOf(idNut));
            ps.setString(3, String.valueOf(idAlim));
            rs = ps.executeQuery();
            while(rs.next()){
                objAlimA = new MAlimentosA();
                objAlimA.setId_usu(rs.getInt("id_usu"));
                objAlimA.setId_nut(rs.getInt("id_nutriologo"));
                objAlimA.setId_alimento(rs.getInt("id_alimento"));
                objAlimA.setFecha("fecha");
                objAlimA.setHora(rs.getString("hora"));
                objAlimA.setCant(rs.getString("cantidad"));
                objAlimA.setObs(rs.getString("observaciones"));
                break;
            }
        }catch(SQLException sq){
            System.out.println("Error al verificar al producto");
            System.out.println(sq.getMessage());
            objAlimA = null;
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
        
        return objAlimA;
    }
    
    public static int actualizarAlimentoA(MAlimentosA alimA,int alimAnt){
        int estatus = 0;
        boolean bool = false;
        try{
            accNutriologo acc = new accNutriologo();

            MAlimentosA rec = acc.recogerAlimA(alimA.getId_usu(),alimA.getId_nut(),alimAnt);
            
            if(rec.getId_usu()==alimA.getId_usu()&rec.getId_nut()==alimA.getId_nut()&rec.getId_alimento()==alimA.getId_alimento()){
                bool = true;
            }else{
                MAlimentosA rep = acc.repetidosAlimentosA(String.valueOf(alimA.getId_usu()),String.valueOf(alimA.getId_nut()),String.valueOf(alimA.getId_alimento()));
                if(rep==null){
                    bool = true;
                }
            }
            if(bool){
                Connection con = Conexion.getConection();
                String q = "update malimentos_asignados set id_alimento = ?, fecha = CURDATE(), hora = ?, cantidad = ?, observaciones = ?"
                        + " where (id_usu = ?) AND (id_nutriologo = ?) AND (id_alimento = ?)";

                PreparedStatement ps = con.prepareStatement(q);

                ps.setString(1, String.valueOf(alimA.getId_alimento()));
                ps.setString(2, String.valueOf(alimA.getHora()));
                ps.setString(3, String.valueOf(alimA.getCant()));
                ps.setString(4, String.valueOf(alimA.getObs()));
                ps.setString(5, String.valueOf(alimA.getId_usu()));
                ps.setString(6, String.valueOf(alimA.getId_nut()));
                ps.setString(7, String.valueOf(alimAnt));

                estatus = ps.executeUpdate();
                System.out.println("Actualizacion alimento asignado exitosa");
                con.close();
            }
        }catch(Exception ed){
            System.out.println("Error al actualizar el alimento asignado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    //Ejercicios Asignados
    
    public static int registrarEjercicioA(MEjerciciosA ejerA){
        int estatus = 0;
        try{
            
            Connection con = Conexion.getConection();
            String q = "insert into mejercicios_asignados(id_usu,id_nutriologo,id_ejercicio,id_intensidad,fecha,repeticiones,num_series,observaciones) "
                    + "values(?,?,?,?,CURDATE(),?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(ejerA.getId_usu()));
            ps.setString(2, String.valueOf(ejerA.getId_nut()));
            ps.setString(3, String.valueOf(ejerA.getId_ejer()));
            ps.setString(4, String.valueOf(ejerA.getId_inten()));
            ps.setString(5, ejerA.getRep());
            ps.setString(6, String.valueOf(ejerA.getNumS()));
            ps.setString(7, ejerA.getObs());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro de ejercicio asignado exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar el ejercicio asignado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public MEjerciciosA repetidosEjerciciosA(String idUsu,String idNut,String idEjer) throws ClassNotFoundException{
        MEjerciciosA objEjerA = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from mejercicios_asignados where id_usu = ? AND id_nutriologo = ? AND id_ejercicio = ?";
            ps = con.prepareStatement(q);
            
            ps.setString(1, idUsu);
            ps.setString(2, idNut);
            ps.setString(3, idEjer);
            
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
    
    public static int eliminarEjercicioA(int idUsu,int idNut,int idEjer){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "delete from mejercicios_asignados where id_usu = ? AND id_nutriologo = ? AND id_ejercicio = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(idUsu));
            ps.setString(2, String.valueOf(idNut));
            ps.setString(3, String.valueOf(idEjer));
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminar producto ejercicio asignado");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al eliminar ejercicio asignado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public MEjerciciosA recogerEjercicioA(int idUsu,int idNut,int idEjer) throws ClassNotFoundException{
        MEjerciciosA objEjerA = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from mejercicios_asignados where id_usu = ? AND id_nutriologo = ? AND id_ejercicio = ?";

            ps = con.prepareStatement(q);
            ps.setString(1, String.valueOf(idUsu));
            ps.setString(2, String.valueOf(idNut));
            ps.setString(3, String.valueOf(idEjer));
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
    
    public static int actualizarEjercicioA(MEjerciciosA ejerA,int ejerAnt){
        int estatus = 0;
        boolean bool = false;
        try{
            accNutriologo acc = new accNutriologo();

            MEjerciciosA rec = acc.recogerEjercicioA(ejerA.getId_usu(),ejerA.getId_nut(),ejerAnt);
            
            if(rec.getId_usu()==ejerA.getId_usu()&rec.getId_nut()==ejerA.getId_nut()&rec.getId_ejer()==ejerA.getId_ejer()){
                bool = true;
            }else{
                MEjerciciosA rep = acc.repetidosEjerciciosA(String.valueOf(ejerA.getId_usu()),String.valueOf(ejerA.getId_nut()),String.valueOf(ejerA.getId_ejer()));
                if(rep==null){
                    bool = true;
                }
            }
            if(bool){
                Connection con = Conexion.getConection();
                String q = "update mejercicios_asignados set id_ejercicio = ?, id_intensidad = ?, fecha = CURDATE(), repeticiones = ?, num_series = ?, observaciones = ?"
                        + " where (id_usu = ?) AND (id_nutriologo = ?) AND (id_ejercicio = ?)";

                PreparedStatement ps = con.prepareStatement(q);

                ps.setString(1, String.valueOf(ejerA.getId_ejer()));
                ps.setString(2, String.valueOf(ejerA.getId_inten()));
                ps.setString(3, String.valueOf(ejerA.getRep()));
                ps.setString(4, String.valueOf(ejerA.getNumS()));
                ps.setString(5, String.valueOf(ejerA.getObs()));
                ps.setString(6, String.valueOf(ejerA.getId_usu()));
                ps.setString(7, String.valueOf(ejerA.getId_nut()));
                ps.setString(8, String.valueOf(ejerAnt));

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
