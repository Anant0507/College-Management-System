<%-- 
    Document   : Admin_Login
    Created on : 11-Oct-2022, 9:44:48 am
    Author     : Manoj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login Page</title>
    </head>
    <body>
        <form method="POST" action="AdminLogin.do">
            <label>Enrollment:</label>
            <input type="text" name="eno"><br><br>
            <label>Password:</label>
            <input type="password" name="pword"><br><br>
            <input type="submit" value="submit">
        </form>
        <% 
            HttpSession s = request.getSession(false);
            if(s.getAttribute("AdminError") != null)
            {
                out.println((String)s.getAttribute("AdminError"));
                s.removeAttribute("AdminError");
            }   
        %>
    </body>
</html>
