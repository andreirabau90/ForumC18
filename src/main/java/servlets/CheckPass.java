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
import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xerces.internal.utils.SecuritySupport.getResourceAsStream;

@WebServlet({"/check"})
public class CheckPass extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {

        File file = new File("C:\\Users\\Андрей\\ForumC18\\ForumC18\\src\\main\\resources\\UsersList.xml");
        if (!file.exists()) {
            file.createNewFile();
        }
        String nick = req.getParameter("nickname");
        String password = req.getParameter("pass");
        String checkPass = req.getParameter("checkpass");
        Users users = new Users();
        List<User> listUser ;
        User newUser = new User(nick, password);
            try {
                JAXBContext uncontext = JAXBContext.newInstance(Users.class);
                Unmarshaller unmarshaller = uncontext.createUnmarshaller();
                users = (Users) unmarshaller.unmarshal(file);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            listUser = users.getUsersList();
            if (checkPass.equals("null")) {
                for (User user : listUser)
                    if (nick.equals(user.getNick()) && password.equals(user.getPassword())) {
                        req.getServletContext().setAttribute("nickname", nick);
                        req.getRequestDispatcher("/forum").forward(req, resp);



                    } else {
                        String error = "Ощибка авторизации!!!";
                        req.getServletContext().setAttribute("error", error);
                        req.getRequestDispatcher("index.jsp").forward(req, resp);
                    }
            } else if (password.equals(checkPass)) {
                if (listUser.size() != 0) {
                    for (User user : listUser)
                        if (nick.equals(user.getNick())) {
                            String error = "Пользователь с таким ником уже зарегистрирован!!!";
                            req.getServletContext().setAttribute("error", error);
                            req.getRequestDispatcher("index.jsp").forward(req, resp);

                        }
                }
                if (nick != null) {
                    users.setUsersList(newUser);
                    try {
                        JAXBContext context = JAXBContext.newInstance(Users.class);
                        Marshaller marshaller = context.createMarshaller();
                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                        marshaller.marshal(users, file);
                        String error = "Регистрация прошла успешна!!!";
                        req.getServletContext().setAttribute("error", error);
                        req.getRequestDispatcher("index.jsp").forward(req, resp);
                    } catch (JAXBException e) {
                        System.out.println("NO work");
                    }
                }
            } else {
                String error = "Ошибка регистрации!!!";
                req.getServletContext().setAttribute("error", error);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }

    }
}


//
//if(users!=null)
//        for(User i:listUser){
//        if(nick.equals(i.getNick())&&password.equals(i.getPassword())){
//        req.getServletContext().setAttribute("nickname",nick);
//        req.getRequestDispatcher("/forum").forward(req,resp);
//        }
//        }else{
//        String error="Ощибка авторизации!!!";
//        req.getServletContext().setAttribute("error",error);
//        req.getRequestDispatcher("index.jsp").forward(req,resp);
//        }