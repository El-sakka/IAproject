/*
 * Made By  (c) ZizoNaser
 *  12/19/17 7:22 AM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.MessageModel;
import com.obj.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SendMsgtoUsr")
public class SendMsgtoUsr extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rec = request.getParameter("receiver");
        String msgtx = request.getParameter("msg");
        User Logged = (User) request.getSession().getAttribute("LoggedInUser");
        if (Logged.getType().equalsIgnoreCase("admin")) {
            new MessageModel().addMessage(msgtx, "yes", Logged.getUserName(), rec);
        }
        response.sendRedirect("/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
