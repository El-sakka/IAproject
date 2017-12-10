/*
    Made By ZizoNaser
    @ Sat Dec 10, 2:58 pm
    Twitter: @ZizoNaser
 */
package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogOutCtl")
public class LogOutCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //no parameters needed
        //get the session object
        HttpSession session= request.getSession();
        //set the logged-in user to null
        session.setAttribute("LoggedInUser",null);
        //redirect the client to the home page
        response.sendRedirect("/index.jsp");
        //that's all. Done! Enjoy ;)
    }
}
