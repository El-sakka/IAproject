/*
    Made By ZizoNaser
    @ Sat Dec 10, 2:10pm
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


@WebServlet(name = "LogInCtl")
public class LogInCtl extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Parameters Needed are:
        //                      String userName String password
        String userName,password;
        //get the parameters from the View
        userName=request.getParameter("userName");
        password=request.getParameter("password");
        //get UserModel to validate the request
        UserModel userModel= new UserModel();
        //get User to hold the user object
        User user = userModel.getUserByUserName(userName);
        //get session object to add the logged-in user
        HttpSession session=request.getSession();
        if(user != null){
            //if user exists
            if(user.getPassword().equals(MD5.md5(password))){
                //if the password match add it to the session
                session.setAttribute("LoggedInUser",user);
            }else{
                //else add null
                session.setAttribute("LoggedInUser",null);
            }
        }else{
            //else add null
                session.setAttribute("LoggedInUser",null);
        }
        //redirect the client to the home page
        response.sendRedirect("/index.jsp");
        //that's all. Done! Enjoy ;)
    }


}
