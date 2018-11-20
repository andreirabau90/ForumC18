package servlets;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet({"/forum1"})
//public class UserXML extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String nick = req.getParameter("nickname");
//        String password = req.getParameter("pass");
//        List<User> listUser;
//        Users users = new Users();
//        try {
//            JAXBContext uncontext = JAXBContext.newInstance(Users.class);
//            Unmarshaller unmarshaller = uncontext.createUnmarshaller();
//            users = (Users) unmarshaller.unmarshal(NewFile.usersFile());
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        listUser = users.getUsersList();
//        if (users != null)
//            for (User i : listUser) {
//                if (nick.equals(i.getNick()) && password.equals(i.getPassword())) {
//                    req.getServletContext().setAttribute("nickname", nick);
//                    req.getRequestDispatcher("/forum").forward(req, resp);
//                }
//            }else {
//            String error = "Ощибка авторизации!!!";
//            req.getServletContext().setAttribute("error", error);
//            req.getRequestDispatcher("index.jsp").forward(req, resp);
//        }
//    }
//}
