package zadania;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet("/servletZadania")
public class ServletZadania extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<html><body>");
        ServletContext servletContext = req.getServletContext();
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            String parameter = req.getParameter(parameterName);
            servletContext.setAttribute(parameterName, parameter);
        }

        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String attributeName = attributeNames.nextElement();
            printWriter.write("<p>" + attributeName + ": " + servletContext.getAttribute(attributeName) + "<p>");
        }
        printWriter.write("</html></body>");
    }
}
