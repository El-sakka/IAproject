/*
 * Made By  (c) ZizoNaser
 *  12/12/17 8:01 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */


package com.obj;

public class Report {
    private int ReportID;
    private String ReportText;
    private String New;
    private String userName;
    private int FormId;

    public Report(int reportID, String reportText, String aNew, String userName, int formId) {
        ReportID = reportID;
        ReportText = reportText;
        New = aNew;
        this.userName = userName;
        FormId = formId;
    }

    public Report(String reportText, String aNew, String userName, int formId) {
        ReportText = reportText;
        New = aNew;
        this.userName = userName;
        FormId = formId;
    }

    public int getReportID() {
        return ReportID;
    }

    public void setReportID(int reportID) {
        ReportID = reportID;
    }

    public String getReportText() {
        return ReportText;
    }

    public void setReportText(String reportText) {
        ReportText = reportText;
    }

    public int getFormId() {
        return FormId;
    }

    public void setFormId(int formId) {
        FormId = formId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNew() {

        return New;
    }

    public void setNew(String aNew) {
        New = aNew;
    }

    @Override
    public String toString() {
        return "Report{" +
                "ReportID=" + ReportID +
                ", ReportText='" + ReportText + '\'' +
                ", New='" + New + '\'' +
                ", userName='" + userName + '\'' +
                ", FormId=" + FormId +
                '}';
    }
}
