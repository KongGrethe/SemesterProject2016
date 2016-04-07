<%-- 
    Document   : Userfrontpage
    Created on : 04-04-2016, 15:43:27
    Author     : christian
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
        <title>Velkommen!</title>
    </head>
    <body>
        <fieldset>
            <legend> <img src="polygon-logo-small.png"/></legend>
            <a href="bygningsliste.jsp">Liste over bygninger</a><br><br>
            <a href="BygningsOprettelse.jsp">Opret ny bygnyng</a>

            <h1>Velkommen <%=session.getAttribute("uFName")%></h1> <!--Siger hej "navn" -->
        </fieldset>

    </body>
</html>
