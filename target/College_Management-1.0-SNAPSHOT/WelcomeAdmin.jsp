<%-- 
    Document   : WelcomeAdmin
    Created on : 05-Oct-2022, 12:57:06 pm
    Author     : Manoj
--%>
<% 
    HttpSession s = request.getSession(false);
//    if(s == null || s.getAttribute("AdminEnroll") == null)
//    {
//        response.sendRedirect("Teacher_Login.jsp");
//    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Admin Page</title>
    </head>
    <body>
        Welcome
        <% 
            if(s.getAttribute("AdminEnroll") != null)
            {
                out.println((String)s.getAttribute("AdminEnroll"));
            }
        %>
<!--        <a href="Search_Faculty.jsp">Update Faculty</a><br>
        <a href="Add_Faculty.jsp">Add Faculty</a><br>
        <a href="Search_Student.jsp">Update Student</a><br>
        <a href="Add_Student.jsp">Add Student</a><br>-->
        <a href="Add_HOD.jsp">Add HOD</a>
        <% 
            if(s.getAttribute("StudentAdded")!=null)
            {
                out.println((String)s.getAttribute("StudentAdded"));
                s.removeAttribute("StudentAdded");
            }
            if(s.getAttribute("StudentError") != null)
            {
                out.println((String)s.getAttribute("StudentError"));
                s.removeAttribute("StudentError");
            }
            if(s.getAttribute("UpdateSucStudent")!=null)
            {
                out.println((String)s.getAttribute("UpdateSucStudent"));
                s.removeAttribute("UpdateSucStudent");
            }
            if(s.getAttribute("UpdateUnsucStudent")!=null)
            {
                out.println((String)s.getAttribute("UpdateUnsucStudent"));
                s.removeAttribute("UpdateUnsucStudent");
            }
            if(s.getAttribute("UpdateSucFaculty")!=null)
            {
                out.println((String)s.getAttribute("UpdateSucFaculty"));
                s.removeAttribute("UpdateSucFaculty");
            }
            if(s.getAttribute("UpdateUnsucFaculty")!=null)
            {
                out.println((String)s.getAttribute("UpdateUnsucFaculty"));
                s.removeAttribute("UpdateUnsucFaculty");
            }
            if(s.getAttribute("HODAdded")!=null)
            {
                out.println((String)s.getAttribute("HODAdded"));
                s.removeAttribute("HODAdded");
            }
            if(s.getAttribute("HODError") != null)
            {
                out.println((String)s.getAttribute("HODError"));
                s.removeAttribute("HODError");
            }
        %>
    </body>
</html>
