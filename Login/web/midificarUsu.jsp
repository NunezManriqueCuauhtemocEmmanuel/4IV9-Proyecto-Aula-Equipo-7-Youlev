<%-- 
    Document   : Consultar
    Created on : 2/05/2021, 11:00:08 AM
    Author     : levar
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <title>Consulta de usuarios</title>
    </head>
    <body>
        <div class="container">
            <div class="text-center mt-4 mb-4">
                <h1>Estos son los usuarios registrados</h1>
            </div>
            <hr> 
            <div class="table-responsive">
                <table class="table table-striped table-hover">
            <thead>
                    <th align="center">ID</th>
                    <th align="center">Nombre</th>
                    <th align="center">Apellido Paterno</th>
                    <th align="center">Apellido Materno</th>
                    <th align="center">Edad</th>
                    <th align="center">Telefono</th>
                    <th align="center">Email</th>
                    <th align="center">Nombre ID</th>
                    <th align="center">Contraseña</th>
                    <th align="center">Acciones</th>
            </thead>
            <tbody>
                <%
                    Connection con = null;
                    Statement set = null;
                    ResultSet rs = null;

                    String url, userName, password, driver;

                    url = "jdbc:mysql://localhost/baseusu";
                    userName = "root";
                    password = "LevAISQL90_8";
                    driver = "com.mysql.jdbc.Driver";
                    
                    try{
                        Class.forName(driver);
                        con = DriverManager.getConnection(url, userName, password);
                        try{
                            String q = "select * from usu order by id_usu asc";
                            
                            set = con.createStatement();
                            rs = set.executeQuery(q);
                            while(rs.next()){
                            %>
                                <tr>
                                    <td align="center"> <%=rs.getInt("id_usu")%> </td>
                                    <td align="center"> <%=rs.getString("nom_usu")%> </td>
                                    <td align="center"> <%=rs.getString("apellidop")%> </td> 
                                    <td align="center"> <%=rs.getString("apellidom")%> </td>
                                    <td align="center"> <%=rs.getInt("edad_usu")%> </td> 
                                    <td align="center"> <%=rs.getString("tel_usu")%> </td> 
                                    <td align="center"> <%=rs.getString("email_usu")%> </td>
                                    <td align="center"> <%=rs.getString("nom_id")%> </td>
                                    <td align="center"> <%=rs.getString("pass_usu")%> </td>
                            
                                    <td align="center"> 
                                        <a class="btn btn-outline-primary" href="EditarUsu.jsp?id=<%=rs.getInt("id_usu")%>" > Editar </a> 
                                        
                                        <a class="btn btn-outline-danger" href="borrarUsu.jsp?id=<%=rs.getInt("id_usu")%>" > Borrar </a> 
                                    </td>

                                </tr>     
                                <%
                            
                            }
                            rs.close();
                            set.close();
                        
                        }catch(SQLException ed){
                            System.out.println("Error al consultar la tabla");
                            System.out.println(ed.getMessage());
                            %>
                        </tbody>
                        <h1>Error el recurso de la consulta no esta disponible, solo juguito contigo</h1>
                            <%
                        
                        }
                        con.close();
                    
                    }catch(Exception e){
                        System.out.println("Error al conectar con la bd");
                        System.out.println(e.getMessage());
                        System.out.println(e.getStackTrace());
                        %>
                    
                    <h1>Sitio en construcción</h1>
                    
                    <%
                    }
                    %>
                    
            </tbody>
        </table>
            </div>
                    <br>
                    <a class="btn btn-outline-primary" href="UsuCrud.html"> Regresar</a>
        </div>
    </body>
</html>
