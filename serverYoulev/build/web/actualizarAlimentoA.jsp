<%-- 
    Document   : actualizarAlimentoA
    Created on : Jun 11, 2021, 4:44:12 AM
    Author     : Emiliano
--%>

<%@page import="Modelo.MAlimentosA"%>
<%@page import="Modelo.CAlimentos"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Asignar Plan</title>
    <link rel="stylesheet" href="css/asignarplan.css" type="text/css">
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
  <div class="content">
    <h3 id="titulo">Asignacion de<span> Plan alimenticio</span></h3>
    <p>Asigna los planes alimenticios a tus usuarios</p>
  </div>
  <div class="image">
    <img src="img/undraw_diet_ghvw.svg" alt="">
  </div>
</section>
<section class="homeim">
    <%
        HttpSession sesionNut = request.getSession();
        MAlimentosA objAlim = (MAlimentosA)sesionNut.getAttribute("objAlimA");
    %>
    <div class="in-flex-1">
      <form name="formulario" onsubmit="return validar(this)" action="actualizarAlimA">
        <h3 id="titulo">Ingresar plan</h3>
        <div class="contenedor-inputs">
          <label id="titulo">Alimento</label>
          <select name="alimento" class="combobox" required>
                            <%
                            Vector<CAlimentos> listaAlimentos = new CAlimentos().listaAlimentos();

                            for(CAlimentos alim : listaAlimentos){
                                if(objAlim.getId_alimento()==alim.getId()){
                                    %>
                            <option value="<%=alim.getId()%>" selected="true"><%=alim.getNombre()+"("+alim.getEstado()+")"%></option>
                                    <%
                                }else{
                                    %>
                            <option value="<%=alim.getId()%>"><%=alim.getNombre()+"("+alim.getEstado()+")"%></option>
                                    <%
                                }
                    }
            %>
                        </select>
          <br>
          <br>
          <label id="titulo">Hora</label>
          <input type="time" name="hora" value="<%=objAlim.getHora()%>" placeholder="Hora" required>
          <br>
          <br>
          <label id="titulo">Cantidad</label>
          <input type="text" name="cantidad" value="<%=objAlim.getCant()%>" placeholder="Cantidad" required>
          <br>
          <br>
          <label id="titulo">Observaciones</label>
          <textarea name="observaciones" placeholder="Observaciones" cols="30" rows="1" required><%=objAlim.getObs()%></textarea>
          <br>
          <br>
          <input class="buttons" type="submit" name="" value="Actualizar">
          <a href="planNut.jsp">Regresar</a>
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
