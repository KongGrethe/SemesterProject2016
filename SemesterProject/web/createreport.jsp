<%-- 
    Document   : createreport
    Created on : 19-04-2016, 11:51:26
    Author     : Lasse
--%>

<%@page import="Presentation.convertSize"%>
<%@page import="Service.Entity.Room"%>
<%@page import="java.util.ArrayList"%>

<%
    /*if (session.getAttribute("brugerid") == null) {
        response.sendRedirect("index.html");
    }*/
%>

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
        <%
            out.print("<div>Dit brugerid er" + session.getAttribute("brugerid") + ".<br>Hvis der står 0 så er der noget galt - prøv med en anden bruger (fx Anette med koden \"jsp\")</div>");
            if(request.getParameter("bid") == null) {
                out.print("<h3>FEJL - DER ER IKKE NOGEN bid PARAMETER I URL'EN</h3>");
            }
        %>
        <h2>Lokaleoprettelse</h2>
        <form action="reportservlet" enctype="multipart/form-data" method="post">
            <input type="hidden" name="job" value="addRoom">
            <%
                out.print("<input type=\"hidden\" name=\"bid\" value=\"" + request.getParameter("bid") + "\">");
            %>
            <table>
                <tr>
                    <td>Lokale</td>
                    <td><input type="text" name="rname"></td>
                </tr>
                <tr>
                    <td>Beskrivelse af eventuel lokaleskade</td>
                    <td><input type="text" name="rdesc"></td>
                </tr>
                <tr>
                    <td>Hvor</td><td><input type="text" name="rwhere"></td>
                </tr>
                <tr>
                    <td>Hvad er sket</td><td><input type="text" name="rhappened"></td>
                </tr>
                <tr>
                    <td>Hvad er gjort ved det</td><td><input type="text" name="rdone"></td>
                </tr>
                <tr>
                    <td>Skadetype</td><td><input type="text" name="rdamagetype"></td>
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
                    <td><input type="text" name="rwalldesc"></td>
                    <td><input type="file" name="rwallfile"></td>
                </tr>
                <tr>
                    <td>Loft</td>
                    <td><input type="text" name="rceilingdesc"></td>
                    <td><input type="file" name="rceilingfile"></td>
                </tr>
                <tr>
                    <td>Gulv</td>
                    <td><input type="text" name="rfloordesc"></td>
                    <td><input type="file" name="rfloorfile"></td>
                </tr>
                <tr>
                    <td>Vinduer og døre</td>
                    <td><input type="text" name="rwindowsdesc"></td>
                    <td><input type="file" name="rwindowsfile"></td>
                </tr>
            </table>
            <p>hej</p>
            <table>
                <tr>
                    <td>Fugtskanning</td>
                    <td><input type="text" name="fugtskanning"></td>
                </tr>
                <tr>
                    <td>Målepunkt</td>
                    <td><input type="text" name="malepunkt"></td>
                </tr>
            </table>
            <br>
            <input type="Submit" name="Submit">
        </form>

                <hr>

                <h2>Oprettede lokaler</h2>
                <%
                    if (session.getAttribute("loclist") != null) {
                        ArrayList<Room> loclist = (ArrayList<Room>) session.getAttribute("loclist");

                        out.print("<table>");
                        out.print("<tr style=\"background: #EEE;\">");
                        out.print("<th>Room</th>");
                        out.print("<th>Desc</th>");
                        out.print("<th>Where</th>");
                        out.print("<th>Happened</th>");
                        out.print("<th>Done</th>");
                        out.print("<th>DType</th>");
                        out.print("<th>WDesc</th>");
                        out.print("<th>WFile</th>");
                        out.print("<th>CeilDesc</th>");
                        out.print("<th>CeilFile</th>");
                        out.print("<th>Floordesc</th>");
                        out.print("<th>FloorFile</th>");
                        out.print("<th>WinDoorDesc</th>");
                        out.print("<th>WinDoorFile</th>");
                        out.print("</tr>");

                        convertSize cs = new convertSize();

                        for (int i = 0; i < loclist.size(); i++) {
                            out.print("<tr>");
                            out.print("<td>" + loclist.get(i).getRoom() + "</td>");
                            out.print("<td>" + loclist.get(i).getRoomDesc() + "</td>");
                            out.print("<td>" + loclist.get(i).getWhere() + "</td>");
                            out.print("<td>" + loclist.get(i).getWhatHappened() + "</td>");
                            out.print("<td>" + loclist.get(i).getWhatHasBeenDone() + "</td>");
                            out.print("<td>" + loclist.get(i).getDamageType() + "</td>");

                            out.print("<td>" + loclist.get(i).getWallNotes() + "</td>");
                            if (loclist.get(i).getWallPart() != null) {
                                out.print("<td>" + cs.convertSize(loclist.get(i).getWallPart().getSize()) + "</td>");
                            } else {
                                out.print("<td>(no file)</td>");
                            }

                            out.print("<td>" + loclist.get(i).getCeilingNotes() + "</td>");
                            if (loclist.get(i).getCeilingPart() != null) {
                                out.print("<td>" + cs.convertSize(loclist.get(i).getCeilingPart().getSize()) + "</td>");
                            } else {
                                out.print("<td>(no file)</td>");
                            }

                            out.print("<td>" + loclist.get(i).getFloorNotes() + "</td>");
                            if (loclist.get(i).getFloorPart() != null) {
                                out.print("<td>" + cs.convertSize(loclist.get(i).getFloorPart().getSize()) + "</td>");
                            } else {
                                out.print("<td>(no file)</td>");
                            }

                            out.print("<td>" + loclist.get(i).getWindowDoorNotes() + "</td>");
                            if (loclist.get(i).getWindowDoorPart() != null) {
                                out.print("<td>" + cs.convertSize(loclist.get(i).getWindowDoorPart().getSize()) + "</td>");
                            } else {
                                out.print("<td>(no file)</td>");
                            }

                        }

                        out.print("</table>");
                    } else {
                        out.print("<p>Der er intet her at vise endnu.</p>");
                    }
                %>

                <hr>
                <h2>Opret checkupreport</h2>
                <span style="background: pink; border: 1px solid red; padding: 0.25em;">Lav rummene først, og udfyld derefter disse felter for at gemme og sende!</span><br><br>

        <hr>
        <h2>Færdiggør checkupreport</h2>
        <span style="background: pink; border: 1px solid red; padding: 0.25em;">Lav rummene først, og udfyld derefter disse felter for at gemme og sende!</span><br><br>

        <form action="reportservlet" enctype="multipart/form-data" method="post">
            <input type="hidden" name="job" value="createReport">
            <%
                out.print("<input type=\"hidden\" name=\"bid\" value=\"" + request.getParameter("bid") + "\">");
            %>
            <table>
                <tr>
                    <td>Navn på bygning</td><td><input type="text" name="bname"></td>
                </tr>
                <tr>
                    <td>Addresse</td><td><input type="text" name="baddress"></td>
                </tr>
                <tr>
                    <td>Postnr</td><td><input type="text" name="bnumber"></td>
                </tr>
                <tr>
                    <td>Dato (DD-MM-YYYY)</td><td><input type="text" name="bdate"></td>
                </tr>
            </table>
            <br>
            <h2>Generel information om bygning</h2>
            Billede af bygning udefra<br><input type="file" name="bfrontpic">
            <br><br>
            <table>
                <tr>
                    <td>Byggeår</td><td><input type="text" name="byear"></td>
                </tr>
                <tr>
                    <td>Bygningsareal</td><td><input type="text" name="barea"></td>
                </tr>
                <tr>
                    <td>Formål</td><td><input type="text" name="bpurpose"></td>
                </tr>
            </table>
            <br>
            <h2>Gennemgang af bynging udvendig</h2>
            <table>
                <tr>
                    <th>Område</th>
                    <th>Bemærkninger</th>
                    <th>Billede</th>
                </tr>
                <tr>
                    <td>Tag</td>
                    <td><input type="text" name="broofdesc"></td>
                    <td><input type="file" name="brooffile"></td>
                </tr>
                <tr>
                    <td>Ydervægge</td>
                    <td><input type="text" name="bouterwallsdesc"></td>
                    <td><input type="file" name="bouterwallsfile"></td>
                </tr>
            </table>
            <br>
            <table>
                <tr>
                    <td>Beskrivelse</td>
                    <td>Funktion</td>
                    <td>Vurderet tilstand</td>
                </tr>
                <tr>
                    <td>Bygningsdelen er ny og som bygget</td>
                    <td>Funktionen er som beskrevet</td>
                    <td><input type="radio" name="tilstand" value="0" checked></td>
                </tr>
                <tr>
                    <td>Bygningsdelen er intakt, men med begyndende slid og synlige skader(kun kosmetiske skader)</td>
                    <td>Funktionen er som beskrevet</td>
                    <td><input type="radio" name="tilstand" value="1"></td>
                </tr>
                <tr>
                    <td>Bygningsdelen er begyndt at forfalde, med enkelte defekte komponenter</td>
                    <td>Funktionen er nedsat –fare for følgeskader</td>
                    <td><input type="radio" name="tilstand" value="2"></td>
                </tr>
                <tr>
                    <td>Bygningsdelen er nedbrudt og skal udskiftes</td>
                    <td>Funktionen er ophørt –fare for følgeskader</td>
                    <td><input type="radio" name="tilstand" value="3"></td>
                </tr>
            </table>
            <br>
            <table>
                <tr>
                    <td>Checkupudfører:</td><td><input type="text" name="checkupperformer"></td>
                    <td>Bygningsansvarlig:</td><td><input type="text" name="accountableofbuilding"></td>
                </tr>
            </table>
            <br>
            <input type="Submit" name="Submit">
        </form>
    </center>
</body>
</html>
