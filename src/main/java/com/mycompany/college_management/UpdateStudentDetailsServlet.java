
package com.mycompany.college_management;

import BussinessLogic.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UpdateStudentDetailsServlet extends HttpServlet {
    private Connection con;
    private String DbName,DbPass;
    private UpdateStudentClass usc;
    @Override
    public void init()
    {
        try{
            usc = new UpdateStudentClass();
            DbName = getServletContext().getInitParameter("DbName");
            DbPass = getServletContext().getInitParameter("DbPass");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DbName,"root",DbPass);
        }catch(Exception e)
        {
            System.out.println(e);
        }
            
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pword = request.getParameter("pword");
        String dept = request.getParameter("dept");
        String sub1 = request.getParameter("sub1");
        String sub2 = request.getParameter("sub2");
        String sub3 = request.getParameter("sub3");
        String status = request.getParameter("status");
        HttpSession s = request.getSession(false);
        String eno = (String)s.getAttribute("StudentEnroll");
        if(usc.updateStudent(eno, name, email, pword, dept, sub1, sub2, sub3, status, con))
        {
            s.setAttribute("UpdateSucStudent","Data successfully updated");
            response.sendRedirect("WelcomeAdmin.jsp");
        }           
        else
        {
            s.setAttribute("UpdateUnsucStudent","Error occured, Please try again");
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
