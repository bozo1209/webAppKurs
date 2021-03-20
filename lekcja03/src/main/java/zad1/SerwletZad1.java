package zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet(urlPatterns = "/filtrZad1", name = "servletFiltryZad1")
public class SerwletZad1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter respWriter = resp.getWriter();

        respWriter.write("<html><body>");
        respWriter.write("<p>1</p>");
        Enumeration<String> attributeNames = req.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String attributeName = attributeNames.nextElement();
            Object attributeValue = req.getAttribute(attributeName);
            respWriter.write("<p>" + attributeName + " : " + attributeValue + "</p>");
        }
        respWriter.write("</html></body>");

    }
}
