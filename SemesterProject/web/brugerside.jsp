<%-- 
    Document   : brugerside
    Created on : 07-04-2016, 13:34:53
    Author     : Michael
--%>
<%
    if (session.getAttribute("brugerid") == null) {
        response.sendRedirect("index.html");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="newcss.css">
        <title>Brugerside</title>
    </head>
    <body>
        <fieldset>
            <legend> <img src="polygon-logo-small.png"/></legend>
            <div align="center">
                <h1>Velkommen til Polygon!</h1>
                <div><font size="5">Her er dine muligheder som kunde.</div><br>
                <div><font size="5">
                    <li><a href="BygningsOprettelse.jsp">Opret bygning</a></li><br>
                    <li><a href="bygningsliste.jsp">Se bygningslisten</a></li><br>
                </div>
            </div>
        </fieldset>
    </body>
</html>
