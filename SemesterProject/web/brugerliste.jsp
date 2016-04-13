<%-- 
    Document   : brugerliste
    Created on : 04-04-2016, 22:29:20
    Author     : Michael
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Service.Entity.User"%>
<%@page import="DataAccess.Datamappers.UserMapper"%>
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
                <a href="bygningsliste.jsp">Bygningslisten</a>
            <div align="center">
                <h1>Brugerliste</h1>
                <table class="storliste">
                    <tr>
                        <th>ID</th>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Password</th>
                        <th>Email</th>
                        <th>Userrole</th>
                        <th>Creator</th>
                    </tr>

                    <%
                        UserMapper um = new UserMapper();

                        ArrayList<User> list = (ArrayList<User>) um.getUsers();

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
