package zad1;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(servletNames = "servletFiltryZad1")
public class Filtr2Zad1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.getWriter().write("<p>4</p>");
        request.setAttribute("filtr2Zad1Attribute", "filtr 2");
        chain.doFilter(request, response);
        response.getWriter().write("<p>weszło <3</p>");
        response.getWriter().write("<p>5</p>");
    }

    @Override
    public void destroy() {

    }
}
