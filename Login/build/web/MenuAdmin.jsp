<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page import="java.sql.SQLException"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="java.sql.*"%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <%
            Connection con = null;
            Statement set = null;
            ResultSet rs = null;
            
            String tipoUsu = "";
            
            
            String url, user, password, Driver;
            
            
            
            url = "jdbc:mysql://localhost/baseusu";
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
                    
                    
                            
                    //nombreUsu = request.getParameter("usuario");
                    nombreUsu = request.getParameter("usuario");
                    password2=request.getParameter("password");
                                   
                    System.out.println(nombreUsu);
                    System.out.println(password2);
                    
                    set = con.createStatement();
                    
                    String q = "select * from usu where nom_usu='"+nombreUsu+"' and pass_usu='"+password2+"'";
                    rs = set.executeQuery(q);
                    
                    
                    if(nombreUsu.equals("Admin1") &&  password2.equals("12345")){
                        
                        %>
                        <div class="container" >
                            <div class="text-center mt-4 mb-4">
                                <h1 class="">

                                    Aqui va a poder elegir si quiere entrar a crud usuarios o nutriologos
                                </h1>
                            </div>
                            <div class="containerRegistro" >
                            </div>
                            <br>
                            <div class="containerConsulta" align="center" >
                                <a href="UsuCrud.html" class="btn btn-outline-primary"> Crud Usuarios</a>
                                &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  
                                <a href="NutCrud.html" class="btn btn-outline-primary"> Crud Nutriologos </a>
                            </div>
                         </div>
                        <%
                    }
                    
                    //Si es admin aqui aparecera el menu
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
        
        
        
        
        
         
         
    </body>
</html>

