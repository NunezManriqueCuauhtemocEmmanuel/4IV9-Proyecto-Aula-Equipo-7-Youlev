<%-- 
    Document   : validar
    Created on : 04-may-2021, 19:27:01
    Author     : bailarina77
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link href="CSS/estilo.css" rel="stylesheet">
    </head>
    <body>
        <div class="container" >
        <%
            Connection con = null;
            Statement set = null;
            ResultSet rs = null;
            
            
            String url, user, password, Driver;
            
            
            
            url = "jdbc:mysql://localhost/baseusuarios";
            Driver = "com.mysql.jdbc.Driver";
            user = "root";
            password= "LevAISQL90_8";
            
            
            try{
                Class.forName(Driver);
                con = DriverManager.getConnection(url, user, password);
                //con = DriverManager.getConnection(url, user, password);
                
                try{
                    String nombreUsu, password2;
                    int resultado=0;
                    
                    
                    nombreUsu = request.getParameter("usuario");
                    password2=request.getParameter("password");
                                   
                    set = con.createStatement();
                    
                    String q = "select * from usuarios where nom_usu='"+nombreUsu+"' and pass_usu='"+password2+"'";
                         
                    
                    rs = set.executeQuery(q);
                  
                    if(nombreUsu.equals("Admin1") &&  password2.equals("12345")){
                            %>
                            <h1 align="center">Bienvenido al menu del administrador</h1>
                            <img src="helado.jpg"></img>
                            <a href="Productoindex.html" class="btn btn-outline-primary">CRUD PRODUCTOS</a>
                            <%
                                
                            %>
                            <div >
                                    <img src="descarga.png"></img>
                                <a href="Productoindex.html" class="btn btn-outline-primary">CRUD USUARIOS</a>
                            </div>
                            <%
                                
                                %>
                            <div >
                                    <img src="promo.jpg"></img>
                                <a href="PromoCrud.html" class="btn btn-outline-primary">CRUD PROMOCIONES</a>
                            </div>
                            <%
                                
                    }
                        
                    
                       if (rs.next()) {
                           
                           resultado=1;
                           
                           if (resultado==1) {
                               
                               %>
                                 <h1>Login exitoso</h1>
                                 <a href="carrito.html">VAMOS AL CARRITO YEIIIIIII</a>
                                 <%
                                   
                               }
                               
                        }else{

                                        %>
                                     <h1>Usuario no encontrado</h1>
                                     <a class="btn btn-outline-primary" href="login.html">Regresa para intentar de nuevo</a>
                                 <%

                         }
                        
                    
                }catch(SQLException ed ){

                    System.out.println("Error al registrar en la tabla");
                    System.out.println(ed.getMessage());
                    System.out.println(ed.getStackTrace());
                    %>
                        <h1>ERROR AL CONECTAR</h1>
                    <%
                }
                set.close();
                
            }catch(Exception e){
                
                System.out.println("Error al conectar con la BD");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                %>
                        <h1>Sitio en construccion</h1>
                <%
            }

        %>
        <br>
        <a href="adminpag.html" class="btn btn-outline-primary">Regresar al login</a>
        </div>
        
        <footer class="absolut">
            
            <p>
                Gutiérrez Villalobos José Alfredo  &nbsp     Regalado Zuñiga Leonardo Daniel  &nbsp    Rivera garcia jonathan ulises 
            </p>    

        </footer>
    </body>
</html>


