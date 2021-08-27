<%-- 
    Document   : ventasJsp
    Created on : 21/08/2021, 22:58:02
    Author     : yefri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/ventascss.css" rel="stylesheet">
        <title>Area de Ventas | Mi Muebleria</title>
    </head>
    <body>
        <header>Areá de Ventas</header>
        <div class="logout">
             <ul class="cerrarSesion">
                <li><a href="CerrarSesion">Cerrar Sesion</a></li>
            </ul>
        </div>
        <div class="ventas">
            <nav class="nav">
                <ul class="menu">
                    <li id="sub"><a href="">Consultas</a>
                        <ul class="submenu">
                            <li><a href="">Consulta de Muebles disponibles en la sala de Ventas</a>
                            <li><a href="">Consulta de Ventas del dia</a></li>
                            <li><a href="">Consulta de compras de un Cliente en un intervalo de tiempo</a>
                                <form method="POST" action="">
                                    <input type="number" name="nitClienteConsultaCompra" placeholder="NIT" required>
                                    <h1></h1>
                                    <input type="date" name="fechaConsultaCompras" placeholder="Fecha">
                                    <h1></h1>
                                    <input type="submit" value="Consultar">
                                </form>
                            </li>
                            <li><a href="">Consulta de devoluciones Realizadas por un cliente en un intervalo de tiempo</a>
                                <form method="POST" action=""> 
                                    <input type="number" name="nitClienteConsultaDevolucion" placeholder="NIT" required>
                                    <h1></h1>
                                    <input type="date" name="fechaConsultaDevoluciones" placeholder="Fecha">
                                    <h1></h1>
                                    <input type="submit" value="Consultar">
                                </form>
                            </li>

                    </li>
                    <li><a href="">Detalle de la factura de un cliente</a>
                        <form method="POST" action="">
                            <input type="number" name="nitFactura" placeholder="NIT" required/>
                            <h1></h1>
                            <input type="submit" value="Consultar">
                        </form>
                    </li>
                </ul>
                </li>
                <li><a href="">Venta de Mueble</a>
                    <form class="form">
                        <input type="text" name="tipoMuebleVenta" placeholder="Tipo de Mueble"required />
                        <h3>Datos de Cliente</h3>
                        <input type="number" name="nitClienteVenta" placeholder="NIT" required />
                        <h1></h1>
                        <input type="text" name="nombreClienteVenta" placeholder="Nombre" required/>
                        <h1></h1>
                        <input type="text" name="direccionClienteVenta" placeholder="Direccion" required/>
                        <h1></h1>
                        <input type="submit" value="Vender Mueble"/>
                    </form>
                </li >
                <li><a href=""> Devolucion de Mueble</a>
                    <form class="form">
                        <input type="text" name="tipoMuebleDevolucion" placeholder="Tipo de Mueble" required/>
                        <h3>Datos de Cliente</h3>
                        <input type="number" name="nitClienteVenta" placeholder="NIT" required/>
                        <h1></h1>
                        <input type="submit" value="Devolver Mueble"/>
                    </form>
                </li>
                </ul>
            </nav>
        </div>
    </body>
</html>
