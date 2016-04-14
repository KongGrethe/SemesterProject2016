/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DataAccess.Datamappers.UserMapper;
import Service.Entity.Building;
import Service.EntityFacade;
import java.io.IOException;
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
@WebServlet(name = "userservlet", urlPatterns = {"/userservlet"})
public class userservlet extends HttpServlet {

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

        String nextJSP = null;

        try {
            switch (job) {
                case "add":
                    EntityFacade ef = new EntityFacade();
                    //kode til at oprette bruger, check om findes i forvejen
                    //um.createUser(0, job, job, job, job, nextJSP, 0)
                    String uFName = (String) request.getParameter("uFName");
                    String uLName = (String) request.getParameter("uLName");
                    String upw = (String) request.getParameter("upw");
                    String email = (String) request.getParameter("email");

                    String userRole;
                    
                    if(request.getParameter("accounttype") == null) {
                        userRole = "customer";
                    } else {
                        userRole = "employee";
                    }

                    int FK_uID = (int) session.getAttribute("brugerid");
                    
                    System.out.println("kunne godt parse");
                    ef.createUser(0, uFName, uLName, upw, email, userRole, FK_uID);

                    break;

                case "remove":
                    //kode til at fjerne en bruger
                    break;
                default:
                    break;
            }
            nextJSP = "/brugeroprettelse.jsp";
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
