package servlets;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;
@XmlRootElement(name = "user")
public class User  {
    private String nick;
    private String password;


    public User(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }
//    @XmlElement
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
//    @XmlElement
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}


