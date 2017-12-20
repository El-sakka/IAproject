/*
 * Made By  (c) ZizoNaser
 *  12/18/17 9:21 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.ReportModel;
import com.obj.Report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "GetNewRptNumCtl")
public class GetNewRptNumCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vector<Report> reports = new ReportModel().getAllReports();
        int i = 0;
        for (Report report : reports
                ) {
            if (report.getNew().equalsIgnoreCase("yes")) ++i;

        }
        response.getWriter().write(i);
    }
}
