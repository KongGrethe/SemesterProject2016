<%-- 
    Document   : brugeroprettelse
    Created on : 03-04-2016, 15:22:06
    Author     : Lasse & Christian
--%>

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
            <form>
                <table>
                    <tr>
                        <td>Brugernavn:</td>
                        <td>Password:</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="username" autocomplete="off"></td>
                        <td><input type="password" name="password" autocomplete="off"></td>
                        <td><input type="submit" name="Submit" value="Opret"></td>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="checkbox" name="accounttype" value="admin">Admin</input></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
