package com.example.p6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/P6Servlet")
public class P6Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String idStr = request.getParameter("id");

        if ("Save".equals(action)) {
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            double salary = Double.parseDouble(request.getParameter("salary"));
            String department = request.getParameter("department");

            Employee employee = new Employee();
            employee.setName(name);
            employee.setAge(age);
            employee.setSalary(salary);
            employee.setDepartment(department);

            Employee.saveEmployee(employee);
        } else if ("Update".equals(action) && idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Employee employee = Employee.getEmployee(id);
            if (employee != null) {
                employee.setName(request.getParameter("name"));
                employee.setAge(Integer.parseInt(request.getParameter("age")));
                employee.setSalary(Double.parseDouble(request.getParameter("salary")));
                employee.setDepartment(request.getParameter("department"));

                Employee.updateEmployee(employee);
            }
        } else if ("Delete".equals(action) && idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Employee.deleteEmployee(id);
        } else if ("Fetch All".equals(action)) {
            List<Employee> employees = Employee.fetchEmployees();
            request.setAttribute("employees", employees);
        }

        request.getRequestDispatcher("P6.jsp").forward(request, response);
    }
}
