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

    public Answer(String answerText, int questionID) {
        this.answerText = answerText;
        this.questionID = questionID;
    }

    public Answer(int ID, String answerText, int questionID) {
        this.ID = ID;
        this.answerText = answerText;
        this.questionID = questionID;
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
                ", ID='" + ID + '\'' +
                "answerText='" + answerText + '\'' +
                ", questionID='" + questionID + '\'' +
                '}';
    }
}
