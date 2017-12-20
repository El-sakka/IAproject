/*
 * Made By  (c) ZizoNaser
 *  12/13/17 8:39 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.AnswerModel;
import com.obj.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FillFormCtl")
public class FillFormCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numQuestions = Integer.parseInt(request.getParameter("QuestionCount"));
        AnswerModel answerModel = new AnswerModel();
        User LoggedInUser = (User) request.getSession().getAttribute("LoggedInUser");
        int questionID, formId = Integer.parseInt(request.getParameter("formId"));
        String AnswerText, QuestionType;
        for (int i = 0; i < numQuestions; i++) {
            questionID = Integer.parseInt(request.getParameter("Question" + (i) + "-id"));
            QuestionType = request.getParameter("Question" + (i) + "-type");
            if (QuestionType.equalsIgnoreCase("CB")) {
                String[] ans = request.getParameterValues("AnswerQuestion" + i);
                for (String s :
                        ans) {
                    answerModel.addAnswer(s, questionID, formId, LoggedInUser.getUserName(), "yes");
                }
            } else {
                AnswerText = request.getParameter("AnswerQuestion" + i);
                answerModel.addAnswer(AnswerText, questionID, formId, LoggedInUser.getUserName(), "yes");
            }

        }
        response.sendRedirect("/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
    }
}
