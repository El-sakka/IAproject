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
    private int FormId;

    public Report(String reportText, int formId) {
        ReportText = reportText;
        FormId = formId;
    }

    public Report(int reportID, String reportText, int formId) {
        ReportID = reportID;
        ReportText = reportText;
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

    @Override
    public String toString() {
        return "Report{" +
                "ReportID='" + ReportID + '\'' +
                ", ReportText='" + ReportText + '\'' +
                ", FormId='" + FormId + '\'' +
                '}';
    }

}
