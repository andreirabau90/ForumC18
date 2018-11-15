package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static servlets.NewFile.usersFile;
import static servlets.Unmarshaller.unmarshlling;

@WebServlet({"/forum1"})
public class UserXML extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nick = req.getParameter("nickname");
        String password = req.getParameter("pass");
        User user = new User(nick, password);
        usersFile();
        List<User> listUser;
        Users users = new Users();
        unmarshlling( users);
        listUser = users.getUsersList();
        if (users!=null)
        for (User i : listUser) {
            if (nick.equals(i.getNick()) && password.equals(i.getPassword())) {
                req.getServletContext().setAttribute("nickname", nick);
                req.getRequestDispatcher("forum").forward(req, resp);
            }
            } else {
                String error = "Ощибка авторизации!!!";
                req.getServletContext().setAttribute("error", error);
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }
}
