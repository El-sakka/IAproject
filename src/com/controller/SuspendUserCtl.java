/*
 * Made By  (c) ZizoNaser
 *  12/15/17 9:22 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.UserModel;
import com.obj.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SuspendUserCtl")
public class SuspendUserCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //redirect Client to home Page
        response.sendRedirect("/index.jsp");
        //That's all! Done!! Enjoy ;)
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // required Parameter from the View are :
        //                                      LoggedInUser , userName(to be normalized)
        //prepare variables
        User admin;
        UserModel userModel = new UserModel();
        String userName;
        //Get the Session
        HttpSession session = request.getSession();
        //get the Parameters
        admin = (User) session.getAttribute("LoggedInUser");
        userName = request.getParameter("userName");
        //check if the user Is Admin
        // @Question : can Admin suspend Another Admin ? (yes assumed)
        if (admin.getType().equalsIgnoreCase("admin")) {
            //Normalize User
            userModel.SuspendUser(userName);
        }
        //redirect Client to home Page
        response.getWriter().write("Suspended");
        //That's all! Done!! Enjoy ;)
    }
}
