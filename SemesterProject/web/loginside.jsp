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
        <fieldset>
            <legend> <img src="polygon-logo-small.png"/></legend>
            <div align="center">
                <h1>Log ind her</h1>
                <table>
                    <form action="loginctrl" method="post">
                        <tr>
                            <th>Brugernavn</th>
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

                <%
                    if (session.getAttribute("error") != null) {
                        out.println("<br><span class=\"error\">" + session.getAttribute("error") + "</span>");
                    }
                %>
                <div style="padding: 3em; color: grey;">Fang os døgnet rundt på vores 24-timers tlf: 70110044</div>
                <li><a href="index.html">Info side</a></li>
            </div>
        </fieldset>
    </body>
</html>
