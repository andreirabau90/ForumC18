package servlets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;

public class MyMarshaller {
    public static Users marsh(Users users) throws IOException, JAXBException {

        JAXBContext context = JAXBContext.newInstance(Users.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(users,MyFile.myFile());
        return  users;
    }
}
