
package com.mycompany.college_management;

import BussinessLogic.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UpdateFacultyDetailsServlet extends HttpServlet {
    private Connection con;
    private String DbName,DbPass;
    private UpdateFacultyClass ufc;
    @Override
    public void init()
    {
        try {
            ufc = new UpdateFacultyClass();
            DbName = getServletContext().getInitParameter("DbName");
            DbPass = getServletContext().getInitParameter("DbPass");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DbName,"root",DbPass);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession(false);
        String id=(String)s.getAttribute("id");
        String name=(String)request.getParameter("name");
        String email=(String)request.getParameter("email");
        String pass=(String)request.getParameter("pass");
        String dept=(String)request.getParameter("dept");
        String quali=(String)request.getParameter("quali");
        String scode=(String)request.getParameter("scode");
        String sname=(String)request.getParameter("sname");
        if(ufc.updateFaculty(id,name,email,pass,dept,quali,scode,sname,con))
        {
            s.setAttribute("UpdateSucFaculty","Data successfully updated");
            response.sendRedirect("WelcomeAdmin.jsp");
        }
        else
        {
            s.setAttribute("UpdateUnsucFaculty","Error occured, Please try again");
            response.sendRedirect("WelcomeAdmin.jsp");
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
