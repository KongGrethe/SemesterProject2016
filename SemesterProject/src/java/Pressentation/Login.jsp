<%-- 
    Document   : Login
    Created on : Mar 30, 2016, 1:43:49 PM
    Author     : LoD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>noget</title>
    </head>
    
        <h1>Noget</h1>
        <fieldset>
            <legend>Enter username and password to login</legend>
            <form action="LoginCtrl" method="POST">
                <div>Username</div><input
                    type="text"
                    name="Username"
                    value="">
                <input 
                    type="submit"
                    name="New" 
                    value="Make a new Accunt">
                <div>Password</div><input
                    type="password"
                    name="Password"
                    value="">
                <input 
                    type="submit"
                    name="Login" 
                    value="Login">
                <div><a href="">Forgot Password</a></div>
            </form>
        </fieldset>
</html>
