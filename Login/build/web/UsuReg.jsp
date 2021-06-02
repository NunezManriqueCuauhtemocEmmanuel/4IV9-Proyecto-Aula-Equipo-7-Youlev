<%-- 
    Document   : index
    Created on : 2/05/2021, 02:43:41 AM
    Author     : levar
--%>


<%@page import="java.sql.SQLException"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de usuarios</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        
    </head>
    <body>
        <div class="container" >
            
            
        <%
            Connection con = null;
            Statement set = null;
            ResultSet rs = null;
            
            String url, user, password, Driver;
            
            
            
            url = "jdbc:mysql://localhost:3306/baseusu";
            Driver = "com.mysql.jdbc.Driver";
            user = "root";
            password= "LevAISQL90_8";
            
            
            try{
                Class.forName(Driver);
                con = DriverManager.getConnection(url, user, password);
                //con = DriverManager.getConnection(url, user, password);
                
                try{
                    String nombreUsu, apellidop, apellidom, Usuid, email, telefono , pass;
                    int edad;

                
                    nombreUsu = request.getParameter("nombre");
                    apellidop = request.getParameter("apellidop");
                    apellidom = request.getParameter("apellidom");
                    edad = edad = Integer.parseInt(request.getParameter("edad"));
                    email = request.getParameter("email");
                    telefono= request.getParameter("telefono");
                    pass= request.getParameter("contrasena");
                    Usuid = request.getParameter("id");


                    
                    set = con.createStatement();

                    String q = "insert into usu(nom_usu, apellidop, apellidom, edad_usu, tel_usu, email_usu, nom_id, pass_usu)"
                            + "values "
                        + "('"+nombreUsu +"', '"+ apellidop +"', '"+apellidom+"', '"+edad+"', '"+telefono+"', '"+email+"', '"+Usuid+"', '"+pass+"')";
                    
                    
                    int registro = set.executeUpdate(q);
                    
                    %>
                        <h1>El registro se hizo de manera correcta</h1>
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
            </thead>
            <tbody>
                    <%
                    
                    String q1 = "select * from usu order by id_usu asc";

                    set = con.createStatement();
                    rs = set.executeQuery(q1);
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
                            
                        </tr>     
                        <%
                    }
                    rs.close();
                    set.close();
                    
                }catch(SQLException ed ){

                    System.out.println("Error al registrar en la tabla");
                    System.out.println(ed.getMessage());
                    System.out.println(ed.getStackTrace());
                    %>
                        <h1>Upps!! Algo salio mal registro no exitoso</h1>
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
                    
            </tbody>
        </table>
        <br>
       </div>
                <a href="UsuCrud.html" class="btn btn-outline-primary">Regresar </a>

    </body>
</html>
