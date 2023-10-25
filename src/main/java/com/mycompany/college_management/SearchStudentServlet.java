/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.college_management;

import BussinessLogic.CheckEnrollmentStu;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Manoj
 */
public class SearchStudentServlet extends HttpServlet {
    private Connection con;
    private CheckEnrollmentStu ces;
    private String DbName;
    private String DbPass;
    
    @Override
    public void init()
    {
        try{
            ces = new CheckEnrollmentStu();
            DbName = getServletContext().getInitParameter("DbName");
            DbPass = getServletContext().getInitParameter("DbPass");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DbName,"root",DbPass);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    private void getStudentData(String eno,HttpSession s)
    {
        String name,email,pword,dept,status;
        Float sub1,sub2,sub3;
        name=email=pword=dept=status="null";
        sub1=sub2=sub3=0f;
        try{
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from student1");
            while(rs.next())
            {
                if(rs.getString("EN_NO").equals(eno))
                {
                    name = rs.getString("NAME");
                    email = rs.getString("EMAIL");
                    pword = rs.getString("PASSWORD");
                    dept = rs.getString("DEPARTMENT");
                    sub1 = rs.getFloat("SUB1");
                    sub2 = rs.getFloat("SUB2");
                    sub3 = rs.getFloat("SUB3");
                    status = rs.getString("STATUS");
                    break;
                }
            }
            s.setAttribute("StudentName", name);
            s.setAttribute("StudentEmail",email);
            s.setAttribute("StudentPassword",pword);
            s.setAttribute("StudentDepartment",dept);
            s.setAttribute("StudentSub1",sub1);
            s.setAttribute("StudentSub2",sub2);
            s.setAttribute("StudentSub3",sub3);
            s.setAttribute("StudentStatus",status);
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String eno = request.getParameter("eno");
        HttpSession s = request.getSession(false);
        System.out.println("Inside SearchStudentServlet...");
        if(ces.checkEno(eno, con))
        {
            s.setAttribute("StudentEnroll",eno);
            getStudentData(eno,s);
            response.sendRedirect("Update_Student.jsp");
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
