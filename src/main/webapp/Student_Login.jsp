<%-- 
    Document   : Student_Login
    Created on : 04-Oct-2022, 4:34:01 pm
    Author     : Manoj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Login</title>
    </head>
    <body>
        <form metho="POST" action="StudentLogin.do">
            <label>Enrollment No.:</label>
            <input type="text" name="eno" placeholder="eg: 12002040601000"><br><br>
            <label>Password:</label>
            <input type="password" name="pword"><br><br>
            <input type="submit" value="submit">
        </form>
        <% 
            HttpSession s = request.getSession(false);
            String error =(String) s.getAttribute("WrongCredential");
            
            if(s.getAttribute("WrongCredential")!=null)
            {
                out.println(error);
                s.removeAttribute("WrongCredential");
            }
            
        %>
        <a href="Teacher_Login.jsp">Teacher Login</a>
        <a href="Admin_Login.jsp">Admin Login</a>
    </body>
</html>
