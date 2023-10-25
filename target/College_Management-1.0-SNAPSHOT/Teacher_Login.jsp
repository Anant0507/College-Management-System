<%-- 
    Document   : Teacher_Login.jsp
    Created on : 05-Oct-2022, 12:32:12 pm
    Author     : Manoj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher Login Page</title>
    </head>
    <body>
        <h1 align="center">Teacher Login Page</h1>
        <form method="POST" action="Teacher.do">
            <input type="radio" name="selectPost" value="HOD">HOD<br>
            <input type="radio" name="selectPost" value="Faculty">Faculty<br>
            <label>Enrollment No.:</label>
            <input type="text" name="eno"><br>
            <label>Password</label>
            <input type="password" name="pword"><br>
            <input type="submit" value="Submit">
        </form>
        <% 
            HttpSession s = request.getSession(false);
            if(s.getAttribute("HODError") != null)
            {
                out.println(s.getAttribute("HODError"));
                s.removeAttribute("HODError");
            }
        %>
    </body>
</html>
