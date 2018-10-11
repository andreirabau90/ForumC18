//package servlets;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//
////import static servlets.ForumServlet.Type;
//@WebServlet({"/Chat"})
//public class ChatServlet extends HttpServlet {
//    private ArrayList <Message> messages = new ArrayList();
//
//
//
//
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      //  Type( req, resp );
//        String[] message1= null;
//        String nick = req.getParameter( "nickname" );
//        String message = req.getParameter( "messageParam" );
//        Message date = new Message();
//
//
//        if (message != null) {
//
//            messages.add( 0, new Message( nick, message, date.getDateForum() ) );
//        }
//
//        for (Message m:messages)
//
////            for (int i = 0; i < messages.size(); i++) {
//            //    messages.get( i ).getAuthor() + ":" + messages.get( i ).getText() + "  " + messages.get( i ).getDateForum();
//
//                req.getServletContext().setAttribute( "mes", m );
//
//           // req.getServletContext().setAttribute( "mes1", messages.get( 0 ).getText() );
//           // req.getServletContext().setAttribute( "mes2", messages.get( 0 ).getDateForum() );
//            req.getRequestDispatcher( "/MessagerChat.jsp" ).forward( req, resp );
//
//    }
//}