import org.joda.time.DateTime;
import org.joda.time.Days;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;

@WebServlet("/date")
public class DateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LocalDateTime now2 = LocalDateTime.now();
        LocalDateTime birth2 = LocalDateTime.of(1988, 6, 11, 0,0);
        Duration duration = Duration.between(birth2, now2);
        PrintWriter responseOutput = response.getWriter();
        responseOutput.append("<html><body>")
                .append("sekundy: ")
                .append("<br/>")
                .append("<img src=\"https://static.wikia.nocookie.net/naruto/images/0/09/Naruto_newshot.png/revision/latest?cb=20210223094656\"/>")
                .append("<br/>")
                .append(String.valueOf(duration.toSeconds()))
                .append("<br/>")
                .append("<br/>")
                .append("<img src=\"https://assets.puzzlefactory.pl/puzzle/292/559/original.jpg\"/>")
                .append("<br/>")
                .append("<br/>")
                .append("<iframe width=\"420\" height=\"315\"\n" +
                        "src=\"https://www.youtube.com/embed/tgbNymZ7vqY\">\n" +
                        "</iframe>")
                .append("</body></html>");
        responseOutput.append("<html>\n" +
                "<title>dddddddddd</title>\n" +
                "<body>\n" +
                "test\n" +
                "<br/>\n" +
                "\n" +
                "<br/>\n" +
                "<br/>\n" +
                "<br/>\n" +
                "<img src=\"https://static.wikia.nocookie.net/naruto/images/0/09/Naruto_newshot.png/revision/latest?cb=20210223094656\"/>\n" +
                "</body>\n" +
                "</html>");
    }
}