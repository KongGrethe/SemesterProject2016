<%-- 
    Document   : bygningsliste
    Created on : 02-04-2016, 17:48:01
    Author     : Lasse
--%>
<%
    if (session.getAttribute("brugerid") == null) 
    {
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
        <title>JSP Page</title>
        <!-- JSP autogenererer ikke den nedenunderske linje, som er nødvendig for at få et korrekt zoomniveau på telefoner -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="newcss.css">
    </head>
    <body>
        <fieldset>
            <a href="brugerliste.jsp">Gå til brugerliste</a><br>
            <a href="BygningsOprettelse.jsp">Gå til bygningsoprettelse</a><br><br>
            <div>Laves mere smart senere</div>
            <a href="bygningside.jsp">Få informationer om bygningens tilstand her</a>
            <legend> <img src="polygon-logo-small.png"/></legend>
            <div align="center">
                <h1>Bygningsliste</h1>
                <a href="BygningsOprettelse.jsp">Opret bygning</a>
                <table class="storliste">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Parcel ID</th>
                        <th>Size</th>
                        <th>Plan</th>
                        <th>Condition</th>
                        <th>UserID</th>
                    </tr>

                    <%
                        
                        BuildingMapper bm = new BuildingMapper();
                        
                        ArrayList<Building> list = (ArrayList<Building>) bm.getBuildings();
                        
                        
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
                                        + list.get(i).getCondLvl() + "</td><td><a href=\"bygningside.jsp?id=" + list.get(i).getFK_uID() + "\">"
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
