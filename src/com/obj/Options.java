/*
 * ZizoNaser
 * Copyright (c) 2017.
 */

package com.obj;

public class Options {
    private int ID;
    private String OptionText;
    private int QuestionID;

    public Options(String optionText, int questionID) {
        OptionText = optionText;
        QuestionID = questionID;
    }

    public Options(int ID, String optionText, int questionID) {
        this.ID = ID;
        OptionText = optionText;
        QuestionID = questionID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOptionText() {
        return OptionText;
    }

    public void setOptionText(String optionText) {
        OptionText = optionText;
    }

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int questionID) {
        QuestionID = questionID;
    }

    @Override
    public String toString() {
        return "Options{" +
                "ID='" + ID + '\'' +
                ", OptionText='" + OptionText + '\'' +
                ", QuestionID='" + QuestionID + '\'' +
                '}';
    }
}
