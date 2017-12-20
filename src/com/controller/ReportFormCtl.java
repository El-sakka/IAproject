/*
 * Made By  (c) ZizoNaser
 *  12/13/17 9:27 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.ReportModel;
import com.obj.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ReportFormCtl")
public class ReportFormCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ReportTxt = request.getParameter("report-text");
        int formId = Integer.parseInt(request.getParameter("formId"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("LoggedInUser");
        if (user != null) {
            ReportModel reportModel = new ReportModel();

            reportModel.addReport(ReportTxt, "yes", formId, user.getUserName());
        }
        response.sendRedirect("/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
