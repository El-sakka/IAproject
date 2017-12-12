/*
    Made By ZizoNaser
    @ Sat Dec 9, 1:53pm
    Twitter: @ZizoNaser
 */
package com.obj;

public class Form {
    private int ID;
    private String Name;
    private String Suspended;
    private String userName;

    public Form(String name, String suspended, String userName) {
        Name = name;
        Suspended = suspended;
        this.userName = userName;
    }

    public Form(int ID, String name, String suspended, String userName) {
        this.ID = ID;
        Name = name;
        Suspended = suspended;
        this.userName = userName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSuspended() { return Suspended; }

    public void setSuspended(String suspended) { Suspended = suspended; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Form{" +
                ", ID='" + ID + '\'' +
                "Name='" + Name + '\'' +
                "Suspended='" + Suspended + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
