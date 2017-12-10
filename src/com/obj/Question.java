/*
    Made By ZizoNaser
    @ Sat Dec 9, 1:58pm
    Twitter: @ZizoNaser
 */
package com.obj;


public class Question {
    private String ID;
    private String questionText;
    private String questionType;
    private String formID;

    public Question(String ID, String questionText, String questionType, String formID) {
        this.ID = ID;
        this.questionText = questionText;
        this.questionType = questionType;
        this.formID = formID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFormID() {
        return formID;
    }

    public void setFormID(String formID) {
        this.formID = formID;
    }

    @Override
    public String toString() {
        return "Question{" +
                ", ID='" + ID + '\'' +
                "questionText='" + questionText + '\'' +
                ", questionType='" + questionType + '\'' +
                ", formID='" + formID + '\'' +
                '}';
    }
}
