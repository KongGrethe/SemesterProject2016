/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DataAccess.DBFacade;
import Service.DataException;
import Service.Entity.Room;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Lasse
 */
@MultipartConfig
@WebServlet(name = "reportservlet", urlPatterns = {"/reportservlet"})
public class reportservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DataException {
        //response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String job = request.getParameter("job");

        ArrayList<Room> loclist = new ArrayList<Room>();

        ServletContext sc = getServletContext();
        String cp = sc.getRealPath(File.separator);

        switch (job) {
            case "addRoom":
                System.out.println("tilføj rum");
                if (session.getAttribute("loclist") != null) {
                    loclist = (ArrayList<Room>) session.getAttribute("loclist");
                }

                Room nr = new Room(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1); //sidste er FK_checkupID              

                nr.setRoom((String) request.getParameter("rname"));
                nr.setRoomDesc((String) request.getParameter("rdesc"));
                nr.setWhere((String) request.getParameter("rwhere"));
                nr.setWhatHappened((String) request.getParameter("rhappened"));
                nr.setWhatHasBeenDone((String) request.getParameter("rdone"));
                nr.setDamageType((String) request.getParameter("rdamagetype"));

                nr.setWallNotes((String) request.getParameter("rwalldesc"));
                nr.setWallPart((Part) request.getPart("rwallfile"));

                nr.setCeilingNotes((String) request.getParameter("rceilingdesc"));
                nr.setCeilingPart((Part) request.getPart("rceilingfile"));

                nr.setFloorNotes((String) request.getParameter("rfloordesc"));
                nr.setFloorPart((Part) request.getPart("rfloorfile"));

                nr.setWindowDoorNotes((String) request.getParameter("rwindowsdesc"));
                nr.setWindowDoorPart((Part) request.getPart("rwindowsfile"));

                nr.setMoistScan((String) request.getParameter("fugtskanning"));
                nr.setMeasuringPoint((String) request.getParameter("malepunkt"));

                loclist.add(nr);

                session.setAttribute("loclist", loclist);
                break;
            case "createReport":
                int rnd = (int) Math.floor(Math.random() * 1000000) + 1;
                int inc = 1;
                String bname = (String) request.getParameter("bname");
                String baddress = (String) request.getParameter("baddress");
                String bnumber = (String) request.getParameter("bnumber");
                String bdate = (String) request.getParameter("bdate");
                Part bfrontpic = (Part) request.getPart("bfrontpic");
                String byear = (String) request.getParameter("byear");
                String barea = (String) request.getParameter("barea");
                String bpurpose = (String) request.getParameter("bpurpose");
                String broofdesc = (String) request.getParameter("broofdesc");
                Part brooffile = (Part) request.getPart("brooffile");
                String bouterwallsdesc = (String) request.getParameter("bouterwallsdesc");
                Part boutherwallsfile = (Part) request.getPart("bouterwallsfile");
                String tilstand = (String) request.getParameter("tilstand");
                String checkupperformer = (String) request.getParameter("checkupperformer");
                String accountableofbuilding = (String) request.getParameter("accountableofbuilding");
                int uid = (int) session.getAttribute("brugerid");
                int bid = Integer.parseInt((String) request.getParameter("bid"));
                System.out.println("USERID ER " + uid);

                System.out.println(uid + " and " + bid);
                //her gemmes lortet
                ArrayList<Room> sl = null;

                if (session.getAttribute("loclist") != null) {
                    sl = (ArrayList<Room>) session.getAttribute("loclist");
                }

                filgemmer fg = new filgemmer();

                String bfrontpicname = null;
                String brooffilename = null;
                String boutherwallsfilename = null;

                if (bfrontpic.getSize() != 0) {
                    bfrontpicname = rnd + "_" + inc + "_" + fg.getCleanFilename(bfrontpic.getSubmittedFileName());
                    fg.savePartAs(bfrontpic, cp + "\\test\\" + bfrontpicname);
                    //out = new FileOutputStream(new File(cp + "\\test\\" + files + "_" + fname));
                    inc++;
                }

                if (brooffile.getSize() != 0) {
                    brooffilename = rnd + "_" + inc + "_" + fg.getCleanFilename(brooffile.getSubmittedFileName());
                    fg.savePartAs(brooffile, cp + "\\test\\" + brooffilename);
                    inc++;
                }

                if (boutherwallsfile.getSize() != 0) {
                    boutherwallsfilename = rnd + "_" + inc + "_" + fg.getCleanFilename(boutherwallsfile.getSubmittedFileName());
                    fg.savePartAs(boutherwallsfile, cp + "\\test\\" + boutherwallsfilename);
                    inc++;
                }

                DBFacade dbf = new DBFacade();
                dbf.createCheckup(bname, baddress, bnumber, bdate, bfrontpicname, byear, barea, bpurpose, broofdesc, bouterwallsdesc, brooffilename, boutherwallsfilename, tilstand, checkupperformer, accountableofbuilding, uid, bid);

                if (sl != null) {
                    for (Room tmp : sl) {
                        String rName = tmp.getRoom();
                        String rWhere = tmp.getWhere();
                        String rHappened = tmp.getWhatHappened();
                        String rHasBeenDone = tmp.getWhatHasBeenDone();
                        String rDamageType = tmp.getDamageType();
                        String rWallNotes = tmp.getWallNotes();
                        String rCeilingNotes = tmp.getCeilingNotes();
                        String rFloorNotes = tmp.getFloorNotes();
                        String rWindowNotes = tmp.getWindowDoorNotes();

                        String rWallName = null;
                        if (tmp.getWallPart().getSize() != 0) {
                            rWallName = rnd + "_" + inc + "_" + fg.getCleanFilename(tmp.getWallPart().getSubmittedFileName());
                            fg.savePartAs(tmp.getWallPart(), cp + "\\test\\" + rWallName);
                            inc++;
                        }

                        String rCeilingName = null;
                        if (tmp.getCeilingPart().getSize() != 0) {
                            rCeilingName = rnd + "_" + inc + "_" + fg.getCleanFilename(tmp.getCeilingPart().getSubmittedFileName());
                            fg.savePartAs(tmp.getCeilingPart(), cp + "\\test\\" + rCeilingName);
                            inc++;
                        }

                        String rFloorName = null;
                        if (tmp.getFloorPart().getSize() != 0) {
                            rFloorName = rnd + "_" + inc + "_" + fg.getCleanFilename(tmp.getFloorPart().getSubmittedFileName());
                            fg.savePartAs(tmp.getFloorPart(), cp + "\\test\\" + rFloorName);
                            inc++;
                        }

                        String rWindowDoorName = null;
                        if (tmp.getWindowDoorPart().getSize() != 0) {
                            rWindowDoorName = rnd + "_" + inc + "_" + fg.getCleanFilename(tmp.getWindowDoorPart().getSubmittedFileName());
                            fg.savePartAs(tmp.getWindowDoorPart(), cp + "\\test\\" + rWindowDoorName);
                            inc++;
                        }

                        String rMoistScan = tmp.getMoistScan();
                        String rMeasuringPoint = tmp.getMeasuringPoint();

                        dbf.createRoom(rName, rWhere, rHappened, rHasBeenDone, rDamageType, rWallNotes, rCeilingNotes, rFloorNotes, rWindowDoorName, rWallName, rCeilingName, rFloorName, rWindowNotes, rMoistScan, rMeasuringPoint, bid);
                    }
                }
                session.setAttribute("loclist", null);
                break;

        }
        response.sendRedirect("createreport.jsp?bid=" + request.getParameter("bid"));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DataException ex) {
            Logger.getLogger(reportservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DataException ex) {
            Logger.getLogger(reportservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
