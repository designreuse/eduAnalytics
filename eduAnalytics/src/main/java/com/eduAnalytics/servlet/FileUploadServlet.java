/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduAnalytics.servlet;

import com.eduAnalytics.dao.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author abc
 */
public class FileUploadServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            System.out.println("<!DOCTYPE html>");
            System.out.println("<html>");
            System.out.println("<head>");
            System.out.println("<title>Servlet FileUploadServlet</title>");
            System.out.println("</head>");
            System.out.println("<body>");
            System.out.println("<h1>Servlet FileUploadServlet at " + request.getContextPath() + "</h1>");
            System.out.println("</body>");
            System.out.println("</html>");
        } finally {
            out.close();
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
        doPost(request, response);
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if (!isMultipartContent) {
            System.out.println("You are not trying to upload<br/>");
            return;
        }
        System.out.println("You are trying to upload<br/>");

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> fields = upload.parseRequest(request);
            System.out.println("Number of fields: " + fields.size() + "<br/><br/>");
            Iterator<FileItem> it = fields.iterator();
            if (!it.hasNext()) {
                System.out.println("No fields found");
                return;
            }
            while (it.hasNext()) {
                FileItem fileItem = it.next();
                boolean isFormField = fileItem.isFormField();
                if (isFormField) {
                    System.out.println("<td>regular form field</td><td>FIELD NAME: " + fileItem.getFieldName()
                            + "<br/>STRING: " + fileItem.getString()
                    );
                    System.out.println("</td>");
                } else {
                    AdminDAO adminDAO = new AdminDAO();
                    int successEntries = 0;
                    if (action.equals("addDiscipline")) {
                        successEntries = adminDAO.uploadDiscipline(fileItem.getString());
                    }else if (action.equals("addCourse")) {
                        successEntries = adminDAO.uploadCourse(fileItem.getString());
                    }
                    System.out.println("servlet entries " + successEntries);
                    response.setContentType("text/plain");
                    out.print(successEntries);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
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
