<%-- 
    Document   : indexlogin
    Created on : 21/08/2021, 20:02:38
    Author     : yefri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi Muebleria|Login</title>
        <link href="css/estiloLogin.css" rel="stylesheet" type="text/css"/>
        <link href="css/fontello.css" rel="stylesheet"/>
    </head>
    <body>
        <header>
            <h1>Mi Muebleria</h1>
        </header>
        <div class="contenedor1">
            <h1>Sign in</h1>
            <form class="form1" method="POST" action="usuario-servlet">
                <img src="Imagenes/icono.png"/>
                <input type="text" name="username" placeholder="Username" required="Ingresa Usuario"/>
                <hr>
                <img src="Imagenes/icono.png"/>
                <input type="password" name="password" placeholder="Password" required="Ingresa la contraseña"/>
                <hr>
                <input type="submit" value="Sign In"/>
            </form>
            <div class="referencias">
                <a href="">Term Of Use</a>
                <a href="">Privacy Police</a>
            </div>
        </div>
        <div class="MasOpciones">
            <input type="checkbox" id="btn-mas">
            <div class="redes">
                <a href="https://twitter.com/" class="icon-twitter"></a>
                <a href="https://www.facebook.com/" class="icon-facebook"></a>
                <a href="https://www.youtube.com/" class="icon-youtube-play"></a>
            </div>
            <div class="btn-mas">
                <label for="btn-mas" class="icon-plus"></label>
            </div>
        </div>    
        <footer class="pie">
            <h1> Mi Muebleria © Todos los Derechos Reservados 2021.</h1>
        </footer>
    </body>
</html>