package servlets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;

import static servlets.NewFile.usersFile;

public class Unmarshaller {


    public static void unmarshlling(Users users){

        try {
            JAXBContext uncontext = null;
            uncontext = JAXBContext.newInstance(Users.class);
            javax.xml.bind.Unmarshaller unmarshaller = uncontext.createUnmarshaller();
            users = (Users) unmarshaller.unmarshal(usersFile());
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
