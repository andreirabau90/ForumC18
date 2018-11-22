package servlets;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Shturik on 04.10.2018.
 */
public class Message {
    private String author;
    private String text;
    Date date= new Date();
    private String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    private String dateForum=String.format("%1$tB  %1$tm %1$tT",date);

    public Message(String author, String text, String dateForum,String group) {
        this.author = author;
        this.text = text;
        this.group = group;
        this.dateForum = dateForum;
    }

    public String getDateForum() {

        return dateForum;
    }

    public void setDateForum(String dateForum) {
        this.dateForum = dateForum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", dateForum='" + dateForum + '\'' +
                '}';
    }

    public Message() {

    }
}
