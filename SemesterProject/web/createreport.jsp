<%-- 
    Document   : createreport
    Created on : 19-04-2016, 11:51:26
    Author     : Lasse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="newcss.css">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Opret checkupreport</h1>
        <form action="reportservlet" method="post">
            <input type="hidden" name="job" value="createReport">
            <table>
                <tr>
                    <td>Navn på bygning</td><td><input type="text"></td>
                </tr>
                <tr>
                    <td>Addresse</td><td><input type="text"></td>
                </tr>
                <tr>
                    <td>Postnr</td><td><input type="text"></td>
                </tr>
                <tr>
                    <td>Dato (DD-MM-YYYY)</td><td><input type="text"></td>
                </tr>
            </table>
            <br>
            <h3>Generel information om bygning</h3>
            Billede af bygning udefra<br><input type="file">
            <br><br>
            <table>
                <tr>
                    <td>Byggeår</td><td><input type="text"></td>
                </tr>
                <tr>
                    <td>Bygningsareal</td><td><input type="text"></td>
                </tr>
                <tr>
                    <td>Formål</td><td><input type="text"></td>
                </tr>
            </table>
            <br>
            <h3>Gennemgang af bynging udvendig</h3>
            <table>
                <tr>
                    <th>Område</th>
                    <th>Bemærkninger</th>
                    <th>Billede</th>
                </tr>
                <tr>
                    <td>Tag</td>
                    <td><input type="text"></td>
                    <td><input type="file"></td>
                </tr>
                <tr>
                    <td>Ydervægge</td>
                    <td><input type="text"></td>
                    <td><input type="file"></td>
                </tr>
            </table>
            <br>
            <table>
                <tr>
                    <td>Tilstand</td>
                    <td>Beskrivelse</td>
                    <td>Funktion</td>
                    <td>Vurderet tilstand</td>
                </tr>
                <tr>
                    <td>Tilstandsgrad 0</td>
                    <td>Bygningsdelen er ny og som bygget</td>
                    <td>Funktionen er som beskrevet</td>
                    <td><input type="radio" name="tilstand" value="0"></td>
                </tr>
                <tr>
                    <td>Tilstandsgrad 1</td>
                    <td>Bygningsdelen er intakt, men med begyndende slid og synlige skader(kun kosmetiske skader)</td>
                    <td>Funktionen er som beskrevet</td>
                    <td><input type="radio" name="tilstand" value="1"></td>
                </tr>
                <tr>
                    <td>Tilstandsgrad 2</td>
                    <td>Bygningsdelen er begyndt at forfalde, med enkelte defekte komponenter</td>
                    <td>Funktionen er nedsat –fare for følgeskader</td>
                    <td><input type="radio" name="tilstand" value="2"></td>
                </tr>
                <tr>
                    <td>Tilstandsgrad 3</td>
                    <td>Bygningsdelen er nedbrudt og skal udskiftes</td>
                    <td>Funktionen er ophørt –fare for følgeskader</td>
                    <td><input type="radio" name="tilstand" value="3"></td>
                </tr>
            </table>
            <br>
            <table>
                <tr>
                    <td>Checkupudfører:</td><td><input type="text"></td>
                    <td>Bygningsansvarlig:</td><td><input type="text"></td>
                </tr>
            </table>
            <input type="Submit" name="Submit">
        </form>
        <hr>
        <h3>Dynamiske lokaletabeller (disse skal være deres egen form)</h3>
        <form action="reportservlet" method="post">
            <input type="hidden" name="job" value="addRoom">
            <table>
                <tr>
                    <th>Lokale</th><td><input type="text"></td>
                </tr>
                <tr>
                    <td>Beskrivelse af eventuel lokaleskade</td><td><input type="text"></td>
                </tr>
                <tr>
                    <td>Hvornår (DD-MM-YYYY)</td><td><input type="text"></td>
                </tr>
                <tr>
                    <td>Hvor</td><td><input type="text"></td>
                </tr>
                <tr>
                    <td>Hvad er sket</td><td><input type="text"></td>
                </tr>
                <tr>
                    <td>Hvad er gjort ved det</td><td><input type="text"></td>
                </tr>
                <tr>
                    <td>Skadetype</td><td><input type="text"></td>
                </tr>
            </table>
            <p>Disse hører også til dynamiske tabeller</p>
            <table>
                <tr>
                    <th>Område</th>
                    <th>Bemærkninger</th>
                    <th>Billede</th>
                </tr>
                <tr>
                    <td>Vægge</td>
                    <td><input type="text"></td>
                    <td><input type="file"></td>
                </tr>
                <tr>
                    <td>Loft</td>
                    <td><input type="text"></td>
                    <td><input type="file"></td>
                </tr>
                <tr>
                    <td>Gulv</td>
                    <td><input type="text"></td>
                    <td><input type="file"></td>
                </tr>
                <tr>
                    <td>Vinduer og døre</td>
                    <td><input type="text"></td>
                    <td><input type="file"></td>
                </tr>
            </table>
            <p>hej</p>
            <table>
                <tr>
                    <td>Fugtskanning</td>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>Målepunkt</td>
                    <td><input type="text"></td>
                </tr>
            </table>
            <p>Anbefaling</p>
            <input type="text">
            <hr>
            <h3>Konklusion</h3>
            <p>Her skal være en informationstabel genereret ud fra data i session.</p>
            <input type="Submit" name="Submit">
        </form>
    </center>
</body>
</html>