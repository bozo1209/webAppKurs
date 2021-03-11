package zad1;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/filtrZad1")
public class Filrt1Zad1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setAttribute("filtr1Zad1Attribute", "filtr 1");
        response.getWriter().write("<p>czy wyjdzie?</p>");
        response.getWriter().write("<p>2</p>");
        chain.doFilter(request, response);
        response.getWriter().write("<p>" + request.getAttribute("filtr1Zad1Attribute") + "</p>");
        response.getWriter().write("<p>3</p>");
    }

    @Override
    public void destroy() {

    }
}
