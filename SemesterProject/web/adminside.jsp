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
        <fieldset>
            <legend> <img src="polygon-logo-small.png"/></legend>
            
            <div align="center">
                <!-- Main Div -->
                <div><h1>Velkommen Polygon employee</h1></div>
                <div><font size="5">Dette er employee siden.</div><br>


                <!-- Menu Div -->
                <div><font size="5">
                    <li><a href="bygningside.jsp?bid=1">Bygningsiden</a></li><br>
                    <li><a href="brugerliste.jsp">Liste af alle brugere</a></li><br>
                    <li><a href="checkupliste.jsp">Liste af alle checkup rapporter</a></li><br>
                    <li><a href="brugeroprettelse.jsp">Opret Bruger</a></li><br>
                    <li><a href="createreport.jsp">Opret Rapport</a></li><br>
                </div>
            </div>
        </fieldset>
    </body>
</html>