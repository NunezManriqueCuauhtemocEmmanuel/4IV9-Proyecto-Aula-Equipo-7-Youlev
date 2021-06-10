<%-- 
    Document   : perfilnutriologo
    Created on : 10/06/2021, 04:32:31 AM
    Author     : levar
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Perfil</title>
  <link href="./css/perfilnutriologo.css" rel="stylesheet" type="text/css">
  <link href="./css/estilos.css" rel="stylesheet" type="text/css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300&family=Roboto:wght@300&display=swap"
    rel="stylesheet">
  <script src="https://kit.fontawesome.com/a78d4ea77b.js" crossorigin="anonymous"></script>
</head>
    <body>
  <header class="header">
    <nav class="nav">
      <a href="./sante.html" class="logo nav-link">sante et vie</a>
      <button class="nav-toggle" aria-label="Abrir menú">
        <i class="fas fa-bars"></i>
      </button>
      <ul class="nav-menu">
        <li id="full" class="btn btn--4">
          <a href="paginan.html" class="nav-menu-link">inicio</a>
        </li>
        <li id="btn-abrir-popup" class="btn btn--4">
          <a href="#" class="nav-menu-link">¿Usuario Nuevo?</a>
        </li>
        <li id="full" class="btn btn--4">
          <a href="asignarplan.html" class="nav-menu-link">asignar Plan</a>
        </li>
        <li id="full" class="btn btn--4">
          <a href="asignarregimen.html" class="nav-menu-link">asignar Regimen</a>
        </li>
        <li>
          <input type="checkbox" name="theme" id="theme">
        </li>
      </ul>
    </nav>
  </header> 
  <section class="perfil-usuario">
      
    <div class="contenedor-perfil">
        <div class="portada-perfil">
            <div class="sombra"></div>
            <div class="avatar-perfil"></div>
            <div class="datos-perfil">
                <div class="container" >
        
        <table class="table table-striped table-hover" >
            <thead>
                <tr>
                    <th>Sexo</th>
                    <th>Fecha de nacimiento</th>
                    <th>Email</th>              
                    <th>Telefono</th>
                    <th>Cedula Profesional</th
                </tr>
            </thead>
            <tbody>
                <%
                    Connection con = null;
                    Statement set = null;
                    ResultSet rs = null;
                    String url, userName, password, driver;
                    url = "jdbc:mysql://localhost/4IV9_ProyectoAulaYoulev";
                    userName = "root";
                    password = "LevAISQL90_8";
                    driver = "com.mysql.jdbc.Driver";
                    
                    try{
                        Class.forName(driver);
                        con = DriverManager.getConnection(url, userName, password);
                        try{
                            
                            String nut = "arte300";
                            
                            String q = "select * from nutriologo "
                                    + " where nombre_usu='" +nut+ "' ";
                            
                            set = con.createStatement();
                            rs = set.executeQuery(q);
                            while(rs.next()){
                            %>
                            <h1 align="center"> <%=rs.getString("nombre")%> </h1>
                                <tr>
                                    <td> <%=rs.getString("sexo")%> </td>
                                    <td> <%=rs.getString("fecha_nacimiento")%> </td>
                                    <td> <%=rs.getString("email")%> </td>
                                    <td> <%=rs.getInt("tel")%> </td>
                                    <td> <%=rs.getInt("cedula")%> </td>
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
            <br>
        </div>
                
            </div>
            <div class="opcciones-perfil">
                <button type="button" id="btn-abrir-popup2"><i class="fas fa-wrench"></i></button>
            </div>
        </div>
    </div>
  </section>
  <section class="features" id="features">
    <h1 class="heading">Bienvenido nutriologo</h1>
    <div class="box-container">
      <div class="box">
        <table class="resp">
            <thead>
              <tr>
                <th scope="col">Id paciente</th>
                <th scope="col">Nombre del paciente</th>
                <th scope="col">Fecha de nacimiento</th>
                <th scope="col">Diabetes</th>
                <th scope="col">Cancer</th>
                <th scope="col">Peso</th>
                <th scope="col">IMC</th>
                <th scope="col">Estatura</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Id paciente</td>
                <td>Nombre del paciente</td>
                <td>Fecha de nacimiento</td>
                <td>Diabetes</td>
                <td>Cancer</td>
                <td>Peso</td>
                <td>IMC</td>
                <td>Estatura</td>
              </tr>
               <tr>
                <td>Id paciente</td>
                <td>Nombre del paciente</td>
                <td>Fecha de nacimiento</td>
                <td>Diabetes</td>
                <td>Cancer</td>
                <td>Peso</td>
                <td>IMC</td>
                <td>Estatura</td>
              </tr>
              <tr>
                <td>Id paciente</td>
                <td>Nombre del paciente</td>
                <td>Fecha de nacimiento</td>
                <td>Diabetes</td>
                <td>Cancer</td>
                <td>Peso</td>
                <td>IMC</td>
                <td>Estatura</td>
              </tr>
              <tr>
                <td>Id paciente</td>
                <td>Nombre del paciente</td>
                <td>Fecha de nacimiento</td>
                <td>Diabetes</td>
                <td>Cancer</td>
                <td>Peso</td>
                <td>IMC</td>
                <td>Estatura</td>
              </tr>
              <tr>
                <td>Id paciente</td>
                <td>Nombre del paciente </td>
                <td>Fecha de nacimiento</td>
                <td>Diabetes</td>
                <td>Cancer</td>
                <td>Peso</td>
                <td>IMC</td>
                <td>Estatura</td>
              </tr>
              <tr>
                <td>Id paciente</td>
                <td>Nombre del paciente </td>
                <td>Fecha de nacimiento</td>
                <td>Diabetes</td>
                <td>Cancer</td>
                <td>Peso</td>
                <td>IMC</td>
                <td>Estatura</td>
              </tr>
              <tr>
                <td>Id paciente</td>
                <td>Nombre del paciente </td>
                <td>Fecha de nacimiento</td>
                <td>Diabetes</td>
                <td>Cancer</td>
                <td>Peso</td>
                <td>IMC</td>
                <td>Estatura</td>
              </tr>
            </tbody>
        </table>
      </div>
    </div>
  </section>
  <!--ventana flotante-->
  <div class="overlay" id="overlay">
    <div class="popup" id="popup">
      <a href="#" id="btn-cerrar-popup" class="btn-cerrar-popup"><i class="fas fa-times"></i></a>
      <h3>Bienvenido nuevo usuario</h3>
      <h4>Conoce esta ventana llamada perfil</h4>
      <p>Recien acabas de inciar en Sante et vie, te presentamos la ventana "Perfil" encargada de mostrarte tus datos y
        que puedas modificarlos.
      </p>
    </div>
  </div>
  <!--ventana de editar datos-->
  <div class="overlay2" id="overlay2">
    <div class="popup2" id="popup2">
      <a href="#" id="btn-cerrar-popup2" class="btn-cerrar-popup2"><i class="fas fa-times"></i></a>
      <h3>Actualiza tus datos</h3>
      <div class="in-flex-1">
        <form name="formulario" onsubmit="return validar(this)" action="">
          <div class="contenedor-inputs">
            <label id="titulo">Nombre</label>
            <input type="text" name="nombre" placeholder="Nombre" onkeypress="return soloLetras(event)" required>
            <br>
            <br>
            <label id="titulo">Apellido Paterno</label>
            <input type="text" name="appa" placeholder="Apellido Paterno" onkeypress="return soloLetras(event)"
              required>
            <br>
            <br>
            <label id="titulo">Apellido Materno</label>
            <input type="text" name="apma" placeholder="Apellido Materno" onkeypress="return soloLetras(event)"
              required>
            <br>
            <br>
            <label id="titulo">Fecha de nacimiento</label>
            <input type="date" name="fecha" required>
            <br>
            <br>
            <label id="titulo">Sexo</label>
            <select name="sexo" required>
              <option>Masculino</option>
              <option>Femenino</option>
            </select>
            <br>
            <br>
            <label id="titulo">Cedula Profesional</label>
            <input type="number" name="cedula" placeholder="Cedula Profesional" required>
            <br>
            <br>
            <label id="titulo">Email</label>
            <input type="email" name="correo" placeholder="Email" required>
            <br>
            <br>
            <label id="titulo">Telefono</label>
            <input type="number" name="telefono" placeholder="Telefono" required>
            <br>
            <br>
            <br>
            <br>
            <input class="buttons" type="submit" name="" value="Actualizar">
          </div>
        </form>
      </div>
    </div>
  </div>
  <!--datos medicos-->
  
  <script src="js/datosmedicos.js"></script>
  <script src="./js/main.js"></script>
  <script src="js/val.js"></script>
  <script src="js/usuarionuevo.js"></script>
  <script src="js/actualizar.js"></script>
  <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  <script src="js/app.js"></script>
</body>
</html>
