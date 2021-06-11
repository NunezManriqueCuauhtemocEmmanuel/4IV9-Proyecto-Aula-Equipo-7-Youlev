<%-- 
    Document   : cAlimentos
    Created on : Jun 10, 2021, 2:20:54 AM
    Author     : Emiliano
--%>

<%@page import="Control.accNutriologo"%>
<%@page import="Modelo.CAlimentos"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alimentos</title>
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
      <%
                boolean act = Boolean.parseBoolean(request.getParameter("act"));
                
                if(act){
                    HttpSession sesionAlim = request.getSession();
                    int idAl = (int)sesionAlim.getAttribute("alim");
                    accNutriologo acc = new accNutriologo();
                    CAlimentos alim = acc.recogerAlimento(idAl);
                    %>
                <form action="actualizarAlimentos">
                    <label class="labRC">Alimento:</label>
                    <input type="text" id="cIntensidad" name="idA" value="<%=alim.getId()%>" style="display: none;">
                    <input type="text" id="cAlimNom" name="nomA" class="txtRC" value="<%=alim.getNombre()%>">
                    <label class="labRC">Estado:</label>
                    <input type="text" id="cEstado" name="estA" class="txtRC" value="<%=alim.getEstado()%>">
                    <input type="submit" onclick="return validarDatos()" value="Actualizar" class="addRC">
                  </form>
                <%
                }else{
                %>
                <form action="agregarAlimentos">
                    <label class="labRC">Alimento:</label>
                    <input type="text" id="cAlimNom" name="nomA" class="txtRC">
                    <label class="labRC">Estado:</label>
                    <input type="text" id="cEstado" name="estA" class="txtRC">
                    <input type="submit" onclick="return validarDatos()" value="Agregar" class="addRC">
                  </form>
                <%}%>
    <h3 id="titulo">Lista de <span>Intensidades</span></h3>
    <form>
        <table class="content-table">
        <thead>
            <tr>
            <th id=""></th>
            <th id="">ID</th>
            <th id="">Nombre</th>
            <th id="">Estado</th>
            </tr>
        </thead>
        <tbody>
            <%
                            Vector<CAlimentos> listaAlimentos = new CAlimentos().listaAlimentos();

                    for(CAlimentos alim : listaAlimentos){
                        %>
                        <tr>
                            <td><input type="radio" name="select" value="<%=alim.getId()%>" class="radio-button"></td>
                            <td><%=alim.getId()%></td>
                            <td><%=alim.getNombre()%></td>
                            <td><%=alim.getEstado()%></td>
                        </tr>
                                    <%
                    }
            %>
        </tbody>
        </table>
        <div class="accionesB">
            <input type="submit" formaction="actAlimentos" value="Editar" class="boton-accion" id="edit">
            <input type="submit" formaction="eliminarAlimentos" value="Eliminar" class="boton-accion" id="delete">
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
