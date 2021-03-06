/*
    Made By ZizoNaser
    @ Sat Dec 9, 1:58pm
    Twitter: @ZizoNaser
 */
package com.obj;


public class Question {
    private int ID;
    private String questionText;
    private String questionType;
    private String Required;
    private int formID;

    public Question(int ID, String questionText, String questionType, String required, int formID) {
        this.ID = ID;
        this.questionText = questionText;
        this.questionType = questionType;
        Required = required;
        this.formID = formID;
    }

    public Question(String questionText, String questionType, String required, int formID) {
        this.questionText = questionText;
        this.questionType = questionType;
        Required = required;
        this.formID = formID;
    }

    public String getRequired() {
        return Required;
    }

    public void setRequired(String required) {
        Required = required;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFormID() {
        return formID;
    }

    public void setFormID(int formID) {
        this.formID = formID;
    }

    @Override
    public String toString() {
        return "Question{" +
                "ID=" + ID +
                ", questionText='" + questionText + '\'' +
                ", questionType='" + questionType + '\'' +
                ", Required='" + Required + '\'' +
                ", formID=" + formID +
                '}';
    }
}
