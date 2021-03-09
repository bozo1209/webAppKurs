package przyklady;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

@WebServlet("/headers")
public class HeadersServlet extends HttpServlet {

    @Override
    // By ANY means that's not the way of creating views!
    // But until we reach JSP I'll stick to it.
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseWriter = resp.getWriter();

        // By ANY means that's not the way of generating views.
        // It's just here as an example, referr to JSP to see how to prepare basic views in a better way.
        responseWriter.write("<html><body>");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headerValues = req.getHeaders(headerName);
            while (headerValues.hasMoreElements()) {
                String headerValue = headerValues.nextElement();
                responseWriter.write("<p>naglowek: " + headerName + ", wartosc: " + headerValue + "</p>");
            }
        }

        responseWriter.write("<p> nowe naglowki </p>");
        responseWriter.write("<br/>");
        resp.addHeader("my-custom-header1", "value1");
        resp.addHeader("my-custom-header1", "valued");
        resp.setIntHeader("my-custom-int-header", 123);

        Collection<String> headerNames3 = resp.getHeaderNames();


        headerNames3.forEach(y -> responseWriter.write("<p>" + y + "  resp.getHeaders(y): " + resp.getHeaders(y) + " |   resp.getHeader(y): " + resp.getHeader(y) + "</p>"));
        headerNames3.stream().map(x -> resp.getHeaders(x)).forEach(z -> responseWriter.write("<p>" + z + "</p>"));



        responseWriter.write("</body></html>");
    }
}