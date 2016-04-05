<%-- 
    Document   : bygningsliste
    Created on : 02-04-2016, 17:48:01
    Author     : Lasse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- JSP autogenererer ikke den nedenunderske linje, som er nødvendig for at få et korrekt zoomniveau på telefoner -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="newcss.css">
    </head>
    <body>
        <fieldset>
            <legend> <img src="polygon-logo-small.png"/></legend>
            <div align="center">
                <h1>Bygningsliste</h1>
                <table class="storliste">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Parcel ID</th>
                        <th>Size</th>
                        <th>Plan</th>
                        <th>Condition</th>
                    </tr>

                    <%
                        for (int i = 1; i <= 50; i++) {
                            if (i <= 5) {
                                out.print("<tr style=\"background: yellow;\">");
                            } else {
                                out.print("<tr>");
                            }
                            out.print("<td>" + i + "</td>");
                            out.print("<td>Placeholder</td>");
                            out.print("<td>Placeholder</td>");
                            out.print("<td>" + ((i + 2) * i) + "</td>");
                            out.print("<td>3</td>");
                            out.print("<td>Placeholder</th>");
                            out.print("<td>");
                            if ((i / 2) * 2 == i) {
                                out.print("<div class=\"cndGood\">Good</div>");
                            } else {
                                out.print("<div class=\"cndBad\">Bad</div>");
                            }
                            out.print("</td>");
                            out.print("</tr>");
                        }
                        out.print("</table>");
                    %>
                </table>
            </div>
        </fieldset>
    </body>
</html>
