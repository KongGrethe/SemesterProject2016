<%-- 
    Document   : BygningsOprettelse
    Created on : 04-04-2016, 21:40:59
    Author     : christian
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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="newcss.css">
        <title>Opret Bygning</title>

    </head>
    <body>
        <%
            //out.println(session.getAttribute("brugerid") + "-" + session.getAttribute("brugertype"));
        %>
        <fieldset>
            <legend> <img src="polygon-logo-small.png"/></legend>
            <li><a href="brugerside.jsp">Brugersiden</a></li><br>
            <li><a href="bygningsliste.jsp">Bygningslisten</a></li>
            <div align="center">
            <div><font size="5">Du kan oprette en bygning her.</div>
            <form action="buildingservlet" method="post">
                <table>
                    <tr>
                        <td>Navn</td>
                        <td><input type="text" name="bName" autocomplete="off"></td>   
                    </tr>
                    <tr>
                        <td>Adresse</td>
                        <td><input type="text" name="bAddress" autocomplete="off"></td>   
                    </tr>
                    <tr>
                        <td>Parcelnummer</td>
                        <td><input type="text" name="parcelNr" autocomplete="off" pattern="\d*" title="Kun tal"></td>   
                    </tr>
                    <tr>
                        <td>Størrelse</td>
                        <td><input type="text" name="bSize" autocomplete="off" pattern="\d*" title="Kun tal"></td>   
                    </tr>
                    <tr>
                        <td>Etager</td>
                        <td><input type="text" name="bfPlan" autocomplete="off" pattern="\d*" title="Kun tal"></td>   
                    </tr>
                    <%
                        //jeg kunne åbenbart ikke få session fra servletten, så jeg generer den som inputtype hidden og tager som parameter
                        out.print("<input type=\"hidden\" name=\"FK_uID\" value=\"");
                        out.print(session.getAttribute("brugerid"));
                        out.print("\"/>");
                    %>
                    <button name="job" value="add">Opret</button>
                </table>
            </form>
            </div>
        </fieldset>
    </body>
</html>
