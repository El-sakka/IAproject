/*
    Made By ZizoNaser
    @ Sat Dec 9, 2:01pm
    Twitter: @ZizoNaser
 */
package com.obj;

public class Answer {

    private String ID;
    private String answerText;
    private String questionID;

    public Answer(String ID, String answerText, String questionID) {
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
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
