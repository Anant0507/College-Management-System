<%-- 
    Document   : WelcomeStu
    Created on : 04-Oct-2022, 5:11:28 pm
    Author     : Manoj
--%>

<% 
    HttpSession s = request.getSession(false);
    if(s == null || s.getAttribute("Enrollment") == null)
    {
        response.sendRedirect("Student_Login.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Student Page</title>
    </head>
    <body>
        <h1>Welcome 
            <% 
                out.println((String)s.getAttribute("Enrollment"));
                s.removeAttribute("Enrollment");
            %>
        </h1>
    </body>
</html>
