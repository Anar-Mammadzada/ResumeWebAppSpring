<%-- 
    Document   : user
    Created on : Apr 22, 2022, 9:57:59 AM
    Author     : Anar
--%>

<%@page import="entity.User"%>
<%@page import="daoInter.UserDaoInter"%>
<%@page import="main.Contextt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User u = (User) request.getAttribute("user");
        %>
        <div>
            <form action="userdetail" method="POST"/>
            <input type="hidden" name ="id" value="<%=u.getId()%>"/>
            <label for="name">name:</label>
            <input type="text" name="name" value="<%=u.getName()%>"/>
            <br/>
            <label for="surname">surname:</label>
            <input type="text" name="surname" value="<%=u.getSurname()%>"/>
            <input type="submit" name="save" value="Save"/>
        </form>
    </div>
</body>
</html>
