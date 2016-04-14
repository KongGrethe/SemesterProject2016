<%-- 
    Document   : bygningside
    Created on : 06-04-2016, 14:51:14
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
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="newcss.css">
    </head>
    <body>
        <div align="center">
            <h1>Bygning #23456765</h1>
            <a href="bygningsliste.jsp">Gå tilbage til bygningslisten</a><br><br>
            <table>
                <tr>
                    <th>ID</th>
                    <td>placeholder</td>
                </tr>
                <tr>
                    <th>Parcelnummer</th>
                    <td>placeholder</td>
                </tr>
                <tr>
                    <th>EtagePlan</th>
                    <td>placeholder</td>
                </tr>
                <tr>
                    <th>Tilstand</th>
                    <td>placeholder</td>
                </tr>
                <tr>
                    <th>Oprettet af</th>
                    <td>placeholder</td>
                </tr>
                <tr>
                    <th>Navn</th>
                    <td>placeholder</td>
                </tr>
                <tr>
                    <th>Adresse</th>
                    <td>placeholder</td>
                </tr>
                <tr>
                    <th>Størrelse</th>
                    <td>placeholder</td>
                </tr>
            </table>
            <br>
            <hr>
            <br>
            <table>
                <tr>
                    <th>Filnavn</th>
                    <th>Bruger</th>
                </tr>
                <tr>
                    <td>sample.jpg</td>
                    <td>(1) Aron</td>
                </tr>
                <tr>
                    <td colspan="2" style="background: #eee;">
                        <form action="perbygningservlet" enctype="multipart/form-data" method="post">
                            <input type="hidden" name="job" value="file">
                            <input type="file" name="file" id="file">
                            <input type="submit">
                        </form>
                    </td>
                </tr>
                <%
                    if(session.getAttribute("besked") != null) {
                        out.print("<div>" + session.getAttribute("besked") + "</div>");
                        session.setAttribute("besked", null);
                    }
                %>
            </table>
            <br>
            <br>
            <table>
                <tr>
                    <th>Bruger</th>
                    <th>Besked</th>
                </tr>
                <tr>
                    <td>Aron (1)</td>
                    <td>hejsa denne bygning styrer</td>
                </tr>
                <tr>
                    <td colspan="2" style="background: #eee;">
                        <form action="NotificationServlet" method="post">
                            <input type="text" name="content">
                            <input type="submit">
                        </form>
                    </td>
                </tr>
            </table>
            <br>
            <hr>
            <img src="cndlevels.png"/><br>
        </div>
    </body>
</html>
