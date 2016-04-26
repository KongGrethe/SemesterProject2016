<%-- 
    Document   : bygningside
    Created on : 06-04-2016, 14:51:14
    Author     : Lasse
--%>
<%@page import="Service.Entity.Notification"%>
<%@page import="java.util.List"%>
<%@page import="Service.Entity.Files"%>
<%@page import="DataAccess.DBFacade"%>
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

            
            <div align="center">
                <h1>Bygning <%
                    out.print(request.getParameter("bid"));
                    %></h1>
                <a href="bygningsliste.jsp">Gå tilbage til bygningslisten</a><br><br>
                <table>
                    <tr>
                        <th>ID</th>
                        <td><%out.print(request.getParameter("bid"));%></td>
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
                    <%
                        DBFacade dbf = new DBFacade();
                        List<Files> hej = dbf.selectAllFiles(Integer.parseInt(request.getParameter("bid")));

                        System.out.println(hej.size());
                        for (int i = 0; i < hej.size(); i++) {
                            out.print("<tr>");

                            out.print("<td><a href=\"test/" + hej.get(i).getfName() + "\">" + hej.get(i).getfName() + "</a>" + "</td><td>" + hej.get(i).getFK_uID() + "</td>");
                            out.print("</tr>");
                        }

                    %>
                    <tr>
                        <td colspan="2" style="background: #eee;">
                            <form action="perbygningservlet" enctype="multipart/form-data" method="post">
                                <input type="hidden" name="job" value="file">
                                <input type="file" name="file" id="file">

                                <%                                out.print("<input type=\"hidden\" name=\"bid\" value=\"" + request.getParameter("bid") + "\">");
                                    out.print("<input type=\"hidden\" name=\"uid\" value=\"" + session.getAttribute("brugerid") + "\">");
                                %>
                                <input type="submit">
                            </form>
                        </td>
                    </tr>
                </table>
                <br>
                <br>
                <table>
                    <tr>
                        <th>Besked</th>
                        <th>Bruger</th>
                    </tr>
                    <%
                        List<Notification> hejsa = dbf.selectBuildingNotification(2);

                        for (int i = 0; i < hejsa.size(); i++) {
                            out.print("<tr>");
                            out.print("<td>");
                            out.print(hejsa.get(i).getContent());
                            out.print("</td>");
                            out.print("<td>");
                            out.print(hejsa.get(i).getFK_bID());
                            out.print("</td>");
                            out.print("</tr>");
                        }
                    %>
                    <tr>
                        <td colspan="2" style="background: #eee;">
                            <form action="perbygningservlet" method="get">
                                <input type="hidden" name="job" value="msg">
                                <%                                out.print("<input type=\"hidden\" name=\"bid\" value=\"" + request.getParameter("bid") + "\">");
                                    out.print("<input type=\"hidden\" name=\"uid\" value=\"" + session.getAttribute("brugerid") + "\">");
                                %>
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
        </fieldset>
    </body>
</html>
