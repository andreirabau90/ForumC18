package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.util.List;

@WebServlet({"/check"})
public class CheckPass extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {
        String nick = req.getParameter("nickname");
        String password = req.getParameter("pass");
        String checkPass = req.getParameter("checkpass");
        Users users = new Users();
        List<User> listUser;
        User newUser = new User(nick, password);
        try {
            JAXBContext uncontext = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = uncontext.createUnmarshaller();
            users = (Users) unmarshaller.unmarshal(MyFile.myFile());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        listUser = users.getUsersList();
        if (!(nick.trim().length() == 0 || password.trim().length() == 0)) {
            String error = "Ошибка авторизации";
            if (checkPass.equals("null")) {
                for (User user : listUser) {
                    if (nick.equals(user.getNick()) && password.equals(user.getPassword())) {
                        req.getServletContext().setAttribute("nickname", nick);
                        req.getRequestDispatcher("/forum").forward(req, resp);
                        break;
                    }
                }
            }
            if (password.equals(checkPass)) {
                boolean result = false;
                for (User user : listUser) {
                    if (nick.equals(user.getNick())) {
                        result = true;
                        error = "Пользователь с таким ником уже зарегистрирован!!!";
                        break;
                    }
                }
                if (!result) {
                    users.setUsersList(newUser);
                    try {
                        MyMarshaller.marsh(users);
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                    error = "Пользователь успешно зарегистрирован!!!";
                } else if (error.length() < 20 && !checkPass.equals("null")) {
                    error = "Ошибка регистрации!";
                }
            }
            req.getServletContext().setAttribute("error", error);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            req.getServletContext().setAttribute("error", "Вы ввели пустое значение");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}