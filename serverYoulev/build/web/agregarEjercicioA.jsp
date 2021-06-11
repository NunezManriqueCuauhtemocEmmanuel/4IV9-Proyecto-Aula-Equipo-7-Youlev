<%-- 
    Document   : agregarEjerA
    Created on : Jun 10, 2021, 10:18:28 PM
    Author     : Emiliano
--%>

<%@page import="Modelo.CIntensidad"%>
<%@page import="Modelo.CEjercicios"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Asignar Plan</title>
    <link rel="stylesheet" href="css/asignarregimen.css" type="text/css">
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
            <a href="paginan.html" class="nav-menu-link">inicio</a>
          </li>
          <li id="btn-abrir-popup" class="btn btn--4">
            <a href="#" class="nav-menu-link">¿Usuario Nuevo?</a>
          </li>
          <li id="full" class="btn btn--4">
            <a href="asignarregimen.html" class="nav-menu-link">asignar Regimen</a>
          </li>
          <li id="full" class="btn btn--4">
            <a href="perfilnutriologo.html" class="nav-menu-link">Perfil</a>
          </li>
          <li>
            <input type="checkbox" name="theme" id="theme">
          </li>
        </ul>
      </nav>
  </header>
<section class="home" id="home">
    <div class="image">
        <img src="img/undraw_healthy_habit_bh5w.svg" alt="">
    </div>
  <div class="content">
    <h3 id="titulo">Asignacion de<span> Regimen de ejercicios</span></h3>
    <p>Asigna los regimenes de ejercicio a tus usuarios</p>
  </div>
</section>
<section class="homeim">
    <div class="in-flex-1">
        <form name="formulario" onsubmit="return validar(this)" action="agregarEjerA" method="POST">
        <h3 id="titulo">Ingresar plan</h3>
        <div class="contenedor-inputs">
          <label id="titulo">Ejercicio</label>
          <select name="ejercicio" class="combobox" required>
                            <%
                            Vector<CEjercicios> listaEjer = new CEjercicios().listaEjercicios();

                            for(CEjercicios ejer : listaEjer){
                        %>
                            <option value="<%=ejer.getId()%>"><%=ejer.getNombre()%></option>
                                    <%
                    }
            %>
                        </select>
          <br>
          <br>
          <label id="titulo">Intensidad</label>
          <select name="intensidad" class="combobox" required>
                            <%
                            Vector<CIntensidad> listaIntensidades = new CIntensidad().listaIntensidades();

                            for(CIntensidad inten : listaIntensidades){
                        %>
                            <option value="<%=inten.getId()%>"><%=inten.getDescr()%></option>
                                    <%
                    }
            %>
                        </select>
          <br>
          <br>
          <label id="titulo">Repeticiones</label>
          <input type="text" name="repeticiones" placeholder="Repeticiones" required>
          <br>
          <br>
          <label id="titulo">Numero de series</label>
          <input type="number" name="numseries" placeholder="Numero de series" required>
          <br>
          <br>
          <label id="titulo">Observaciones</label>
          <textarea name="observaciones" placeholder="Observaciones" cols="30" rows="1" required></textarea>
          <br>
          <br>
          <input class="buttons" type="submit" name="" value="Agregar">
          <a href="regimenNut.jsp">Regresar</a>
        </div>
      </form>
    </div>
</section>

  <div class="overlay" id="overlay">
    <div class="popup" id="popup">
      <a href="#" id="btn-cerrar-popup" class="btn-cerrar-popup"><i class="fas fa-times"></i></a>
      <h3>Bienvenido nuevo usuario</h3>
      <h4>Conoce esta ventana llamada Asignar Plan</h4>
      <p>Conoce esta ventana llamada asignar plan a tus pacientes ingresando el id del paciente, si no lo sabes, se encuentra en la ventana perfil, justo debajo de los datos generales 
      </p>
    </div>
  </div>

    <script src="./js/main.js"></script>
    <script src="js/usuarionuevo.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="js/app.js"></script>
</body>
</html>
