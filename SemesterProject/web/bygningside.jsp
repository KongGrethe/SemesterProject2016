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
            <h1>Bygning <%
            out.print(request.getParameter("bid"));
        %></h1>
        <%
        out.print("<b>" + session.getAttribute("bid") + "</b>");
        %>
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
                            
                            <%
                            out.print("<input type=\"hidden\" name=\"bid\" value=\"" + session.getAttribute("bid") + "\">");
                            out.print("<input type=\"uid\" name=\"uid\" value=\"" + session.getAttribute("brugerid") + "\">");
                            %>
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
                    <th>Besked</th>
                    <th>Bruger</th>
                </tr>
                <tr>
                    <td>Aron (1)</td>
                    <td>hejsa denne bygning styrer</td>
                </tr>
                <tr>
                    <td colspan="2" style="background: #eee;">
                        <form action="perbygningservlet" method="get">
                            <input type="hidden" name="job" value="msg">
                            <input type="hidden" name="FK_bID" value="1">
                            <input type="text" name="content" autocomplete="off">
                            <input type="submit">
                        </form>
                    </td>
                </tr>
            </table>
            <br>
            <hr>
            <img src="cndlevels.png" style="max-width: 100%;">
        </div>
    </body>
</html>
