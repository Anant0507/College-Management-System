/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.college_management;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import BussinessLogic.*;
import javax.servlet.http.HttpSession;

public class SearchFacultyServlet extends HttpServlet {
    private Connection con;
    private CheckEnrollmentFac cef;
    private String DbName;
    private String DbPass;
    @Override
    public void init()
    {
        try{
            cef = new CheckEnrollmentFac();
            DbName = getServletContext().getInitParameter("DbName");
            DbPass = getServletContext().getInitParameter("DbPass");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DbName,"root",DbPass);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void getStudentData(String eno,HttpSession s)
    {
//        String name,email,pword,dept,quali,scode,sname;
        try{
            String facenrol = (String)s.getAttribute("FacultyEnroll");
            Statement st = con.createStatement();  
            ResultSet rs = st.executeQuery("Select * from facultycredentials");
            while(rs.next())
            {
                if(facenrol.equals(rs.getString(1)))
                {
                    s.setAttribute("id", rs.getString(1));
                    s.setAttribute("name", rs.getString(2));
                    s.setAttribute("email", rs.getString(3));
                    s.setAttribute("pass", rs.getString(4));
                    s.setAttribute("dept", rs.getString(5));
                    s.setAttribute("quali", rs.getString(6));
                    s.setAttribute("Scode", rs.getString(7));
                    s.setAttribute("SubName", rs.getString(8));
                }
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String eno = request.getParameter("eno");
        HttpSession s = request.getSession(false);
        if(cef.checkEno(eno,con))
        {
            s.setAttribute("FacultyEnroll",eno);
            getStudentData(eno,s);
            response.sendRedirect("Update_Faculty.jsp");
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
