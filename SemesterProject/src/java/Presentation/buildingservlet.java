/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DataAccess.Datamappers.BuildingMapper;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lasse
 */
@WebServlet(name = "buildingservlet", urlPatterns = {"/buildingservlet"})
public class buildingservlet extends HttpServlet {

    ResultSet rs = null;
    Statement statement = null;
    Connection connection = null;
    ResultSet rsc = null;
    boolean isValid;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //session bruges ikke endnu men den skal vi bruge til at logge brugerID'et

        String job = request.getParameter("job");

        String nextJSP = null;

        try {
            //rs.next første gang kan bruges til at checke om det er true eller false
            BuildingMapper bm = new BuildingMapper();
            switch (job) {
                case "add":

                    String bName = request.getParameter("bName");
                    String bAddress = request.getParameter("bAddress");
                    //variabelsetups er fordelt på cases, ellers opstår nullpointer exceptions
                    int parcelNr = parseInt(request.getParameter("parcelNr"));
                    double bSize = parseDouble(request.getParameter("bSize"));
                    int bfPlan = parseInt(request.getParameter("bfPlan"));
                    int condLvl = -1;//Vi har ikke dette endnu
                    int FK_uID = parseInt(request.getParameter("FK_uID"));
                    //int FK_uID = Integer.parseInt((String) session.getAttribute("brugerid"));

                    bm.createBuilding(bName, bAddress, parcelNr, bSize, bfPlan, condLvl, FK_uID);
                    nextJSP = "/BygningsOprettelse.jsp";

                    break;
                case "remove":
                    String nr = request.getParameter("removeNr");
                    System.out.println("kom til remove");
                    System.out.println("skal remove " + nr);
                    bm.deleteBuilding(parseInt(nr));
                    nextJSP = "/bygningsliste.jsp";
                    break;
                default:
                    break;
            }
        } catch (Exception ee) {
            System.out.println("fail");
            System.err.println(ee);
        } finally {
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
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
