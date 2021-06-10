<%-- 
    Document   : perfil.jsp
    Created on : 10/06/2021, 01:58:16 AM
    Author     : levar
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
                  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Perfil</title>
  <link href="./css/perfil.css" rel="stylesheet" type="text/css">
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
          <a href="paginausu.html" class="nav-menu-link">inicio</a>
        </li>
        <li id="btn-abrir-popup" class="btn btn--4">
          <a href="#" class="nav-menu-link">¿Usuario Nuevo?</a>
        </li>
        <li id="casos" class="btn btn--4">
          <a href="vernutriologo.html" class="nav-menu-link">Ver nutriologos</a>
        </li>  
        <li id="full" class="btn btn--4">
          <a href="plan.html" class="nav-menu-link">Plan</a>
        </li>
        <li id="full" class="btn btn--4">
          <a href="regimen.html" class="nav-menu-link">Regimen</a>
        </li>
        <li>
          <input type="checkbox" name="theme" id="theme">
        </li>
      </ul>
    </nav>
  </header> 
  <section class="perfil-usuario">
    <div class="contenedor-perfil">
        <div class="portada-perfil" style="background-image: url('http://localhost/multimedia/relleno/fondo-9.png');">
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
                            
                            String nut = "arte2431";
                            
                            String q = "select * from usuario "
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
    <h1 class="heading">Datos medicos</h1>
    <div class="box-container">
      <div class="box">
        <img src="img/undraw_swipe_profiles1_i6mr.svg" width="65%">
        <p>Ingresa tus datos medicos o editalos</p>
        <a href="#" id="btn-abrir-popup3"><div class="bton">
          Ir ahora
        </div></a>
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
        que puedas modificarlos; recuerdas que al
        principio te pedimos ingresar tus datos medicos, es el momento, con esto el nutriologo que te atendera podra
        hacer tus servicios de manera eficiente.
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
  <div class="overlay3" id="overlay3">
    <div class="popup3" id="popup3">
      <a href="#" id="btn-cerrar-popup3" class="btn-cerrar-popup3"><i class="fas fa-times"></i></a>
      <h3>Datos medicos</h3>
      <div class="in-flex-1">
        <form name="formulario" onsubmit="return validar(this)" action="">
          <div class="contenedor-inputs">
            <label id="titulo">Peso</label>
            <input type="text" name="peso" placeholder="Peso" required>
            <br>
            <br>
            <label id="titulo">Estatura</label>
            <input type="text" name="estatura" placeholder="Estatura" 
              required>
            <br>
            <br>
            <label id="titulo">Indice de masa corporal</label>
            <input type="text" name="apma" placeholder="IMC" 
              required>
            <br>
            <br>
            <label id="titulo">Diabetes</label>
            <select name="diabetes" required>
              <option>Tipo 1</option>
              <option>Tipo 2</option>
              <option>Otro tipo</option>
              <option>No presenta esta enfermedad</option>
            </select>
            <br>
            <br>
            <label id="titulo">Descipcion</label>
            <textarea name="descripciond" placeholder="Escriba su mensaje" cols="30" rows="1" required></textarea>
            <br>
            <br>
            <label id="titulo">Cancer</label>
            <input type="text" name="cancer" placeholder="cancer" required>
            <br>
            <br>
            <label id="titulo">Descipcion</label>
            <textarea name="descripcionc" placeholder="Escriba su mensaje" cols="30" rows="1" required></textarea>
            <br>
            <br>
            <input class="buttons" type="submit" name="" value="Guardar">
            <input class="buttons" type="submit" name="" value="Editar">
          </div>
        </form>
      </div>
    </div>
  </div>
  </div>
  <script src="js/datosmedicos.js"></script>
  <script src="./js/main.js"></script>
  <script src="js/val.js"></script>
  <script src="js/usuarionuevo.js"></script>
  <script src="js/actualizar.js"></script>
  <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  <script src="js/app.js"></script>
</body>

</html>