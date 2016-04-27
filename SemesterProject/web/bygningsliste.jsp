<%-- 
    Document   : bygningsliste
    Created on : 02-04-2016, 17:48:01
    Author     : Michael
--%>
<%@page import="Service.EntityFacade"%>
<%
    if (session.getAttribute("brugerid") == null) {
        response.sendRedirect("index.html");
    }
%>

<%@page import="DataAccess.Datamappers.BuildingMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Service.Entity.Building"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bygningsliste</title>
        <!-- JSP autogenererer ikke den nedenunderske linje, som er nødvendig for at få et korrekt zoomniveau på telefoner -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="newcss.css">
    </head>
    <body>
        <fieldset>
            <div align="center">
                <legend> <img src="polygon-logo-small.png"/></legend>
                <h1>Bygningsliste</h1>


                <%
                    System.out.println(session.getAttribute("brugertype"));
                    Integer bt = (Integer) session.getAttribute("brugertype");
                    if (bt != 1) {
                        out.print("<li><a href=\"adminside.jsp\">Adminside</a></li>");
                    }
                %><br>
                <%
                    System.out.println(session.getAttribute("brugertype"));
                    bt = (Integer) session.getAttribute("brugertype");
                    if (bt == 1) {
                        out.print("<li><a href=\"brugerside.jsp\">Brugerside</a></li>");
                    }
                %>

                
                <a href="BygningsOprettelse.jsp">Opret bygning</a>
                <table class="storliste">
                    <tr>
                        <th>ID</th>
                        <th>Navn</th>
                        <th>Adresse</th>
                        <th>Parcelnummer</th>
                        <th>Størrelse</th>
                        <th>Etager</th>
                        <th>Tilstand</th>
                        <th>BrugerID</th>
                    </tr>

                    <%
                        EntityFacade ef = new EntityFacade();

                        ArrayList<Building> list = (ArrayList<Building>) ef.selectBuildings();

                        if (list != null) {

                            for (int i = 0; i < list.size(); i++) {
                                out.println("<tr><td>"
                                        + list.get(i).getbID()
                                        + "</td><td>"
                                        + list.get(i).getbName() + "</td><td>"
                                        + list.get(i).getbAddress() + "</td><td>"
                                        + list.get(i).getParcelNr() + "</td><td>"
                                        + list.get(i).getbSize() + "</td><td>"
                                        + list.get(i).getBfPlan() + "</td><td>"
                                        + list.get(i).getCondLvl() + "</td><td><a href=\"bygningside.jsp?bid=" + list.get(i).getFK_uID() + "\">"
                                        + list.get(i).getFK_uID() + "</a></td>"
                                        + "<td><td><form action=\"buildingservlet\" method=\"post\"><input type=\"hidden\" name=\"removeNr\" value=\"" + list.get(i).getbID() + "\"><input type=\"Submit\" name=\"job\" value=\"remove\"></form></td></td></tr>");
                            }
                        }
                    %>
                </table>
            </div>
        </fieldset>
    </body>
</html>