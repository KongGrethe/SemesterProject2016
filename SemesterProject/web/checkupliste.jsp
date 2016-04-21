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
                        <th>UsersID</th>
                        <th>BuildingsID</th>
                    </tr>

                    <%
                        EntityFacade ef = new EntityFacade();

                        ArrayList<Checkup> list = (ArrayList<Checkup>) ef.selectCheckups();

                        if (list != null) {

                            for (int i = 0; i < list.size(); i++) {
                                out.println("<tr><td>"
                                        + list.get(i).getCheckupid()
                                        + "</td><td>"
                                        + list.get(i).getCheckName() + "</td><td>"
                                        + list.get(i).getCheckAddress() + "</td><td>"
                                        + list.get(i).getCheckPostnr() + "</td><td>"
                                        + list.get(i).getCheckdato() + "</td><td>"
                                        + list.get(i).getCheckFileName() + "</td><td>"
                                        + list.get(i).getFK_uID() + "</td><td>"
                                        + list.get(i).getFK_bID() + "</td>"
                                        + "<td><form action=\"userservlet\" method=\"post\">");
                            }
                        }
                    %>
                </table>
            </div>
        </fieldset>
    </body>
</html>
