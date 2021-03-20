package zad2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@WebFilter(urlPatterns = "/filtrZad1")
public class FiltrZad2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.getWriter().write("<p>6</p>");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String nextElement = parameterNames.nextElement();
            String parameter = request.getParameter(nextElement);
//            String[] parameterValues = request.getParameterValues(nextElement);
            response.getWriter().write("<p>" + parameter + "</p>");
            if (parameter.equals("blokuj")){
                response.getWriter().write("<html><body>Zablokowane!</body></head>");
//                throw new ServletException();
                return;
            }
        }
        chain.doFilter(request, response);
        response.getWriter().write("<p>działąj</p>");
        response.getWriter().write("<p>7</p>");
    }

    @Override
    public void destroy() {

    }
}
