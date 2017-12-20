/*
 * Made By  (c) ZizoNaser
 *  12/19/17 7:49 AM
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
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "GetUsers")
public class GetUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vector<User> all = new UserModel().getAll();
        String html = "";
        for (User user : all
                ) {
            html += getUserHTML(user);
        }
        response.getWriter().write(html);
    }

    private String getUserHTML(User user) {
        return "<tr>\n" +
                "                    <td>" + user.getName() + "</td>\n" +
                "                    <td>" + user.getUserName() + "</td>\n" +
                "                    <td>" + user.getEmail() + "</td>\n" +
                "                    <td >options</td>\n" +
                "                </tr>" +
                "";
    }
}
