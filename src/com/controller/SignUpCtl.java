/*
    Made By ZizoNaser
    @ Sat Dec 10, 1:05pm
    Twitter: @ZizoNaser
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SignUpCtl")
public class SignUpCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Parameters Needed are:
        //                      String name, String userName, String password, String email, String type
        String name,userName,password ,email,type;
        //get parameters from the View
        name =request.getParameter("name");
        userName =request.getParameter("userName");
        password = MD5.md5( request.getParameter("password"));
        email= request.getParameter("email");
        type = "norm";
        //get UserModel to check for userName and email & to add user to the database
        UserModel userModel= new UserModel();
        //get User object to add as logged-in user in the session
        User user =null;
        if(userModel.checkUserNameAndEmail(userName,email)){//if the userName isn't used nor the email then add the user
            user=userModel.addUser(userName,password,type,name,email);
        }
        //get the session
        HttpSession session = request.getSession();
        //add attribute to the session carries the logged-in user
        session.setAttribute("LoggedInUser",user);
        // redirect the client to the home page
        response.sendRedirect("/index.jsp");
        //That's All. Done! Enjoy ;)
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // won't Need it

        response.sendRedirect("/index.jsp");

    }
}
