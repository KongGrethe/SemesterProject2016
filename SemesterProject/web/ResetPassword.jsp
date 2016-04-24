<%-- 
    Document   : ResetPassword
    Created on : 04-04-2016, 13:13:01
    Author     : christian
--%>
<!-- Denne JSP-Side har til formål at oprette nyt Password til bruger.-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ResetPassword</title>
        <link rel="stylesheet" href="newcss.css">
        <!-- JSP autogenererer ikke den nedenunderske linje, som er nødvendig for at få et korrekt zoomniveau på telefoner -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <fieldset>
            <legend> <img src="polygon-logo-small.png"/></legend>
            <div align="center">
                <h1>Glemt Password?</h1>

                <table>

                    <tr>
                        <td>E-mail</td>
                        <td><input type="text" name="email" autocomplete="off"></td>

                    </tr>
                    <tr>
                        <td colspan="2" align="right"><input type="submit" name="Indsend" autocomplete="off"></td>
                    </tr>

                </table>
            </div>
        </fieldset>
    </body>
</html>
