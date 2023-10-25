<%-- 
    Document   : Add_Student
    Created on : 07-Oct-2022, 4:59:46 pm
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
        <title>Add Student Page</title>
    </head>
    <body>
        <form method="POST" action="AddStu.do">
            <label>Enrollment No.:</label>
            <input type="text" name="eno"><br><br>
            <label>Name:</label>
            <input type="text" name="name"><br><br>
            <label>Email:</label>
            <input type="email" name="email"><br><br>
            <label>Password:</label>
            <input type="password" name="pword"><br><br>
            <label>Department:</label>
            <select name="dept">
                <option value="CP">CP</option>
                <option value="IT">IT</option>
                <option value="ME">ME</option>
                <option value="FPT">FPT</option>
                <option value="CE">CE</option>
                <option value="AE">AE</option>                
                <option value="EE">EE</option>
                <option value="EC">EC</option>
            </select><br><br>
            <label>Subject1 grades:</label>
            <input type="number" min="0" max="10" step="0.01" name="sub1"><br><br>
            <label>Subject2 grades:</label> 
            <input type="number" min="0" max="10" step="0.01" name="sub2"><br><br>
            <label>Subject3 grades:</label>
            <input type="number" min="0" max="10" step="0.01" name="sub3"><br><br>
            <label>Status:</label><br><br>
            <input type="radio" name="status" value="PASS">PASS
            <input type="radio" name="status" value="FAIL">FAIL
            <input type="submit" value="Submit">
            
        </form>
    </body>
</html>
