/*
 * ZizoNaser
 * Copyright (c) 2017.
 */

package com.obj;

public class Options {
    private String ID;
    private String OptionText;
    private String QuestionID;

    public Options(String ID, String optionText, String questionID) {
        this.ID = ID;
        OptionText = optionText;
        QuestionID = questionID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getOptionText() {
        return OptionText;
    }

    public void setOptionText(String optionText) {
        OptionText = optionText;
    }

    public String getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(String questionID) {
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
