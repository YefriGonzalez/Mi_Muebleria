<%-- 
    Document   : varios
    Created on : 28/08/2021, 15:25:18
    Author     : yefri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1>Carga De Archivos</h1>

                    <c:if test="${msg.error}">
                        <h2>Resultado Exitoso</h2>
                        <p>${msg.errorMsg}</p>
                    </c:if>
                    <a class="btn btn-outline-primary" href="fabricajsp.jsp">Regresar!</a>
                </div>
            </div>
    </body>
</html>
