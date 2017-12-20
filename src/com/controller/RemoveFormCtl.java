/*
 * Made By  (c) ZizoNaser
 *  12/15/17 10:35 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.FormModel;
import com.obj.Form;
import com.obj.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RemoveFormCtl")
public class RemoveFormCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Redirect the client to the home page
        response.sendRedirect("/index.jsp");
        //That's All! Done!! Enjoy ;)
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Parameters required are:
        //                      formId and LoggedInUser

        //prepare the variables
        int formId = Integer.parseInt(request.getParameter("formId"));
        HttpSession session = request.getSession(); //get the session
        User LoggedInUser = (User) session.getAttribute("LoggedInUser");//get the For
        //Get the Form
        Form form = new FormModel().getForm(formId);
//        LoggedInUser.getType().equalsIgnoreCase("Admin") || form.getUserName().equals(LoggedInUser.getUserName())
        if (true) {
            new FormModel().removeForm(formId);
        }

        //That's All! Done!! Enjoy ;)
    }
}
