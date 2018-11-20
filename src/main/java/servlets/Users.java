package servlets;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "Users")
public class Users {
    List<User> usersList=new ArrayList<>();

    @Override
    public String toString() {
        return "Users{" +
                "usersList=" + usersList +
                '}';
    }

    public Users() {
    }

    @XmlElement(name="user")
    public  List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(User user) {
        usersList.add(user);
    }

}
