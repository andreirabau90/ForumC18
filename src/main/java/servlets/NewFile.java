package servlets;

import java.io.File;
import java.io.IOException;

public class NewFile {


    public static File usersFile() throws IOException {
        ClassLoader classLoader = NewFile.class.getClassLoader();
        File file = new File(String.valueOf(classLoader.getResourceAsStream("/UsersList.xml")));
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}
