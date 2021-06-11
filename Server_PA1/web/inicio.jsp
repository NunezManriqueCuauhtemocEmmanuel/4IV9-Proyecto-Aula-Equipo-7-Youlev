<%-- 
    Document   : inicio
    Created on : 10/06/2021, 10:05:06 PM
    Author     : adrai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/inicio.css">
    <link href="css/estilos.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/a78d4ea77b.js" crossorigin="anonymous"></script>
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
    <h2 id="titulo">Bienvenido</h2>

    <div class="container">
      <span class="big-circle"></span>
      <div class="form">
        <div class="contact-info">
          <h3 class="title">¡¡¡Momento de iniciar!!!</h3>
          <p class="text">
            Es el momento, ingresa tu usuario y contraseña 
            y comienza una nueva forma de vida
          </p>

          <div class="info">
            <div class="information">
              <img src="img/location.png" class="icon" alt="" />
              <p>Elaborado por</p>
            </div>
            <div class="information">
              <p>Arana Chavez Emiliano</p>
            </div>
            <div class="information">
              <p>Lizarraga Anguiano Jesus Adrian</p>
            </div>
            <div class="information">
              <p>Núñez Manrique Cuauhtemoc Emmanuel</p>
            </div>
            <div class="information">
              <p>Orduña Melendez Arantza</p>
            </div>
            <div class="information">
              <p>Regalado Zuñiga Leonardo Daniel</p>
            </div>
            <div class="information">
              <p>Trujillo Rodriguez Fernanda</p>
            </div>
          </div>

          <div class="social-media">
            <p>Contactanos</p>
            <div class="social-icons">
              <a href="#">
                <i class="fab fa-facebook-f"></i>
              </a>
              <a href="#">
                <i class="fab fa-twitter"></i>
              </a>
              <a href="#">
                <i class="fab fa-instagram"></i>
              </a>
              <a href="#">
                <i class="fas fa-envelope"></i>
              </a>
            </div>
          </div>
        </div>

        <div class="contact-form">
          <span class="circle one"></span>
          <span class="circle two"></span>

          <form class="form-login" method="POST">
            <h5>Iniciar Sesión</h5>
            <input class="controls" type="text" name="usuario" value="" placeholder="Usuario">
            <input class="controls" type="password" name="pass" value="" placeholder="Contraseña">
            <input class="buttons" formaction="iniciarSesion" type="submit" name="" value="Ingresar Usuario">
            <input class="buttons" type="submit" name="" value="Ingresar Nutriologo">
            <p><a href="#">¿Olvidaste tu Contraseña?</a></p>
          </form>
        </div>
      </div>
    </div>

</body>
</html>
