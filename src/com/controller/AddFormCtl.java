package com.controller;

import com.model.FormModel;
import com.model.OptionModel;
import com.model.QuestionModel;
import com.model.UserModel;
import com.obj.Form;
import com.obj.Options;
import com.obj.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddFormCtl")
public class AddFormCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get Number of Questions
        int QuestionCount = Integer.parseInt(request.getParameter("QuestionCount")), AnswerCount;
        //Prepare Variables
        String QuestionText, QuestionType, questionId, AnswerText, FormName = request.getParameter("FromName"), QuestionRequirement;
        Form form;
        Question question;
        Options option;
        //Prepare Models
        UserModel userModel = new UserModel();
        FormModel formModel = new FormModel();
        QuestionModel questionModel = new QuestionModel();
        OptionModel optionModel = new OptionModel();
        //get the session from the request
        HttpSession session = request.getSession();
        //get the loggedInUser
//        User LoggedInUser = (User) session.getAttribute("LoggedInUser");
        //If there is Logged in User
        // LoggedInUser != null
        if (true) {
            //Add new Form for the USer
            form = formModel.addForm(FormName, "no", "testt");
            //Loop on All Questions
            for (int i = 1; i <= QuestionCount; i++) {
                QuestionText = request.getParameter("Question" + i + "-text");
                QuestionType = request.getParameter("Question" + i + "-type");
                QuestionRequirement = request.getParameter("Question" + i + "-requirement");
                question = questionModel.addQuestion(QuestionText, QuestionType, QuestionRequirement, form.getID());
                System.out.println(QuestionText + "/n" + QuestionType);
                if (QuestionType.equals("MCQ") || QuestionType.equals("CB")) {
                    System.out.println("Got Here");
                    AnswerCount = Integer.parseInt(request.getParameter("Answers" + i + "Count"));
                    for (int j = 1; j <= AnswerCount; j++) {
                        AnswerText = request.getParameter("Answer" + j + "Question" + i);
                        option = optionModel.addOption(AnswerText, question.getID());
                    }
                }

            }
            response.sendRedirect("/index.jsp");
        } else {
            response.sendRedirect("/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
    }
}
