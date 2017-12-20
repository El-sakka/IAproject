/*
 * Made By  (c) ZizoNaser
 *  12/18/17 8:33 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.ReportModel;
import com.obj.Report;
import com.obj.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "GetReportsCtl")
public class GetReportsCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User LoggedInUser = (User) request.getSession().getAttribute("LoggedInUser");
        String html = "";
        if (true) {
            Vector<Report> reports = new ReportModel().getAllReports();
            for (Report report : reports) {
                if (report.getNew().equalsIgnoreCase("yes")) {
                    html += getNewReport(report.getReportID(), report.getReportText(), report.getUserName(), report.getFormId());
                } else {
                    html += getOldReport(report.getReportID(), report.getReportText(), report.getUserName(), report.getFormId());
                }
            }
            response.getWriter().write(html);
        }

    }

    private String getNewReport(int ReportID, String text, String userName, int formId) {
        return "<tr class=\"bg-info\" id =" + ReportID + ">\n" +
                "                    <td>\n" +
                "                        <a href=\"#\">\n" +
                "                            <img src=\"img/unKnown.jpg\" class=\"circle\"  style=\"height:3em;width:3em\" />\n" +
                "                        </a>\n" +
                "                    </td>\n" +
                "                    <td >" + userName + "</td>\n" +
                "                    <td >" + text + "</td>\n" +
                "                    <td >" + formId + "</td>\n" +
                "                    <td>\n" +
                "                        <span class=\"btn btn-sm btn-warning read\" title=\"Mark as Read\">o</span>\n" +
                "                        <span class=\"btn btn-sm btn-danger remove\" title=\"Delete\">X</span>\n" +
                "                    </td>";
    }

    private String getOldReport(int ReportID, String text, String userName, int formId) {
        return "<tr  id =" + ReportID + ">\n" +
                "                    <td>\n" +
                "                        <a href=\"#\">\n" +
                "                            <img src=\"img/unKnown.jpg\" class=\"circle\"  style=\"height:3em;width:3em\" />\n" +
                "                        </a>\n" +
                "                    </td>\n" +
                "                    <td >" + userName + "</td>\n" +
                "                    <td >" + text + "</td>\n" +
                "                    <td >" + formId + "</td>\n" +
                "                    <td>\n" +

                "                        <span class=\"btn btn-sm btn-danger remove\" title=\"Delete\">X</span>\n" +
                "                    </td>";
    }

}
