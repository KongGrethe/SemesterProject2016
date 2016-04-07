<%-- 
    Document   : brugeroprettelse
    Created on : 03-04-2016, 15:22:06
    Author     : Lasse & Christian
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
        <title>Opret bruger</title>
    </head>
    <body>

        <!-- her skal også være plads til en fejlbesked om at brugernavnet er taget -->
        <div align="center">
            <h1>Brugeroprettelse</h1>
            <a href="adminside.jsp">Tilbage til adminsiden</a><br><br>
            <%
                String em = (String) session.getAttribute("errormsg");
                if(em == null) {
                    out.print("<div>Beskeden er null.</div>");
                } else {
                    out.print("<div>Beskeden er: " + em + "</div>");
                }
            %>
            <form method="post" action="userservlet">
                <table>
                    <tr>
                        <td>First name</td>
                        <td><input type="text" name="firstname" autocomplete="off"></td>
                    </tr>
                    <tr>
                        <td>Last name</td>
                        <td><input type="text" name="lastname" autocomplete="off"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" name="password" autocomplete="off"></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" autocomplete="off"></td>
                    </tr>
                    <tr>
                         <td><input type="checkbox" name="accounttype" value="admin">Admin</input></td>
                         <td><button name="job" value="add">Opret</button></td>
                    </tr>
                </table>
                <div align="center" style="padding: 2em; color: grey;">Note: Your ID [ID] will be logged for making this user.</div>
            </form>
        </div>
    </body>
</html>
