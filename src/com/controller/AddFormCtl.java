package com.controller;

import com.model.FormModel;
import com.model.OptionModel;
import com.model.QuestionModel;
import com.model.UserModel;
import com.obj.Form;
import com.obj.Options;
import com.obj.Question;
import com.obj.User;

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
        User LoggedInUser = (User) session.getAttribute("LoggedInUser");
        LoggedInUser = new User("zizo", "testt", "123", "ss", "admin");
        //If there is Logged in User
        if (LoggedInUser != null) {
            //If user isn't Suspended
            if (LoggedInUser.getType() != "sus") {
                //Add new Form for the USer
                form = formModel.addForm(FormName, "no", LoggedInUser.getUserName());
                //Loop on All Questions
                for (int i = 1; i <= QuestionCount; i++) {
                    //Get required data
                    QuestionText = request.getParameter("Question" + i + "-text");
                    QuestionType = request.getParameter("Question" + i + "-type");
                    QuestionRequirement = request.getParameter("Question" + i + "-requirement");
                    question = questionModel.addQuestion(QuestionText, QuestionType, QuestionRequirement, form.getID());
                    if (QuestionType.equals("MCQ") || QuestionType.equals("CB")) {
                        //Get Options Count
                        AnswerCount = Integer.parseInt(request.getParameter("Answers" + i + "Count"));
                        //Loop On All options add them to the dataBase Linked to the Question
                        for (int j = 1; j <= AnswerCount; j++) {
                            AnswerText = request.getParameter("Answer" + j + "Question" + i);
                            option = optionModel.addOption(AnswerText, question.getID());
                        }
                    } else if (QuestionType.equalsIgnoreCase("ToF")) {
                        optionModel.addOption("true", question.getID());
                        optionModel.addOption("false", question.getID());
                    }
                }
            }
            //Redirect the client to the home page where the form is added
            response.sendRedirect("/index.jsp");
        } else {
            //Redirect the client to the home page
            response.sendRedirect("/index.jsp");
        }
        //That's All! Done!! Enjoy;)
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
        //That's All! Done!! Enjoy;)
    }
}
