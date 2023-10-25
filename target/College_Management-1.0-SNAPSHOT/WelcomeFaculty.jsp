<%-- 
    Document   : WelcomeFaculty
    Created on : 05-Oct-2022, 7:15:48 pm
    Author     : Manoj
--%>
<% 
    HttpSession s = request.getSession(false);
    if(s == null || s.getAttribute("FacultyEnroll") == null)
    {
        response.sendRedirect("Student_Login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Faculty Page</title>
    </head>
    <body>
        Welcome 
        <% 
            if(s.getAttribute("FacultyEnroll")!=null)
            {
                out.println((String)s.getAttribute("FacultyEnroll"));
                s.removeAttribute("FacultyEnroll");
            }
        %>
        
         
        
    </body>
</html>
