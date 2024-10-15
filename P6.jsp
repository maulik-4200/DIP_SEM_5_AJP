<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Management</title>
</head>
<body>
    <h2>Employee Form</h2>
    <form action="P6Servlet" method="post">
        <label for="id">ID (for update/delete):</label>
        <input type="text" id="id" name="id"><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br>

        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" required><br>

        <label for="department">Department:</label>
        <input type="text" id="department" name="department" required><br>

        <input type="submit" name="action" value="Save">
        <input type="submit" name="action" value="Update">
        <input type="submit" name="action" value="Delete">
        <input type="submit" name="action" value="Fetch All">
    </form>

    <h2>Employee List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Salary</th>
            <th>Department</th>
        </tr>

        <% 
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
            if (employees != null) {
                for (Employee employee : employees) {
        %>
                    <tr>
                        <td><%= employee.getId() %></td>
                        <td><%= employee.getName() %></td>
                        <td><%= employee.getAge() %></td>
                        <td><%= employee.getSalary() %></td>
                        <td><%= employee.getDepartment() %></td>
                    </tr>
        <% 
                }
            } 
        %>
    </table>
</body>
</html>
