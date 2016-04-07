<%-- 
    Document   : brugerside
    Created on : 07-04-2016, 13:34:53
    Author     : Michael
--%>
<%
    if (session.getAttribute("login") == null) 
    {
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
        <h1>Velkommen til</h1>
        <div>This is the customer page.</div>
        <a href="BygningsOprettelse.jsp">Opret bygning</a><br>
        </fieldset>
    </body>
</html>
