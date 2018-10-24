package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Shturik on 04.10.2018.
 */
@WebServlet({"/forum"})
public class ForumServlet extends HttpServlet {


    private static void TableCod(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
    }

    private ArrayList<Message> messages = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TableCod(req, resp);
        try {
            parametr(req, resp, false);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TableCod(req, resp);
        try {
            parametr(req, resp, true);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    //предача инфы на jsp chat
    private void TableChat(HttpServletRequest req, HttpServletResponse resp, String nick, ArrayList groups, String group) throws IOException, ServletException {

        req.getServletContext().setAttribute("mes", messages);

        req.getServletContext().setAttribute("groups", groups);
        req.getServletContext().setAttribute("myGroup", group);
        req.getServletContext().setAttribute("nick", nick);

        req.getRequestDispatcher("MessagerChat.jsp").forward(req, resp);
    }

    private void parametr(HttpServletRequest req, HttpServletResponse resp, boolean method) throws IOException, ServletException, XMLStreamException {
        String nick = req.getParameter("nickname");
        String message = req.getParameter("messageParam");
        String myGroup = req.getParameter("thisGroup");
            ArrayList<String> groups = new ArrayList<>();
            groups.add("allChat");
            groups.add("sport");
            groups.add("auto");
            groups.add("work");
            Message msg = new Message();
            for (String gr : groups) {
                if (method && myGroup.equals(gr)) {
                    if (!com.belhard.utils.StringUtils.isBlank(message)) {

                        messages.add(0, new Message(nick, message, msg.getDateForum(), myGroup));
                    }
                }
            }

            TableChat(req, resp, nick, groups, myGroup);

        }

    }


