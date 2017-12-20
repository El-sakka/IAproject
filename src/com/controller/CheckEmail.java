/*
 * Made By  (c) ZizoNaser
 *  12/19/17 1:58 AM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckEmail")
public class CheckEmail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        if (new UserModel().getUserByEmail(email) != null) {
            System.out.println(new UserModel().getUserByEmail(email));
            response.getWriter().write("Used");
        } else {
            response.getWriter().write("Valid");
        }
    }
}
