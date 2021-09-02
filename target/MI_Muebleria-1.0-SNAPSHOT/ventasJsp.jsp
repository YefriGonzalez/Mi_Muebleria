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
        <link href="css1/ventascss.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <title>Area de Ventas | Mi Muebleria</title>
    </head>
    <body>
        <header>Areá de Ventas</header>
        <div class="logout">
            <ul class="cerrarSesion">
                <li><a href="index.jsp">Cerrar Sesion</a></li>
            </ul>
        </div>
        <div class="ventas">
            <nav class="nav">
                <ul class="menu">
                    <li><a href="muebleria/consultaVentas.jsp">Consulta de Muebles disponibles en la sala de Ventas</a>
                    <li><a href="">Consulta de Ventas del dia</a></li>
                    <li><a href="">Consulta de compras de un Cliente en un intervalo de tiempo</a>
                        <form method="POST" class="" action="">
                            NIT:
                            <input type="number" class="form-control" name="nitClienteConsultaCompra" placeholder="NIT" required>
                            Fecha:
                            <input type="date" class="form-control" name="fechaConsultaCompras" placeholder="Fecha">
                            <br>
                            <input type="submit" class="btn btn-danger" value="Consultar">
                        </form>
                    </li>
                    <li><a href="">Consulta de devoluciones Realizadas por un cliente en un intervalo de tiempo</a>
                        <form method="POST" action=""> 
                            NIT:
                            <input type="number"  class="form-control" name="nitClienteConsultaDevolucion" placeholder="NIT" required>
                            Fecha:
                            <input type="date" class="form-control" name="fechaConsultaDevoluciones" placeholder="Fecha">
                            <br>
                            <input type="submit" class="btn btn-danger" value="Consultar">
                        </form>
                    </li>
                    <li><a href="">Detalle de la factura de un cliente</a>
                        <form method="POST" action="">
                            <h3>Consulta</h3>
                            NIT:
                            <input type="number" class="form-control"name="nitFactura" placeholder="NIT" required/>
                            <br>
                            <input type="submit" class="btn btn-danger" value="Consultar">
                        </form>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="container">
            <form class="form-control" style="width: 500px; height: 440px;margin: auto;margin-top:10%"/>
            <h3>Venta de Mueble</h3>
            Tipo de mueble:
            <input type="text" class="form-control" name="tipoMuebleVenta" placeholder="Tipo de Mueble"required />
            <h4>Datos de Cliente</h4>
            NIT:
            <input type="text" class="form-control" name="nitClienteVenta" onclick="" placeholder="NIT" required />
        
            Nombre:
            <input type="text" class="form-control" name="nombreClienteVenta" placeholder="Nombre" required/>
            Direccion:
            <input type="text" class="form-control" name="direccionClienteVenta" placeholder="Direccion" required/>
            <br>
            <input type="submit"  class="btn btn-danger btn-small" value="Vender Mueble"/>
        </form>
    </div>
    <div class="container">
        <form class="form-control" style="width: 500px; height: 350px;margin: auto;margin-top:10%;margin-left: 650px">
            <h3>Devolucion de Mueble</h3>
            Mueble:
            <input type="text" class="form-control" name="tipoMuebleDevolucion" placeholder="Tipo de Mueble" required/>
            <h4>Datos de Cliente</h4>
            NIT:
            <input type="number" class="form-control" name="nitClienteVenta" placeholder="NIT" required/>
            <br>
            <input type="submit" class="btn btn-danger btn-sm" value="Devolver Mueble"/>
        </form>
    </div>
</body>
</html>

<%


%>