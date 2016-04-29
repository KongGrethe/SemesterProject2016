<%-- 
    Document   : brugerliste
    Created on : 04-04-2016, 22:29:20
    Author     : Michael
--%>
<%@page import="Service.EntityFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Service.Entity.User"%>
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
            <br>
            <div align="center">
            
                <%
                    System.out.println(session.getAttribute("brugertype"));
                    Integer bt = (Integer) session.getAttribute("brugertype");
                    if (bt == 2) {
                        out.print("<a href=\"adminside.jsp\">Adminside</a>");
                    }
                %>
                <h1>Brugerliste</h1>
                <table class="storliste">
                    <tr>
                        <th>ID</th>
                        <th>Fornavn</th>
                        <th>Efternavn</th>
                        <th>Password</th>
                        <th>Email</th>
                        <th>Rolle</th>
                        <th>Oprettet af</th>
                    </tr>

                    <%
                        EntityFacade ef = new EntityFacade();

                        ArrayList<User> list = (ArrayList<User>) ef.selectUsers();

                        if (list != null) {

                            for (int i = 0; i < list.size(); i++) {
                                out.println("<tr><td>"
                                        + list.get(i).getuID()
                                        + "</td><td>"
                                        + list.get(i).getuFName() + "</td><td>"
                                        + list.get(i).getuLName() + "</td><td>"
                                        + list.get(i).getUpw() + "</td><td>"
                                        + list.get(i).getEmail() + "</td><td>"
                                        + list.get(i).getUserRole() + "</td><td>"
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
