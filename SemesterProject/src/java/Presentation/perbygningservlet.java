package Presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String job = request.getParameter("job");
        String fname = null;

        switch (job) {
            case "file":
                final Part filePart = request.getPart("file");
                OutputStream out = null;
                InputStream fileContent = null;
                
                int files = (int) Math.floor(Math.random()*100000);

                try {
                    String navn = filePart.getSubmittedFileName();
                    System.out.println(navn);
                    fname = navn.substring(navn.lastIndexOf("\\") + 1);
                    //overvej en anden mappe end C:/Mappe
                    out = new FileOutputStream(new File("C:/mappe/" + files + "_" + fname));
                    fileContent = filePart.getInputStream();

                    int read = 0;
                    final byte[] bytes = new byte[1024];
                    while ((read = fileContent.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }
                } catch (FileNotFoundException fne) {
                    System.out.println(fne.getMessage());
                } finally {
                    if (out != null) {
                        out.close();
                    }
                    if (fileContent != null) {
                        fileContent.close();
                    }
                    
                    //her skal der være et entity-kald som linker filen ind i databasen
                    session.setAttribute("besked", "Uploadet som: " + files + "_" + fname);
                }
                break;
            case "msg":
                //entitykald til indsættelse af beskeden i notificaitonstabellen
                break;
        }
        
        response.sendRedirect("bygningside.jsp");
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
