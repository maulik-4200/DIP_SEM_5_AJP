<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Attendance</title>
</head>
<body>

    <h2>Enter Enrollment Number to View Attendance</h2>
    <form action="AttendanceServlet" method="post">
        <label>Enrollment Number:</label>
        <input type="text" name="enrollment" required>
        <input type="submit" value="View Attendance">
    </form>
    
    <hr>

    <%
        List<String[]> attendance = (List<String[]>) request.getAttribute("attendance");
        String studentName = (String) request.getAttribute("studentName");

        if (attendance != null && studentName != null) {
    %>
        <h2>Attendance for <%= studentName %></h2>
        <table border="1">
            <tr>
                <th>Subject</th>
                <th>Attendance (%)</th>
            </tr>
            <%
                for (String[] subject : attendance) {
            %>
                <tr>
                    <td><%= subject[0] %></td>
                    <td><%= subject[1] %></td>
                </tr>
            <% } %>
        </table>
    <% } else if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>

</body>
</html>
