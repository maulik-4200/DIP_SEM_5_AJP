import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class PageHitCounter
 */
@WebServlet("/PageHitCounter")
public class P7 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Counter to track the number of hits
    private int hitCount;

    public P7() {
        super();
    }

    public void init() {
        // Reset hit counter
        hitCount = 0;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Increment hit count
        hitCount++;

        // Prepare HTML output
        PrintWriter out = response.getWriter();
        String title = "Total Number of Hits";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
        
        out.println(docType + 
            "<html>\n" + 
            "<head><title>" + title + "</title></head>\n" + 
            "<body bgcolor = \"#f0f0f0\">\n" + 
            "<h1 align = \"center\">" + title + "</h1>\n" + 
            "<h2 align = \"center\">" + hitCount + "</h2>\n" + 
            "</body></html>"
        );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Handle POST request by calling doGet method
        doGet(request, response);
    }

    public void destroy() {
        // Optional step: Reset the counter or store in the database
        hitCount = 0;
    }
}
