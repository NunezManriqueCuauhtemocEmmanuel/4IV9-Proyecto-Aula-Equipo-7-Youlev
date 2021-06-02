<%-- 
    Document   : NutCrud
    Created on : 6/05/2021, 10:48:32 PM
    Author     : levar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" >
            
            <div class="text-center mt-4 mb-4">
                <h1 class="">
                    
                    Esta es la gestion de Nutriologos
                </h1>
            </div>
            <div class="containerRegistro" >
                <form name="formularioregistro" action="RegistroUsu.jsp" method="POST">
                    <div class="row mb-3">
                        <div class="col">
                            <label>Nombre(S):</label>
                            <input class="form-control" type="text" name="nombre" size="15" >
                        </div>
                        <div class="col">
                            <label>Apellido Paterno:</label>
                            <input class="form-control" type="text" name="apellidop" size="15" >
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col">
                            <label>Apellido Materno:</label>
                            <input class="form-control" type="text" name="apellidom" size="15" >
                        </div>
                        <div class="col">
                            <label>Direccion:</label>
                            <input class="form-control" type="text" name="direccion" size="50" >
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col">
                            <label>Edad:</label>
                            <input class="form-control" type="number" name="edad" size="2" >
                        </div>
                        <div class="col">
                            <label>Telefono o Celular:</label>
                            <input class="form-control" type="text" name="telefono" size="10" >
                        </div>
                        <div class="col">
                            <label>Contraseña:</label>
                            <input class="form-control" type="password" name="contrasena" size="40" >
                        </div>
                    </div>
                    
                    <button class="btn btn-outline-success" type="submit" value="Registrar Usuario"> Registrar Usuario </button>
                    <button class="btn btn-outline-danger"  type="reset" value="Borrar Datos" >  Borrar </button>
                </form>
                
                
                
            </div>
            <br>
            <div class="containerConsulta" >
                <a href="index.html" class="btn btn-outline-danger">Regresar</a>
            </div>
        </div>
    </body>
</html>
