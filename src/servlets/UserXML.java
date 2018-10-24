package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

@WebServlet({"/forum1"})
public class UserXML extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nick = req.getParameter("nickname");
        String password = req.getParameter("pass");
    String result=req.getParameter("registr");
        Users users = new Users(nick, password);
        try {
            creid(users, nick, password, req, resp);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        req.getServletContext().setAttribute("nickname", nick);
        req.getRequestDispatcher("/forum").forward(req, resp);

    }

    public void creid(Users users, String nick, String password, HttpServletRequest req, HttpServletResponse resp) throws JAXBException, IOException, ServletException {
        File file = new File("C:\\Users\\Андрей\\IdeaProjects\\ForumC18\\src\\servlets\\Users.xml");
        if (!file.exists()) {
            file.createNewFile();
        }

        JAXBContext uncontext = JAXBContext.newInstance(Users.class);
        Unmarshaller unmarshaller = uncontext.createUnmarshaller();
        File xml = new File("C:\\Users\\Андрей\\IdeaProjects\\ForumC18\\src\\servlets\\Users.xml");
        Users users1 = (Users) unmarshaller.unmarshal(xml);

        if (nick.equals(users1.getNick()) && password.equals(users1.getPassword())) {
            try {
                JAXBContext context = JAXBContext.newInstance(Users.class);
                Marshaller marshaller;
                marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(users, new File("C:\\Users\\Андрей\\IdeaProjects\\ForumC18\\src\\servlets\\Users.xml"));

            } catch (JAXBException e) {
                System.out.println("NO work");
            }
        } else {
            String error = "вы не зарегистрированы!!!";
            req.getServletContext().setAttribute("error", error);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
