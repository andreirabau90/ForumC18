package servlets;

import javax.servlet.http.HttpServlet;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement
@XmlType(propOrder = {"nick","password"})
public class Users extends HttpServlet {
    private String nick;
    private String password;


    public Users(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }
    @XmlElement
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    @XmlElement
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


