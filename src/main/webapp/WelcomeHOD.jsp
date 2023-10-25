<% 
    HttpSession s = request.getSession(false);
    if(s == null || s.getAttribute("HODEnroll") == null)
    {
        response.sendRedirect("Student_Login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome HOD Page</title>
    </head>
    <body>
        Welcome <% 
            if(s.getAttribute("HODEnroll") != null)
            {
                out.println(s.getAttribute("HODEnroll"));
                s.removeAttribute("HODEnroll");
            }
            
        %>
    </body>
</html>
