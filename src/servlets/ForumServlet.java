package servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



/**
 * Created by Shturik on 04.10.2018.
 */
@WebServlet({"/forum"})
public class ForumServlet extends HttpServlet {


    private ArrayList <Message> messages = new ArrayList();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding( "UTF-8" );
        resp.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "text/html" );


        String nick = req.getParameter( "nickname" );
        String message = req.getParameter( "messageParam" );
        Message date = new Message();


        if (message != null) {

            messages.add( 0, new Message( nick, message, date.getDateForum() ) );
        }

        //3
        PrintWriter out = resp.getWriter();
        out.println( "<h3>Ваш ник - " + nick + "<h3>" );
        out.println( "Сообщения: " );


        for (int i = 0; i < messages.size(); i++) {
            out.println( "<h4>" + messages.get( i ).getAuthor() +
                    " : " + messages.get( i ).getText() + " " + messages.get( i ).getDateForum() + "<h4>" );
        }

        out.println( "<hr>" );


//        String str = "Миша сказал: \"Влад, ты разобрался?\"";

//        nick
        //4
        out.println( "<form action=\"/forum\">" );
        out.println( "<h4>" + nick + " : </h4>" );
        out.println( "<input type=\"text\" name=\"messageParam\"/>" );
        out.println( "<input type=\"hidden\" value=\"" + nick + "\" name=\"nickname\"/>" );
        // out.println("<input type=\"hidden\" value=\"" + date+ "\" name=\"dateForum\"/>");
        out.println( "<input type=\"submit\" value=\"send\"/>" );
        out.println( "</form>" );
        out.println( "<hr>" );
        //1


    }

}

