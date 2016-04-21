<%-- 
    Document   : checkupliste
    Created on : 20-04-2016, 15:02:11
    Author     : Michael
--%>

<%@page import="Service.Entity.Checkup"%>
<%@page import="Service.EntityFacade"%>
<%@page import="java.util.ArrayList"%>
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
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="newcss.css">
    </head>
    <body>
        <fieldset>
            <legend> <img src="polygon-logo-small.png"/></legend>
            <%
                System.out.println(session.getAttribute("brugertype"));
                Integer bt = (Integer) session.getAttribute("brugertype");
                if (bt == 2) {
                    out.print("<a href=\"adminside.jsp\">tilbage til adminside</a>");
                }
            %><br>
            <a href="adminside.jsp">Adminsiden</a>
            <div align="center">
                <h1>Checkup rapport liste</h1>
                <table class="storliste">
                    <tr>
                        <th>ID</th>
                        <th>Navn</th>
                        <th>Addresse</th>
                        <th>Post-Nummer</th>
                        <th>Dato</th>
                        <th>Filnavn</th>
                        <th>Bygge år</th>
                        <th>Bygge areal</th>
                        <th>Formål</th>
                        <th>Tag</th>
                        <th>Ydervæg</th>
                        <th>Forfald</th>
                        <th>Tag filnavn</th>
                        <th>Ydervæg filnavn</th>
                        <th>Checkup udfører</th>
                        <th>Bygningsansvarlig</th>
                    </tr>

                    <%
                        EntityFacade ef = new EntityFacade();

                        ArrayList<Checkup> list = (ArrayList<Checkup>) ef.selectCheckups();

                        if (list != null) {

                            for (int i = 0; i < list.size(); i++) {
                                out.println("<tr><td>"
                                        + list.get(i).getcheckupID()
                                        + "</td><td>"
                                        + list.get(i).getDecay() + "</td><td>"
                                        + list.get(i).getuLName() + "</td><td>"
                                        + list.get(i).getUpw() + "</td><td>"
                                        + list.get(i).getEmail() + "</td><td>"
                                        + list.get(i).getUserRole() + "</td><td>"
                                        + list.get(i).getFK_cuID() + "</td><td>"
                                        + list.get(i).getFK_cuID() + "</td><td>"
                                        + list.get(i).getFK_cuID() + "</td><td>"
                                        + list.get(i).getFK_cuID() + "</td><td>"
                                        + list.get(i).getFK_cuID() + "</td><td>"
                                        + list.get(i).getFK_cuID() + "</td><td>"
                                        + list.get(i).getFK_cuID() + "</td><td>"
                                        + list.get(i).getFK_cuID() + "</td><td"
                                        + list.get(i).getFK_cuID() + "</td><td>"
                                        + list.get(i).getFK_cuID() + "</td>"
                                        + "<td><form action=\"userservlet\" method=\"post\">");
                            }
                        }
                    %>
                </table>
            </div>
        </fieldset>
    </body>
</html>
