import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class P8 (HelloCookie)
 */
@WebServlet("/HelloCookie")
public class P8 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public P8() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Create cookies for first and last names.
        Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
        Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));

        // Set expiry date after 24 Hrs for both cookies
        firstName.setMaxAge(60 * 60 * 24);
        lastName.setMaxAge(60 * 60 * 24);

        // Add cookies in response header
        response.addCookie(firstName);
        response.addCookie(lastName);

        // Set response content type
        response.setContentType("text/html");

        // Prepare HTML output
        PrintWriter out = response.getWriter();
        String title = "Setting Cookies Example";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";

        out.println(docType +
            "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
            "<h1 align = \"center\">" + title + "</h1>\n" +
            "<ul>\n" +
            "<li><b>First Name</b>: " + request.getParameter("first_name") + "\n" +
            "<li><b>Last Name</b>: " + request.getParameter("last_name") + "\n" +
            "</ul>\n" +
            "</body></html>");

        // Use session to store values
        HttpSession session = request.getSession();
        session.setAttribute("fname", request.getParameter("first_name"));
        session.setAttribute("lname", request.getParameter("last_name"));

        out.println("Value in session for fname is: " + session.getAttribute("fname").toString());
        out.println("Value in session for lname is: " + session.getAttribute("lname").toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
