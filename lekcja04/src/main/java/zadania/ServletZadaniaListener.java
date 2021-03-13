package zadania;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;

@WebListener
public class ServletZadaniaListener implements ServletContextAttributeListener {

    String KONCOWKA = "when";

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        ServletContext servletContext = event.getServletContext();
        String eventName = event.getName();
        String[] eventNameCheck = eventName.split("\\.");
        if (!eventNameCheck[eventNameCheck.length - 1].equals(KONCOWKA)){
            servletContext.setAttribute(eventName + "." + KONCOWKA, LocalDate.now());
        }
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {

    }
}
