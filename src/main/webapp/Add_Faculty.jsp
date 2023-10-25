<%-- 
    Document   : Add_Faculty
    Created on : 07-Oct-2022, 4:59:36 pm
    Author     : Manoj
--%>
<% 
    HttpSession s = request.getSession(false);
    if(s == null || s.getAttribute("AdminEnroll") == null)
    {
        response.sendRedirect("Teacher_Login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Faculty Page</title>
    </head>
    <body>
        <form method="POST" action="AddFac.do">
            
        </form>
    </body>
</html>
