<%-- 
    Document   : administracionJsp
    Created on : 21/08/2021, 22:57:46
    Author     : yefri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css1/administracioncss.css" rel="stylesheet"/>
        <title>Area de Administracion|Mi Muebleria</title>
    </head>
    <body>
        <header>
            Area Financiera y Administracion
        </header>
        <div class="logout">
             <ul class="cerrarSesion">
                <li><a href="CerrarSesion">Cerrar Sesion</a></li>
            </ul>
        </div>
       
         <div class="archivoCarga">
            <form class="archivo" method="POST" action="CargaArchivo_Servlet" enctype="multipart/form-data">
                <input type="file" name="fileCarga" required>
                <input type="submit" value="Enviar Archivo">
            </form>
        </div>
    </body>
</html>
