<%-- 
    Document   : BygningsOprettelse
    Created on : 04-04-2016, 21:40:59
    Author     : christian
--%>

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
        <fieldset>
            <legend> <img src="polygon-logo-small.png"/></legend>

            <div>Du kan oprette en bygning her.</div>
            <form action="buildingservlet" method="post">
                <table>
                    <tr>
                        <td>bName</td>
                        <td><input type="text" name="bName"></td>   
                    </tr>
                    <tr>
                        <td>bAddress</td>
                        <td><input type="text" name="bAddress"></td>   
                    </tr>
                    <tr>
                        <td>parcelNr</td>
                        <td><input type="text" name="parcelNr"></td>   
                    </tr>
                    <tr>
                        <td>bSize</td>
                        <td><input type="text" name="bSize"></td>   
                    </tr>
                    <tr>
                        <td>bfPlan</td>
                        <td><input type="text" name="bfPlan"></td>   
                    </tr>
                    <button name="job" value="add">Opret</button>
                </table>
            </form>
        </fieldset>
    </body>
</html>
