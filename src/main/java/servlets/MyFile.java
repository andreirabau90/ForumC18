package servlets;

import java.io.File;
import java.io.IOException;

public class MyFile {
    public static File myFile() throws IOException {
        File file = new File("C:\\Users\\Андрей\\ForumC18\\ForumC18\\src\\main\\resources\\UsersList.xml");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}