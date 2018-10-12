package servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


/**
 * Created by Shturik on 04.10.2018.
 */
@WebServlet({"/forum"})
public class ForumServlet extends HttpServlet {

    static void TableCod(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "text/html" );
    }

    private ArrayList <Message> messages = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TableCod( req, resp );
        parametr( req, resp, false );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TableCod( req, resp );
        parametr( req, resp, true );
    }

    public void TableChat(HttpServletResponse resp, String nick) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println( "<h3>Ваш ник - " + nick + "<h3>" );
        out.println( "Сообщения: " );

        for (int i = 0; i < messages.size(); i++) {
            out.println( "<h4>" + messages.get( i ).getAuthor() +
                    " : " + messages.get( i ).getText() + " " + messages.get( i ).getDateForum() + "<h4>" );
        }
        out.println( "<hr>" );
        out.println( "<form action=\"/forum\" method=\"post\">" );
        out.println( "<h4>" + nick + " : </h4>" );
        out.println( "<input type=\"text\" name=\"messageParam\"/>" );
        out.println( "<input type=\"hidden\" value=\"" + nick + "\" name=\"nickname\"/>" );
        out.println( "<input type=\"submit\" value=\"send\"/>" );
        out.println( "</form>" );
        out.println( "<hr>" );
    }

    public void parametr(HttpServletRequest req, HttpServletResponse resp, boolean method) throws IOException {
        String nick = req.getParameter( "nickname" );
        String message = req.getParameter( "messageParam" );
        Message date = new Message();

        if (method == true) {
            if (com.belhard.utils.StringUtils.isBlank( message ) == false) {

                messages.add( 0, new Message( nick, message, date.getDateForum() ) );
            }
        }
        TableChat( resp, nick );
    }
}
