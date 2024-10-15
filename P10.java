package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/AttendanceServlet")
public class P10 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String enrollmentNumber = request.getParameter("enrollment");

        // Mock database of student attendance
        if (enrollmentNumber != null && enrollmentNumber.equals("12345")) {
            String studentName = "John Doe";

            // List of subjects and attendance percentages
            List<String[]> attendance = new ArrayList<>();
            attendance.add(new String[]{"Mathematics", "85%"});
            attendance.add(new String[]{"Physics", "90%"});
            attendance.add(new String[]{"Chemistry", "75%"});
            attendance.add(new String[]{"Biology", "80%"});

            // Set student and attendance data in request
            request.setAttribute("studentName", studentName);
            request.setAttribute("attendance", attendance);
        } else {
            // If student not found, set an error message
            request.setAttribute("error", "No student found with this enrollment number.");
        }

        // Forward back to the JSP page to display results
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
