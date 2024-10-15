<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
</head>
<body>
    <h2>Product Selection</h2>
    <form action="ShoppingServlet" method="post">
        <label>Select a product:</label><br>
        <input type="checkbox" name="product" value="Laptop"> Laptop ($1000)<br>
        <input type="checkbox" name="product" value="Phone"> Phone ($500)<br>
        <input type="checkbox" name="product" value="Headphones"> Headphones ($100)<br>
        <input type="submit" value="Add to Cart">
    </form>

    <hr>
    <h2>Your Cart</h2>
    <%
        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart != null && !cart.isEmpty()) {
    %>
        <ul>
            <% for (String product : cart) { %>
                <li><%= product %></li>
            <% } %>
        </ul>
        <form action="ShoppingServlet" method="get">
            <input type="hidden" name="action" value="checkout">
            <input type="submit" value="Proceed to Checkout">
        </form>
    <%
        } else {
    %>
        <p>Your cart is empty.</p>
    <%
        }
    %>

    <hr>
    <h2>Billing</h2>
    <%
        Integer totalAmount = (Integer) session.getAttribute("totalAmount");
        if (totalAmount != null) {
    %>
        <p>Total Amount to Pay: $<%= totalAmount %></p>
    <%
        }
    %>
</body>
</html>
