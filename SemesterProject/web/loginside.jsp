<%-- 
    Document   : loginside
    Created on : 02-04-2016, 17:12:32
    Author     : Lasse & Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loginside</title>
        <link rel="stylesheet" href="newcss.css">
        <!-- JSP autogenererer ikke den nedenunderske linje, som er nødvendig for at få et korrekt zoomniveau på telefoner -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div align="center">
            <img src="http://www.polygongroup.com/UI/build/svg/polygon-logo.svg" style="padding: 5% 0px 2% 0px; max-width: 80%;"/>
            <div>Der er ikke kode til at logge ind endnu. <a href="bygningsliste.jsp">Bygningsliste</a>.</div><br>
            <table>
                <form action="loginctrl" method="post">
                    <tr>
                        <th>ID</th>
                        <td><input type="text" name="username" autocomplete="off"></td>
                    </tr>
                    <tr>
                        <th>Password</th>
                        <td><input type="password" name="password" autocomplete="off"></td>
                    </tr>
                    <tr>
                        <td  align="right"><a href="ResetPassword.jsp">Glemt Password?</a></td>
                        <td  align="center"><input type="submit" value="Login"></td>
                        
                    
                    </tr>
                </form>
            </table>
            <div style="padding: 3em; color: grey;">24-timers hotline tilgængelig på 11223344</div>
        </div>
    </body>
</html>
