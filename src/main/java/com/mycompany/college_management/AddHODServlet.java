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
/**
 *
 * @author Manoj
 */
public class AddHODServlet extends HttpServlet {
    private AddHODClass ahodc;
    private Connection con;
    private String DbName,DbPass;

    @Override
    public void init()
    {
        try{
            DbName = getServletContext().getInitParameter("DbName");
            DbPass = getServletContext().getInitParameter("DbPass");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DbName,"root",DbPass);
            ahodc = new AddHODClass();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String eno = request.getParameter("eno");
        String name = request.getParameter("name");
        String email =  request.getParameter("email");
        String pword = request.getParameter("pword");
        String dept = request.getParameter("dept");
        HttpSession s = request.getSession(false);
        if(ahodc.addHOD(eno,name,email,pword,dept,con))
        {
            s.setAttribute("HODAdded","Data added Succesfully");
            response.sendRedirect("WelcomeAdmin.jsp");
        }
        else
        {
            s.setAttribute("HODError","Error occured in adding data");
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
