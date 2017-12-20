/*
    Made By ZizoNaser
    @ Sat Dec 9, 2:01pm
    Twitter: @ZizoNaser
 */
package com.obj;

public class Answer {

    private int ID;
    private String answerText;
    private int questionID;
    private int formID;
    private String userName;
    private String avail;

    public Answer(int ID, String answerText, int questionID, int formID, String userName, String avail) {
        this.ID = ID;
        this.answerText = answerText;
        this.questionID = questionID;
        this.formID = formID;
        this.userName = userName;
        this.avail = avail;
    }

    public Answer(String answerText, int questionID, int formID, String userName, String avail) {
        this.answerText = answerText;
        this.questionID = questionID;
        this.formID = formID;
        this.userName = userName;
        this.avail = avail;
    }

    public int getFormID() {
        return formID;
    }

    public void setFormID(int formID) {
        this.formID = formID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "ID=" + ID +
                ", answerText='" + answerText + '\'' +
                ", questionID=" + questionID +
                ", formID=" + formID +
                ", userName='" + userName + '\'' +
                ", avail='" + avail + '\'' +
                '}';
    }

    public String getAvail() {
        return avail;
    }

    public void setAvail(String avail) {
        this.avail = avail;
    }
}
