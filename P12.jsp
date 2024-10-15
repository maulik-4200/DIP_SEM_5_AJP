<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
</head>
<body>
    <h2>Student Registration Form</h2>
    <form action="P12Servlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="course">Course:</label>
        <input type="text" id="course" name="course" required><br>

        <input type="submit" value="Register">
    </form>

    <hr>

    <h2>Admin Dashboard: Registered Students</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Email</th>
            <th>Course</th>
        </tr>

        <% 
            java.util.List<Student> students = (java.util.List<Student>) request.getAttribute("students");
            if (students != null && !students.isEmpty()) {
                for (Student student : students) {
        %>
                    <tr>
                        <td><%= student.getName() %></td>
                        <td><%= student.getAge() %></td>
                        <td><%= student.getEmail() %></td>
                        <td><%= student.getCourse() %></td>
                    </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="4">No students registered yet.</td>
            </tr>
        <% 
            } 
        %>
    </table>
</body>
</html>
