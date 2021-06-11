<%-- 
    Document   : registron
    Created on : 10/06/2021, 10:05:24 PM
    Author     : adrai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro Nutriologo</title>
    <link href="./css/registrou.css" rel="stylesheet" type="text/css">
    <link href="./css/estilos.css" rel="stylesheet" type="text/css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a78d4ea77b.js" crossorigin="anonymous"></script>
    <script src="./js/val.js"></script>
    <script>
      function soloLetras(e){
        key = e.keyCode;
        tecla = String.fromCharCode(key).toLowerCase();
        letras = "áéíóúabcdefghijklmnñopqrstuvwxyz";
        especiales = "8-37-39-46";

        tecla_especial = false
        for(var i in especiales){
          if(key == especiales[i]){
            tecla_especial = true;
            if(e.keyCode == 13) {window.document.getElementById("nombre").focus()}
            break;
          }
        }
        if(letras.indexOf(tecla)==-1 && !tecla_especial){
          return false;
        }
      }
    </script>
</head>
<body>
    <header class="header">
        <nav class="nav">
          <a href="#" class="logo nav-link">Santé et vie</a>
          <button class="nav-toggle" aria-label="Abrir menú">
            <i class="fas fa-bars"></i>
          </button>
          <ul class="nav-menu">
            <li id="full" class="btn btn--4">
                <a href="index.html" class="nav-menu-link">Inicio</a>
            </li>
          </ul>
        </nav>
    </header>
    <h1 id="titulo">Santé et vie</h1>
    <h2 id="titulo">Registro Nutriologo</h2>
    <section class="homeim">
      <div class="in-flex-1">
        <form name="formulario" onsubmit="return validar(this)" action="registrarNutri">
          <h3 id="titulo">Crea una cuenta</h3>
          <div class="contenedor-inputs">
            <label id="titulo">Nombre</label>
            <input type="text" name="nombre" placeholder="Nombre" onkeypress="return soloLetras(event)" required>
            <br>
            <br>
            <label id="titulo">Apellido Paterno</label>
            <input type="text" name="appa" placeholder="Apellido Paterno" onkeypress="return soloLetras(event)" required>
            <br>
            <br>
            <label id="titulo">Apellido Materno</label>
            <input type="text" name="apma" placeholder="Apellido Materno" onkeypress="return soloLetras(event)" required>
            <br>
            <br>
            <label id="titulo">Fecha de nacimiento</label>
            <input type="date" name="nacimiento" required>
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
            <label id="titulo">Usuario</label>
            <input type="text" name="user" placeholder="Usuario" required>
            <br>
            <br>
            <label id="titulo">Contraseña</label>
            <input type="password" name="contrasena" placeholder="Contraseña" required>
            <br>
            <br>
            <input class="buttons" type="submit" name="" value="Registrar">
          </div>
        </form>
      </div>
  </section>
  <script src="js/val.js"></script>
  <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  <script src="js/sweetAlert.js"></script>
</body>
</html>
