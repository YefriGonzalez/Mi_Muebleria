<%-- 
    Document   : Editar
    Created on : 31/08/2021, 01:45:50
    Author     : yefri
--%>

<%@page import="com.mycompany.miMuebleria.Pieza"%>
<%@page import="com.mycompany.mimuebleria.DB.DBPieza"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! Pieza pieza;%>

<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDIT</title>
    </head>
    <body>
        <header>
            Editar
        </header>
        <div>
            <form method="POST" class="form-control" style="width: 500px">
                ID:
                <input type="text" readonly name="idPieza" class="form-control" value="${pieza.id}">
                Tipo:
                <input type="text" name="tipoPieza" required class="form-control" value="${pieza.tipoPieza}"/>
                Costo
                <input type="text" name="costoPieza"  required step="0.01" class="form-control" value="${pieza.costoPieza}">
                <br>
                <input type="submit">
                <a href="piezasJsp.jsp"></a>
            </form>
        </div> 
    </body>
</html>

<%
    String tipoPieza;
    String costoPieza;
    tipoPieza=request.getParameter("tipoPieza");
    costoPieza=request.getParameter("costoPieza");
    DBPieza db = new DBPieza();
    Integer id = Integer.parseInt(request.getParameter("id"));
    pieza = db.list(id);
    if (tipoPieza!=null && costoPieza!=null) {
            Pieza pieza=new Pieza(tipoPieza,request.getParameter("id"),costoPieza);
            if (db.edit(pieza)) {
                    response.sendRedirect("Piezas_Servlet");
                }

    }

%>
