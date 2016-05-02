package Presentation;

import DataAccess.DBFacade;
import Service.DataException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "perbygningservlet", urlPatterns = {"/perbygningservlet"})
public class perbygningservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, DataException {
        try {
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");
            String job = request.getParameter("job");
            String fname = null;

            DBFacade dbf = new DBFacade();

            int uid = 0;
            int bid = 0;

            ServletContext sc = getServletContext();
            String cp = sc.getRealPath(File.separator);

            switch (job) {
                case "file":
                    final Part filePart = request.getPart("file");

                    int files = (int) Math.floor(Math.random() * 100000);

                    String navn = filePart.getSubmittedFileName();
                    filgemmer fg = new filgemmer();
                    fname = fg.getCleanFilename(navn);
                    //fname = navn.substring(navn.lastIndexOf("/") + 1);

                    //overvej en anden mappe end C:/Mappe
                    
                    /* HVIS DU BRUGER WINDOWS, UDKOMMENTER PÅ LINJE 57*/
                    fg.savePartAs(filePart, cp + "\\test\\" + files + "_" + fname);
                    
                    /* HVIS DU BRUGER MAC, UDKOMMENTER LINJE 60*/ 
                    //fg.savePartAs(filePart, cp + "/test/" + files + "_" + fname);

                    uid = Integer.parseInt((String) request.getParameter("uid"));
                    bid = Integer.parseInt((String) request.getParameter("bid"));

                    dbf.createFile(files + "_" + fname, bid, uid);
                    break;
                case "msg":
                    String msg = request.getParameter("content");
                    uid = Integer.parseInt((String) request.getParameter("uid"));
                    bid = Integer.parseInt((String) request.getParameter("bid"));
                    dbf.createNotification(0, msg, bid, uid);
                    break;
            }

            response.sendRedirect("bygningside.jsp?bid=" + bid);
        } catch (DataException ex) {
            System.out.println("Tjek databaseFacaden");
            ex.getMessage();
            response.getOutputStream().print("Der blev smidt en DataException");
        }
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(perbygningservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataException ex) {
            Logger.getLogger(perbygningservlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(perbygningservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataException ex) {
            Logger.getLogger(perbygningservlet.class.getName()).log(Level.SEVERE, null, ex);
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
