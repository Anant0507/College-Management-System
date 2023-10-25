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
        <title>Search Student Page</title>
    </head>
    <body>
        <form method="POST" action="SearchStudent.do">
            <label>Enrollment No.:</label>
            <input type="text" name="eno"><br><br>
            <input type="submit" value="Search">
        </form>
    </body>
</html>
