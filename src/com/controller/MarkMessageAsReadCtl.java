/*
 * Made By  (c) ZizoNaser
 *  12/18/17 4:46 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.MessageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MarkMessageAsReadCtl")
public class MarkMessageAsReadCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Parameters MessageID
        int msgID = Integer.parseInt(request.getParameter("msgID"));
        new MessageModel().MarkAsRead(msgID);

    }
}
