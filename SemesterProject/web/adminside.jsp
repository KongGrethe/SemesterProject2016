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
        <link rel="stylesheet" href="Design.css">
        <title>Admin side</title>
    </head>
    <body>
        <!-- Head Div -->
        <div id="head">

            <!-- Top Div -->
            <div ID="top">
                <img src="polygon-logo-small.png"/>
            </div>

            <!-- Main Div -->
            <div ID="main">
                <h1>Velkommen admin</h1>
                Dette er adminstrator siden.
            </div>


            <!-- Menu Div -->
            <div ID="menu">
                <ul>
                    <li><a href="bygningside.jsp?bid=1">Genvej til Bygningside</a></li>
                    <li><a href="brugerliste.jsp">List all users</a></li>
                    <li><a href="brugeroprettelse.jsp">Create new user</a></li>
                </ul>
            </div>
        </div>
    </body>
</html>
