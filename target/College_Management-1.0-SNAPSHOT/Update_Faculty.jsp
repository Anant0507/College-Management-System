<%-- 
    Document   : Update_Faculty
    Created on : 07-Oct-2022, 4:59:10 pm
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
        <title>Update Faculty Page</title>
    </head>
    <body>
        <form method="POST" action="UpdateFac.do">
            <label>ID:</label><% out.println(s.getAttribute("id")); %>
            <label>Name:</label>
            <input type="text" name="name" value=<%=s.getAttribute("name")%>><br>
            
            <label>Email:</label>
            <input type="text" name="email" value=<%=s.getAttribute("email")%>><br>
            
            <label>Password:</label>
            <input type="text" name="pass" value=<%=s.getAttribute("pass")%>><br>
            
            <label>Department:</label>
            <input type="text" name="dept" value=<%=s.getAttribute("dept")%>><br>
            
            <label>Qualification:</label>
            <input type="text" name="quali" value=<%=s.getAttribute("quali")%>><br>
            
            <label>Subject Code:</label>
            <input type="text" name="scode" value=<%=s.getAttribute("Scode")%>><br>
            
            <label>Subject Name:</label>
            <input type="text" name="sname" value=<%=s.getAttribute("SubName")%>><br>
            
            <input type="submit" value="Save Changes">
        </form>
    </body>
</html>
