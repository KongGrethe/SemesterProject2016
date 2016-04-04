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
        <title>Opret bruger</title>
    </head>
    <body>
        
        <!-- her skal også være plads til en fejlbesked om at brugernavnet er taget -->
        <h1>Brugeroprettelse</h1>
        <form>
            <table>
                <tr>
                    <td>
                        Brugernavn:
                    </td>
                    <td>
                        Password:
                    </td>
                </tr>
                <tr>
                    <td>                        
                        <input type="text" name="username" autocomplete="off">
                    </td>
                    <td>
                        <input type="password" name="password" autocomplete="off">
                    </td>
                    <td>
                        <input type="submit" name="Submit" value="Opret">
                    </td>
                </tr>   
            </table>
        </form>
    </body>
</html>
