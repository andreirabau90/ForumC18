package servlets;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Users")
public class Users {
    List<User> usersList=new ArrayList<User>();

    @Override
    public String toString() {
        return "Users{" +
                "usersList=" + usersList +
                '}';
    }

    public  List<User> getUsersList() {
        return usersList;
    }
    @XmlElement(name = "user")
    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
}
