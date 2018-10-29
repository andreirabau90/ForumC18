package servlets;

import servlets.UserXML;

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
import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

@WebServlet({"/check"})
public class CheckPass extends HttpServlet {
    public void usersFile() throws IOException {
        File file = new File("C:\\Users\\Андрей\\IdeaProjects\\ForumC18\\src\\servlets\\Users.xml");
        if (!file.exists()) {
            file.createNewFile();
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {

        String nick = req.getParameter("nickname");
        String password = req.getParameter("pass");
        String checkPass = req.getParameter("checkpass");
        Users users = new Users();
        usersFile();
        List<User> listUser;
        User user = new User(nick, password);

        JAXBContext uncontext = null;
        try {
            uncontext = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = uncontext.createUnmarshaller();
            File xml = new File("C:\\Users\\Андрей\\IdeaProjects\\ForumC18\\src\\servlets\\Users.xml");
            users = (Users) unmarshaller.unmarshal(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        listUser = users.getUsersList();
        if (listUser != null) {
            for (User i : listUser) {
                if ((nick.equals(i.getNick()))) {
                    String error = "Пользователь с таким ником уже зарегистрирован!!!";
                    req.getServletContext().setAttribute("error", error);
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
            }
        }else if (password.equals(checkPass)) {
            listUser.add(user);
            users.setUsersList(listUser);
            try {
                JAXBContext context = JAXBContext.newInstance(Users.class);
                Marshaller marshaller;
                marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(users, new File("C:\\Users\\Андрей\\IdeaProjects\\ForumC18\\src\\servlets\\Users.xml"));
                String error = "Регистрация прошла успешна!!!";
                req.getServletContext().setAttribute("error", error);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } catch (JAXBException e) {
                System.out.println("NO work");
            }
        } else {
            String error = "Ошибка регистрации!!!";
            req.getServletContext().setAttribute("error", error);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}

