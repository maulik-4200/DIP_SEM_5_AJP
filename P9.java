package com.demoservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/P9Servlet")
public class P9 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "pass";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("P9.jsp");
        } else {
            response.sendRedirect("login.html?error=true");
        }
    }
}
