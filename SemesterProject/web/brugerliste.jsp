<%-- 
    Document   : brugerliste
    Created on : 04-04-2016, 22:29:20
    Author     : Lasse
--%>

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
                    for (int i = 1; i <= 50; i++) {
                        out.print("<tr>");
                        out.print("<td>" + i + "</td>");
                        out.print("<td>Placeholder</td>");
                        out.print("<td>Placeholder</td>");
                        out.print("<td>Placeholder</td>");
                        out.print("<td>Placeholder@hotmail.com</td>");
                        out.print("<td>Customer</th>");
                        out.print("<td>" + i + "</td>");
                        out.print("</tr>");
                    }
                    out.print("</table>");
                %>
            </table>
        </div>
    </body>
</html>
