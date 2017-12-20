/*
 * Made By  (c) ZizoNaser
 *  12/18/17 8:20 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.MessageModel;
import com.obj.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "GetNewMsgsNumCtl")
public class GetNewMsgsNumCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vector<Message> msg = new Vector<Message>();
        msg = new MessageModel().getMessagesForUser("Zizo1");
        int i = 0;
        for (Message tmp : msg
                ) {
            if (tmp.getNew().equalsIgnoreCase("yes")) i++;
        }
        response.getWriter().write(i);
    }
}
