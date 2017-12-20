/*
 * Made By  (c) ZizoNaser
 *  12/19/17 7:26 AM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.AnswerModel;
import com.model.MessageModel;
import com.model.QuestionModel;
import com.obj.Question;
import com.obj.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "SendMsgToForm")
public class SendMsgToForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int formId = Integer.parseInt(request.getParameter("formId"));
        String msgtx = request.getParameter("msg");
        User Logged = (User) request.getSession().getAttribute("LoggedInUser");
        Vector<Question> questions = new QuestionModel().getQuestionsByFormID(formId);
        if (Logged.getType().equalsIgnoreCase("admin") && questions.size() > 0) {
            Question question = questions.elementAt(0);
            Vector<String> Users = new AnswerModel().getUserNameForQuestionID(question.getID());
            for (String s :
                    Users) {
                new MessageModel().addMessage(msgtx, "yes", Logged.getUserName(), s);
            }
        }
        response.sendRedirect("/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
