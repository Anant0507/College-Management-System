<%-- 
    Document   : Add_HOD
    Created on : 12-Oct-2022, 2:40:21 pm
    Author     : Manoj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="AddHOD.do">
            <label>Enrollment No.:</label>
            <input type="text" name="eno"><br><br>
            <label>Name:</label>
            <input type="text" name="name"><br><br>
            <label>Email:</label>
            <input type="email" name="email"><br><br>
            <label>Password:</label>
            <input type="password" name="pword"><br><br>
            <label>Department:</label>
            <input type="text" name="dept"><br><br>
            <input type="submit" value="submit">
        </form>
        
    </body>
</html>
