package zadanie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;


@WebServlet("/serwlet")
public class Zadanie2 extends HttpServlet {

    public static final String ZAPIS_SUMY_KLUCZ = "ZAPIS_SUMY_KLUCZ";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseOutput = resp.getWriter();
        responseOutput.write("<html><body>");
//        responseOutput.write("roz 1");
//        rozwiazanie1(req, responseOutput);
//        responseOutput.write("roz 2");
//        rozwiazanie2(req, responseOutput);
//        responseOutput.write("roz 3");
//        rozwiazanie3(req, responseOutput);
//        jeden test!!!!!!!!!!
        responseOutput.write("<p>jeden test!!!!</p>");
        HttpSession session = req.getSession();
        int licz = rozwiazanie3(req, responseOutput);
        int suma = pamietacz(session, licz);
        responseOutput.write("<p> requestSum:" + licz + "</p>");
        responseOutput.write("<p> totalSum:" + suma + "</p>");
        responseOutput.write("</html></body>");
    }

    static void rozwiazanie1(HttpServletRequest req, PrintWriter responseOutput){
        for (Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()){
            responseOutput.write("<p>" + entry.getKey() + ": " + entry.getValue()[0] + "</p>");
        }
    }

    static void rozwiazanie2(HttpServletRequest req, PrintWriter responseOutput){
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String nextElement = parameterNames.nextElement();
            responseOutput.write("<p>" + nextElement + " : " + req.getParameter(nextElement) + "</p>");
        }
    }

    static int rozwiazanie3(HttpServletRequest req, PrintWriter responseOutput){
            Enumeration<String> parameterNames = req.getParameterNames();
            int suma = 0;
            int licz = 0;
            while (parameterNames.hasMoreElements()){
                String nextElement = parameterNames.nextElement();
                try {
                    licz = Integer.parseInt(req.getParameter(nextElement));
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
                suma += licz;
                licz = 0;
            }
            return suma;
    }

    static int pamietacz(HttpSession session, int doZap){
        Object staraSuma = 0;
        try {
            staraSuma = session.getAttribute(ZAPIS_SUMY_KLUCZ);
        }catch (Exception e){
            e.printStackTrace();
        }
        int nowaSuma = doZap;
        try {
            nowaSuma = Integer.parseInt(staraSuma.toString()) + doZap;
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        session.setAttribute(ZAPIS_SUMY_KLUCZ, nowaSuma);
        return nowaSuma;
    }

}
