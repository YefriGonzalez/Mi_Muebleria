<%-- 
    Document   : consultaVentas
    Created on : 2/09/2021, 00:38:58
    Author     : yefri
--%>

<%@page import="com.mycompany.mimuebleria.DB.Conexion"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    ResultSet result = null;
    ResultSet result2=null;
    ResultSet result3=null;
    ResultSet result4=null;
    ResultSet result5=null;
%>
<%
    PreparedStatement consulta = (PreparedStatement) Conexion.conexion().prepareStatement("SELECT  *FROM ensamble_mueble a WHERE NOT EXISTS (SELECT NULL FROM venta b WHERE a.mueble=b.mueble)");
    result = consulta.executeQuery();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <title>CONSULTA</title>
    </head>
    <body>
        <h1></h1>
    <li id="back" class="btn btn-default btn-lg">
        <a href="../ventasJsp.jsp"> Regresar</a>
    </li>
    <div>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th class="text-center">Mueble</th>
                    <th class="text-center">Costo</th>
                    <th class="text-center">Fecha de ensamble</th>
                </tr>
            </thead>
            <tbody>
                <%                    if (result != null ) {
                        while (result.next()) {

                %>
                <tr>
                    <td class="text-center"><%=result.getString(1)%></td>
                    <td class="text-center"><%=result.getString(4)%></td>
                    <td class="text-center"><%=result.getString(3)%></td>
                </tr>
                <%                        }
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
