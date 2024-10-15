<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome!</h1>
    <%
        String username = (String) session.getAttribute("username");
        if (username != null) {
    %>
        <p>Hello, <%= username %>!</p>
        <p><a href="LogoutServlet">Logout</a></p>
    <%
        } else {
    %>
        <p>You are not logged in. <a href="login.html">Login here</a></p>
    <%
        }
    %>
</body>
</html>
