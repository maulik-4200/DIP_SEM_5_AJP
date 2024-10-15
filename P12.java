package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.*;

@WebServlet("/P12Servlet")
public class P12 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // In-memory list to store student data
    private List<Student> studentList = new ArrayList<>();

    // Handle POST request for form submission
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the student details from the form
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        // Create a new student object and add it to the list
        Student student = new Student(name, age, email, course);
        studentList.add(student);

        // Add the student list to the request and forward to the JSP
        request.setAttribute("students", studentList);
        request.getRequestDispatcher("P12.jsp").forward(request, response);
    }

    // Simple Student class
    public static class Student {
        private String name;
        private int age;
        private String email;
        private String course;

        public Student(String name, int age, String email, String course) {
            this.name = name;
            this.age = age;
            this.email = email;
            this.course = course;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getEmail() {
            return email;
        }

        public String getCourse() {
            return course;
        }
    }
}
