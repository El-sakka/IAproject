/*
 * Made By  (c) ZizoNaser
 *  12/13/17 1:47 PM
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

@WebServlet(name = "CloseFormCtl")
public class CloseFormCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Required Parameters are:
        // FormID, LoggedInUser
        //prepare Variables
        int FormID;
        User LoggedInUser;
        Form form;
        //Get Model object
        FormModel formModel = new FormModel();
        //Get the Session
        HttpSession session = request.getSession();
        //Get the required Parameters from View
        FormID = Integer.parseInt(request.getParameter("FormID"));
        LoggedInUser = (User) session.getAttribute("LoggedInUser");
        //Get the Form
        form = formModel.getForm(FormID);
        //Check if the User Can Remove the Form ( Owns it OR he's an admin)
        if (form.getUserName().equals(LoggedInUser.getUserName()) || LoggedInUser.getUserName().equals("admin")) {
            //Suspend the Form
            formModel.removeForm(FormID);
        } else {
            //Redirect the client to the home Page
            response.sendRedirect("/index.jsp");
        }
        //That's All! Done!! Enjoy;)
    }
}
