package servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


/**
 * Created by Shturik on 04.10.2018.
 */
@WebServlet({"/forum"})
public class ForumServlet extends HttpServlet {

    private static void TableCod(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
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

    private void TableChat(HttpServletRequest req,HttpServletResponse resp, String nick) throws IOException, ServletException {
        req.getServletContext().setAttribute("mes", messages);
        req.getServletContext().setAttribute("nick", nick);

        req.getRequestDispatcher("/MessagerChat.jsp").forward(req, resp);

    }

    private void parametr(HttpServletRequest req, HttpServletResponse resp, boolean method) throws IOException, ServletException {
        String nick = req.getParameter( "nickname" );
        String message = req.getParameter( "messageParam" );
        Message date = new Message();

        if (method) {
            if (!com.belhard.utils.StringUtils.isBlank( message )) {

                messages.add( 0, new Message( nick, message, date.getDateForum() ) );
            }
        }
        TableChat(req, resp, nick );
    }
}
