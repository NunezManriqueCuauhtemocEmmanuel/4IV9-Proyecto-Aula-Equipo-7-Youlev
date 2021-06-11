<%-- 
    Document   : visualizarUsuAsignados
    Created on : Jun 10, 2021, 2:11:34 PM
    Author     : Emiliano
--%>

<%@page import="Modelo.UsuMostrarNut"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios</title>
    <link rel="stylesheet" href="css/plan.css" type="text/css">
    <link href="css/estilos.css" rel="stylesheet" type="text/css">
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
          <a href="regimen.html" class="nav-menu-link">Regimen</a>
        </li>
        <li id="full" class="btn btn--4">
          <a href="perfil.html" class="nav-menu-link">Perfil</a>
        </li>
        <li>
          <input type="checkbox" name="theme" id="theme">
        </li>
      </ul>
    </nav>
  </header>
<section class="home" id="home">
  <div class="content">
    <h3 id="titulo">Lista de <span>Usuarios</span></h3>
    <form>
        <table class="content-table">
        <thead>
            <tr>
                <th id=""></th>
                <th id="">Nombre</th>
                <th id="">Fecha de Nacimiento</th>
                <th id="">Diabetes</th>
                <th id="">Cancer</th>
                <th id="">Peso</th>
                <th id="">Estatura</th>
                <th id="">IMC</th>
            </tr>
        </thead>
        <tbody>
            <%
                HttpSession sesionNut = request.getSession();
                int idNut = (int)sesionNut.getAttribute("id");
                
                            Vector<UsuMostrarNut> listaUsuariosNut = new UsuMostrarNut().listaUsuariosNut(idNut);

                    for(UsuMostrarNut usu : listaUsuariosNut){
                        %>
                        <tr>
                            <td><input type="radio" name="select" value="<%=usu.getId()%>" class="radio-button"></td>
                            <td><%=usu.getNom()%></td>
                            <td><%=usu.getFn()%></td>
                            <td><%=usu.getDia()%></td>
                            <td><%=usu.getCan()%></td>
                            <td><%=usu.getPeso()%></td>
                            <td><%=usu.getEst()%></td>
                            <td><%=usu.getImc()%></td>
                        </tr>
                                    <%
                    }
            %>
        </tbody>
        </table>
        <div class="accionesB">
            <input type="submit" formaction="cargarPlan" value="Plan de Alimentacion" class="boton-accion" id="edit" method="POST">
            <input type="submit" formaction="cargarRegimen" value="Regimen de Ejercicios" class="boton-accion" id="delete" method="POST">
        </div>
    </form>
  </div>
  <div class="image">
    <img src="img/undraw_cup_of_tea_6nqg (1).svg" alt="">
  </div>
</section>

  <div class="overlay" id="overlay">
    <div class="popup" id="popup">
      <a href="#" id="btn-cerrar-popup" class="btn-cerrar-popup"><i class="fas fa-times"></i></a>
      <h3>Bienvenido nuevo usuario</h3>
      <h4>Conoce esta ventana llamada plan</h4>
      <p>Sigues descubriendo, llego el turno de conocer la ventana plan, en esa ventana podras visualizar la dieta
         cuando sean asignados por tu nutriologo
      </p>
    </div>
  </div>
    <script src="./js/main.js"></script>
    <script src="js/usuarionuevo.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="js/app.js"></script>
</body>
</html>
