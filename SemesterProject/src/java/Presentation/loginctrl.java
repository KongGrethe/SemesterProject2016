/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DataAccess.DBFacade;
import Service.DataException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LoD
 */
@WebServlet(name = "loginctrl", urlPatterns = {"/loginctrl"})
public class loginctrl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);
            DBFacade DBF;
            try {
                DBF = new DBFacade();
                String Username = request.getParameter("username");
                String Password = request.getParameter("password");

                int check[] = DBF.validate(Username, Password);
                session.setAttribute("brugerid", check[0]);
                session.setAttribute("brugertype", check[1]);
                if (check[0] != 0) {

                    if (check[1] == 1) {
                        forward(request, response, "/brugerside.jsp");
                    } else {
                        forward(request, response, "/adminside.jsp");
                    }
                } else {
                    session.setAttribute("error", "Dit brugernavn eller password var forkert, prøv igen!");
                    forward(request, response, "/loginside.jsp");
                    System.out.println("HA! DU ER STADIG IKKE LOGGET IND!");
                }
            } catch (DataException ex) {
                session.setAttribute("error", "Databasen fejlede, prøv igen senere!");
                    forward(request, response, "/loginside.jsp");
            }   
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(loginctrl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginctrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(loginctrl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginctrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected void forward(HttpServletRequest request, HttpServletResponse response, String url) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

}
