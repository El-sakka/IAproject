/*
 * Made By  (c) ZizoNaser
 *  12/15/17 10:46 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.UserModel;
import com.obj.User;
import com.utils.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangePasswordCtl")
public class ChangePasswordCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Redirect the client to the home page
        response.sendRedirect("/index.jsp");
        //That's All! Done!! Enjoy ;)
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Required Parameters are:
        //                      LoggedInUser and userName
        //Prepare the variable
        User LoggedInUser = (User) request.getSession().getAttribute("LoggedInUser");
        String userName = LoggedInUser.getUserName();
        String oldPass = request.getParameter("Oldpassword");
        String newPass = request.getParameter("Newpassword");
        User toChange = new UserModel().getUserByUserName(userName);
        if (LoggedInUser.getType().equalsIgnoreCase("admin") || toChange.getPassword().equals(MD5.md5(oldPass))) {
            new UserModel().ChangePassword(userName, MD5.md5(newPass));
        }
        //Redirect the client to the home page
        response.sendRedirect("/index.jsp");
        //That's All! Done!! Enjoy ;)
    }
}
