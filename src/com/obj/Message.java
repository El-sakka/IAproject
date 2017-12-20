/*
 * Made By  (c) ZizoNaser
 *  12/18/17 1:06 AM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.obj;

public class Message {
    private int ID;
    private String Text;
    private String New;
    private String Sender;
    private String Receive;

    public Message(int ID, String text, String aNew, String sender, String receive) {
        this.ID = ID;
        Text = text;
        New = aNew;
        Sender = sender;
        Receive = receive;
    }

    public Message(String text, String aNew, String sender, String receive) {
        Text = text;
        New = aNew;
        Sender = sender;
        Receive = receive;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getNew() {
        return New;
    }

    public void setNew(String aNew) {
        New = aNew;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getReceive() {
        return Receive;
    }

    public void setReceive(String receive) {
        Receive = receive;
    }

    @Override
    public String toString() {
        return "Message{" +
                "ID=" + ID +
                ", Text='" + Text + '\'' +
                ", New='" + New + '\'' +
                ", Sender='" + Sender + '\'' +
                ", Receive='" + Receive + '\'' +
                '}';
    }
}

