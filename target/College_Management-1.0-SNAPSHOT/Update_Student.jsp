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
        <title>Update Student Page</title>
              
    </head>
    <body>
        Enrollment No.:<% 
            if(s.getAttribute("StudentEnroll")!=null)
            {
                out.println(s.getAttribute("StudentEnroll"));
            }            
        %><br><br>
        <form method="POST" action="UpdateStudent.do">
            <label>Name:</label>
            <input type="text" value="<%=s.getAttribute("StudentName")%>" name="name"><br><br>

            <label>Email:</label>
            <input type="text" value="<%=s.getAttribute("StudentEmail")%>" name="email"><br><br>


            <label>Password:</label>
            <input type="text" value="<%=s.getAttribute("StudentPassword")%>" name="pword"><br><br>
            <script>
                Remove();
            </script>
            <label>Department:</label>
            <select name="dept">
                <option value="<%=s.getAttribute("StudentDepartment")%>">No Change</option>
                <option value="CP">CP</option>
                <option value="IT">IT</option>
                <option value="ME">ME</option>
                <option value="FPT">FPT</option>
                <option value="CE">CE</option>
                <option value="AE">AE</option>                
                <option value="EE">EE</option>
                <option value="EC">EC</option>

            </select>
            <br><br>
            <label>Sub1:</label>
            <input type="number" min="0.00" max="10" step="0.01" value="<%=s.getAttribute("StudentSub1")%>" name="sub1"><br><br>
            <label>Sub2:</label>
            <input type="number" min="0.00" max="10" step="0.01" value="<%=s.getAttribute("StudentSub2")%>" name="sub2"><br><br>
            <label>Sub3:</label>
            <input type="number" min="0.00" max="10" step="0.01" value="<%=s.getAttribute("StudentSub3")%>" name="sub3"><br><br>
            <input type="radio" name="status" value="PASS" checked="checked">Pass
            <input type="radio" name="status" value="FAIL">Fail<br><br>
            <input type="submit" value="submit">
            <% 
                s.removeAttribute("StudentName");
                s.removeAttribute("StudentEmail");
                s.removeAttribute("StudentPassword");
                s.removeAttribute("StudentDepartment");
                s.removeAttribute("StudentSub1");
                s.removeAttribute("StudentSub2");
                s.removeAttribute("StudentSub3");
                s.removeAttribute("StudentStatus");
            %>
        </form>
    </body>
</html>
