/*
 * Made By  (c) ZizoNaser
 *  12/18/17 3:37 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.MessageModel;
import com.obj.Message;
import com.obj.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "GetMessagesCtl")
public class GetMessagesCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //redirect Client to the home Page
        response.sendRedirect("/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vector<Message> msg = new Vector<Message>();
        User logged = (User) request.getSession().getAttribute("LoggedInUser");
        String userName = logged.getUserName();

        msg = new MessageModel().getMessagesForUser(userName);
        String text = "";
        for (Message tmp : msg) {
            if (tmp.getNew().equalsIgnoreCase("yes")) {
                text += getMessageNewHtml(tmp.getID(), tmp.getSender(), tmp.getText());
            } else {
                text += getMessageOldHtml(tmp.getID(), tmp.getSender(), tmp.getText());
            }
        }
        response.getWriter().write(text);
    }

    private String getMessageNewHtml(int msgID, String sender, String msgText) {
        return "<tr class=\"bg-warning\" id=" + msgID + ">\n" +
                "                  <td>\n" +
                "                      <a href=\"#\">\n" +
                "                      <img src=\"img/unKnown.jpg\" class=\"circle\"  style=\"height:3em;width:3em\" />\n" +
                "                      </a>\n" +
                "                    </td>\n" +
                "                  <td>" + sender + "</td>\n" +
                "                  <td>" + msgText + "</td>\n" +
                "                  <td>\n" +
                "                    <span class=\"btn btn-sm btn-info read\" title=\"Mark as Read\">o</span>\n" +
                "                    <span class=\"btn btn-sm btn-danger remove\" title=\"Delete\">X</span>\n" +
                "                  </td>\n" +
                "                </tr>";
    }

    private String getMessageOldHtml(int msgID, String sender, String msgText) {
        return "<tr id=" + msgID + " >\n" +
                "                  <td>\n" +
                "                      <a href=\"#\">\n" +
                "                      <img src=\"img/unKnown.jpg\" class=\"circle\"  style=\"height:3em;width:3em\" />\n" +
                "                      </a>\n" +
                "                    </td>\n" +
                "                  <td>" + sender + "</td>\n" +
                "                  <td>" + msgText + "</td>\n" +
                "                  <td>\n" +
                "                    <span class=\"btn btn-sm btn-danger remove\" title=\"Delete\">X</span>\n" +
                "                  </td>\n" +
                "                </tr>";
    }

}
