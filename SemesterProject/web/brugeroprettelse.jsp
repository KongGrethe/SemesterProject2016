<%-- 
    Document   : brugeroprettelse
    Created on : 03-04-2016, 15:22:06
    Author     : Lasse
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
        <h1>Brugeroprettelse.</h1>
        <form>
            <input type="text" name="username" autocomplete="off">
            <input type="password" name="password" autocomplete="off">
            <input type="submit" name="Submit">
        </form>
    </body>
</html>
