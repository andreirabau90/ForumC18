package servlets;

import java.io.File;
import java.io.IOException;

public class NewFile {
    public static File usersFile() throws IOException {
        File file = new File("Users.xml");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}
