
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/fabricaCss.css" rel="stylesheet"/>
        <title>Area de Fabrica | Mi Muebleria</title>
    </head>
    <body>  
        <header>Area de Fabrica</header>
        <div class="logout">
             <ul class="cerrarSesion">
                <li><a href="CerrarSesion">Cerrar Sesion</a></li>
            </ul>
        </div>
        <div class="fabrica">
            <nav class="navegacion">
                <ul class="menu">
                    <li><a href="#">Crear Pieza</a>
                        <form class="form" method="POST" action="">
                            <input type="text" name="nombreCrearPieza" placeholder="Nombre de la pieza" required>
                            <hr>
                            <input type="number" name="costoCrearPieza" placeholder="Costo de la pieza" required>
                            <hr>
                            <input type="submit" value="Crear Pieza">
                        </form> 
                    </li>
                    <li><a href="#">Eliminar Pieza</a>
                        <form class="form" method="POST" action="">
                            <input type="text" name="nombreEliminarPieza" placeholder="Nombre de la pieza" required>
                            <hr>
                            <input type="number" name="cantidadPiezaEliminar" placeholder="Numero de Piezas" required>
                            <hr>
                            <input type="submit" value="Eliminar Piezas">
                        </form> 
                    </li>
                    <li><a href="#">Modificar Pieza</a>
                        <form class="form" method="POST" action="">
                            <input type="text" name="nombreCrearPieza" placeholder="Nombre de la pieza" required>
                            <hr>
                            <input type="number" name="costoCrearPieza" placeholder="Costo de la pieza" required>
                            <hr>
                            <input type="text" name="nuevonombreCrearPieza" placeholder="Nuevo Nombre de la pieza" required>
                            <hr>
                            <input type="number" name="nuevocostoCrearPieza" placeholder="Nuevo Costo de la pieza" required>
                            <hr>
                            <input type="submit" value="Modificar Pieza">
                        </form> 
                    </li>
                    <li><a href="#">Ensamblar Muebles a partir de Piezas</a>
                        <form class="form" method="POST" action="">
                            <input type="text" name="tipoMueble" placeholder="Tipo de Mueble" required>
                            <hr>
                            <input type="text" name="nombreUsuario" placeholder="Nombre de Usuario" required>
                            <hr>
                            <input type="date" name="fechaEnsamble" placeholder="Fecha de Ensamble" required>
                            <hr>
                            <input type="submit" value="Ensamblar Mueble">
                        </form>
                    </li>
                    <li><a href="">Consultar Informacion de los muebles Creados</a></li>
                    <li><a href="">Consultar cantidad de Piezas</a></li>
                    <li><a href="hola">Cargar Archivo</a>
                        
                    </li>
                </ul>
            </nav>
        </div>
    </body>
</html>
