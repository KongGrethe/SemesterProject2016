<%-- 
    Document   : bygningsliste
    Created on : 02-04-2016, 17:48:01
    Author     : Lasse
--%>

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
            <legend> <img src="polygon-logo-small.png"/></legend>
            <div align="center">
                <h1>Bygningsliste</h1>
                <form action="buildingservlet" method="post">
                    <input type="submit" name="job" value="add">
                </form>
                <table class="storliste">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Parcel ID</th>
                        <th>Size</th>
                        <th>Plan</th>
                        <th>Condition</th>
                        <th></th>
                    </tr>

                    <%
                        ArrayList<Building> list = (ArrayList<Building>) session.getAttribute("al");

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
                                        + list.get(i).getCondLvl() + "</td>"
                                        + "<td><form action=\"buildingservlet\" name=\"job\" value=\"remove\" method=\"post\"><input type=\"hidden\" name=\"removeNr\" value=" + i + "><input type=\"Submit\" value=\"Remove\"></form></td></tr>");
                            }
                        }
                    %>
                </table>
            </div>
        </fieldset>
    </body>
</html>
