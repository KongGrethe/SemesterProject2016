/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Service.Entity.Building;
import java.io.IOException;
import java.io.PrintWriter;
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
        HttpSession session = request.getSession(true);

        String job = request.getParameter("job");

        //int bID = -5;
        String bName = "placeholder";
        String bAddress = "placeholder";
        int parcelNr = -5;
        double bSize = 100;
        int bfPlan = 3;
        int condLvl = 5;
        int FK_uID = 10;


        /* DataAccess da = new DataAccess();
        UserClass tmp = da.getUser(un, pw);
         */
        //ArrayList<CupcakeClass> cl = new ArrayList<>();
        String nextJSP = null;

        ArrayList<Building> al = new ArrayList<>();

        try {
//rs.next første gang kan bruges til at checke om det er true eller false

            switch (job) {
                case "add":
                    if (session.getAttribute("al") == null) {
                        session.setAttribute("al", al);
                        System.out.println("Kom til A");
                    } else {
                        al = (ArrayList<Building>) session.getAttribute("al");
                        al.add(new Building(0, "navn", "addresse", 0, 0, 0, 0, 0));
                        session.setAttribute("al", al);
                        System.out.println("Kom til B");
                    }
                    break;
                case "remove":
                    String nr = request.getParameter("removeNr");
                    al = (ArrayList<Building>) session.getAttribute("al");
                    al.remove(parseInt(nr));
                    session.setAttribute("al", al);
                    break;
                default:
                    break;
            }

            nextJSP = "/bygningsliste.jsp";
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
