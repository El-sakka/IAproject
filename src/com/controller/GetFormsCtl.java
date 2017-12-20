/*
 * Made By  (c) ZizoNaser
 *  12/18/17 10:44 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.FormModel;
import com.obj.Form;
import com.obj.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "GetFormsCtl")
public class GetFormsCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User LoggedInUser = (User) request.getSession().getAttribute("LoggedInUser");
        Vector<Form> forms;
        String html = "";
        //LoggedInUser.getType().equalsIgnoreCase("admin")
        if (LoggedInUser.getType().equalsIgnoreCase("admin")) {
            forms = new FormModel().getAllForms();
            for (Form form : forms
                    ) {
                if (form.getSuspended().equalsIgnoreCase("yes")) {
                    html += getAdminSusFormsHtml(form.getID(), form.getName(), form.getUserName());
                } else {
                    html += getAdminNormFormsHtml(form.getID(), form.getName(), form.getUserName());
                }
            }
        } else {
            //LoggedInUser.getUserName()
            forms = new FormModel().getFormsByUserName(LoggedInUser.getUserName());
            for (Form form : forms
                    ) {
                if (form.getSuspended().equalsIgnoreCase("yes")) {
                    html += getUserSusFormsHtml(form.getID(), form.getName());
                } else {
                    html += getUserNormFormsHtml(form.getID(), form.getName());
                }
            }
        }
        response.getWriter().write(html);
    }

    private String getAdminNormFormsHtml(int formId, String formName, String userName) {
        return "  <tr id=" + formId + ">\n" +
                "        <td>  <a href='/ShowFormCtl?formId=" + formId + "' >        " + formName + "</a></td>  \n" +
                "        <td>  <a href='/ShowStatCtl?formId=" + formId + "' > ShowStat</a></td>  \n" +
                "                  <td>" + userName + "</td>\n" +
                "                  <td><a href=\"SendMsgFrom.jsp?formId=" + formId + "\"><span class=\"btn btn-sm btn-warning \" title=\"Send Message\">M</span> </a> </td>\n" +
                "                  <td>\n" +
                "                    <span class=\"btn btn-sm btn-info sus\" title=\"Suspend\">||</span>\n" +
                "                    <span class=\"btn btn-sm btn-danger remove\" title=\"Close\">X</span>\n" +
                "                  </td>\n" +
                "                </tr>";
    }

    private String getAdminSusFormsHtml(int formId, String formName, String userName) {
        return "  <tr id=" + formId + " class='bg-info'>\n" +
                "        <td>  <a href='/ShowFormCtl?formId=" + formId + "' >        " + formName + "</a></td>  \n" +
                "        <td>  <a href='/ShowStatCtl?formId=" + formId + "' > ShowStat</a></td>  \n" +
                "                  <td>" + userName + "</td>\n" +
                "                  <td><a href=\"SendMsgFrom.jsp?formId=" + formId + "\"><span class=\"btn btn-sm btn-warning \" title=\"Send Message\">M</span> </a> </td>\n" +
                "                  <td>\n" +
                "                    <span class=\"btn btn-sm btn-success resume\" title=\"Resume\"> > </span>\n" +
                "                    <span class=\"btn btn-sm btn-danger remove\" title=\"Close\">X</span>\n" +
                "                  </td>\n" +
                "                </tr>";
    }

    private String getUserNormFormsHtml(int formId, String formName) {
        return "  <tr id=" + formId + ">\n" +
                "        <td>  <a href='/ShowFormCtl?formId=" + formId + "' >        " + formName + "</a></td>  \n" +
                "        <td>  <a href='/ShowStatCtl?formId=" + formId + "' > ShowStat</a></td>  \n" +
                "                  <td>\n" +
                "                    <span class=\"btn btn-sm btn-info sus\" title=\"Suspend\">||</span>\n" +
                "                    <span class=\"btn btn-sm btn-danger remove\" title=\"Close\">X</span>\n" +
                "                  </td>\n" +
                "                </tr>";
    }

    private String getUserSusFormsHtml(int formId, String formName) {
        return "  <tr id=" + formId + " class='bg-info'>\n" +
                "        <td>  <a href='/ShowFormCtl?formId=" + formId + "' >        " + formName + "</a></td>  \n" +
                "        <td>  <a href='/ShowStatCtl?formId=" + formId + "' > ShowStat</a></td>  \n" +
                "                  <td>\n" +
                "                    <span class=\"btn btn-sm btn-success resume\" title=\"Resume\"> > </span>\n" +
                "                    <span class=\"btn btn-sm btn-danger remove\" title=\"Close\">X</span>\n" +
                "                  </td>\n" +
                "                </tr>";
    }
}
