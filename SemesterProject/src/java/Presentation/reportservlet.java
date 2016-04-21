/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Service.Entity.Room;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String job = request.getParameter("job");

        ArrayList<Room> loclist = new ArrayList<Room>();

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
                
                nr.setMoistScan("x");
                nr.setMeasuringPoint("x");
                
                loclist.add(nr);

                session.setAttribute("loclist", loclist);
                break;
            case "createReport":
                System.out.println("opretter rapport");
                String bname = (String) request.getParameter("bname");
                
                if(bname == null) {
                    System.out.println("bname er null");
                }
                if(bname.equals("")) {
                    System.out.println("bname er ikke null, men et tomt tekstfelt");
                }
                
                String baddress = (String ) request.getParameter("baddress");
                String bnumber = (String) request.getParameter("bnumber");
                String bdate = (String) request.getParameter("bdate");
                
                System.out.println("kom her til");
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
                break;
        }
        response.sendRedirect("createreport.jsp");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
