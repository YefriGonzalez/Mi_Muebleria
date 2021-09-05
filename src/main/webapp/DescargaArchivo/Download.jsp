<%-- 
    Document   : Download
    Created on : 5/09/2021, 04:02:38
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
        <h1>Hello World!</h1>
        <a href="DownloadServlet?path=<%=request.getParameter("archivo")%>">Descargar</a>
    </body>
</html>
