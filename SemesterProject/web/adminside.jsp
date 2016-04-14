<%-- 
    Document   : adminside
    Created on : 03-04-2016, 15:40:04
    Author     : Lasse
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
        <title>Admin side</title>
    </head>
    <body>
        <fieldset>
            <legend> <img src="polygon-logo-small.png"/></legend>
        <h1>Velkommen admin</h1>
        <div>This is the administrator page.</div>
        <a href="#" style="color: red;">Usage traffic</a><br>
        <a href="#" style="color: red;">Pending checkupreports</a> <span>(x pending)</span><br>
        <a href="#" style="color: red;">Emails</a><br>
        <a href="bygningside.jsp?bid=1">Genvej til Bygningside</a><br>
        <a href="brugerliste.jsp">List all users</a><br>
        <a href="brugeroprettelse.jsp">Create new user</a><br>
        </fieldset>
    </body>
</html>
