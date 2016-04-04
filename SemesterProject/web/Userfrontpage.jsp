<%-- 
    Document   : Userfrontpage
    Created on : 04-04-2016, 15:43:27
    Author     : christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Velkommen!</title>
    </head>
    <body>
        <fieldset>
            <legend> <img src="polygon-logo-small.png"/></legend>
            <table>
                <tr>
                    <td>
                        <form action="bygningsliste.jsp" method="get">
                            <input 
                                type="submit" 
                                value="Bygningsliste" 
                                name="buLiSC"
                                />
                        </form>
                    </td>
                    <td>
                        <form action="BygningsOprettelse.jsp" method="get">
                            <input 
                                type="submit" 
                                value="Bygningsoprettelse" 
                                name="Submit"
                                />
                        </form>
                    </td>
                </tr>
            </table>

            <h1>Velkommen <%=session.getAttribute("uFName")%></h1> <!--Siger hej "navn" -->
            <h2>Som kunde har du følgende muligheder:</h2>

        </fieldset>

    </body>
</html>
