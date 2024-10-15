package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/ShoppingServlet")
public class P11 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Product prices
    private static final int LAPTOP_PRICE = 1000;
    private static final int PHONE_PRICE = 500;
    private static final int HEADPHONES_PRICE = 100;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Get selected products from the form
        String[] selectedProducts = request.getParameterValues("product");

        // Get the cart from session, or create a new one if it doesn't exist
        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Add selected products to the cart
        if (selectedProducts != null) {
            for (String product : selectedProducts) {
                cart.add(product);
            }
        }

        // Save the updated cart in session
        session.setAttribute("cart", cart);

        // Redirect back to JSP page to display cart
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("checkout".equals(action)) {
            HttpSession session = request.getSession();
            List<String> cart = (List<String>) session.getAttribute("cart");

            int totalAmount = 0;
            if (cart != null) {
                for (String product : cart) {
                    switch (product) {
                        case "Laptop":
                            totalAmount += LAPTOP_PRICE;
                            break;
                        case "Phone":
                            totalAmount += PHONE_PRICE;
                            break;
                        case "Headphones":
                            totalAmount += HEADPHONES_PRICE;
                            break;
                    }
                }
            }

            session.setAttribute("totalAmount", totalAmount);
            response.sendRedirect("index.jsp");
        }
    }
}
