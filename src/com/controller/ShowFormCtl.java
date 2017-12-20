/*
 * Made By  (c) ZizoNaser
 *  12/19/17 4:40 AM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.FormModel;
import com.model.OptionModel;
import com.model.QuestionModel;
import com.obj.Form;
import com.obj.Options;
import com.obj.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

@WebServlet(name = "ShowFormCtl")
public class ShowFormCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int formId = Integer.parseInt(request.getParameter("formId"));
        System.out.println(formId);
        Form form = new FormModel().getForm(formId);
        PrintWriter out = response.getWriter();
        out.println(getStartHtmlCode());
        if (form.getSuspended().equalsIgnoreCase("yes")) {
            out.println("<h1>This Form Has been suspended</h1>" +
                    "            </form>\n" +
                    "\n" +
                    "          </div>\n" +
                    "        </div>\n" +
                    "\n" +
                    "      </div>\n" +
                    "\n" +
                    "\n" +
                    "<!-- Footer -->\n" +
                    "    <nav class=\"navbar bg-faded fixed-bottom opicitBack \">\n" +
                    "        <div class=\"container-fluid align-content-center\">\n" +
                    "            Made By  <a class=\"align-self-center text-white\" target=\"_tab\" href=\"#\">3L Corpe.</a> &copy;2017\n" +
                    "        </div>\n" +
                    "    </nav>\n" +
                    "\n" +
                    "    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n" +
                    "    <script src=\"js/jquery.min.js\"></script>\n" +
                    "    <!-- Include all compiled plugins (below), or include individual files as needed -->\n" +
                    "    <script src=\"js/tether.min.js\"></script>\n" +
                    "    <script src=\"js/bootstrap.min.js\"></script>\n" +
                    "    <script src=\"js/fillForm.js\">   </script>\n" +
                    "\n" +
                    "  </body>\n" +
                    "</html>\n");
        } else {
            Vector<Question> questions = new QuestionModel().getQuestionsByFormID(formId);
            int i = 0;
            String html = "<input type ='hidden' name='QuestionCount' value='" + questions.size() + "'> \n"
                    + "<input type ='hidden' name='formId' value='" + formId + "'> \n";
            for (Question question : questions
                    ) {
                if (question.getQuestionType().equalsIgnoreCase("MCQ")) {
                    html += getMCQQeustion(question, i);
                } else if (question.getQuestionType().equalsIgnoreCase("CB")) {
                    html += getCBQuestion(question, i);
                } else if (question.getQuestionType().equalsIgnoreCase("SA")) {
                    html += getSAQuestion(question, i);
                } else {
                    html += getTrueFalseQuestion(question, i);
                }
                i++;
            }
            out.println(html);
            System.out.println(formId);
            out.println(getEndHtmlCode(formId));
            System.out.println(formId);
        }


    }

    private String getCBOption(Options options, int i, int j) {
        return "                    <div class=\"funkyradio w-50\">\n" +
                "                        <div class=\"funkyradio-danger \">\n" +
                "                            <input type=\"checkbox\"   name=\"AnswerQuestion" + i + "\" id=\"Answer" + j + "Qeustion" + i + "\" value=\"" + options.getOptionText() + "\"  />\n" +
                "                            <label for=\"Answer" + j + "Qeustion" + i + "\">" + options.getOptionText() + "</label>\n" +
                "                        </div>\n" +
                "                    </div>\n";
    }

    private String getMCQOption(Options options, int i, int j) {
        return "<div class=\"funkyradio w-50\">\n" +
                "                        <div class=\"funkyradio-danger \">\n" +
                "                            <input type=\"radio\"   name=\"AnswerQuestion" + i + "\" id=\"Answer" + j + "Qeustion" + i + "\" value=\"" + options.getOptionText() + "\" />\n" +
                "                            <label for=\"Answer" + j + "Qeustion" + i + "\">" + options.getOptionText() + "</label>\n" +
                "                        </div>\n" +
                "                    </div>";
    }

    private String getMCQQeustion(Question question, int i) {
        String startHtml = "  <div id=\"Question" + i + "\" class=\"options\">\n" +
                "                 <input type='hidden' name='Question" + i + "-type' value='MCQ'> " +
                "                   <input type=\"hidden\" name=\"Question" + i + "-id\" value=" + question.getID() + ">" +
                "                <h4>" + question.getQuestionText() + "</h4>\n";
        String endingHtml = " </div>\n" +
                "              <hr>";
        String txt = "";
        Vector<Options> options = new OptionModel().getOptions(question.getID());
        for (int j = 0; j < options.size(); j++) {
            txt += getMCQOption(options.elementAt(j), i, j);
        }
        return startHtml + txt + endingHtml;
    }

    private String getCBQuestion(Question question, int i) {
        Vector<Options> options = new OptionModel().getOptions(question.getID());
        String startHtml = "  <div id=\"Question" + i + "\" class=\"options\">\n" +
                "                 <input type='hidden' name='Question" + i + "-type' value='CB'> " +
                "                   <input type=\"hidden\" name=\"Question" + i + "-id\" value=" + question.getID() + ">" +
                "                <h4>" + question.getQuestionText() + "</h4>\n";
        String endingHtml = " </div>\n" +
                "              <hr>";
        String txt = "";
        for (int j = 0; j < options.size(); j++) {
            txt += getCBOption(options.elementAt(j), i, j);
        }
        return startHtml + txt + endingHtml;
    }

    private String getSAQuestion(Question question, int i) {
        return "<div id=\"Question" + i + "\">\n" +
                "               <input  type='hidden' name='Question" + i + "-type' value='SA'>" +
                "                   <input type=\"hidden\" name=\"Question" + i + "-id\" value=" + question.getID() + ">" +
                "                <h4>" + question.getQuestionText() + "</h4>\n" +
                "                <div class=\"form-group w-75\">\n" +
                "                  <textarea class=\"form-control\" name='AnswerQuestion" + i + "' id=\"Question" + i + "Answer\" rows=\"4\"></textarea>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "              <hr>";
    }

    private String getTrueFalseQuestion(Question question, int i) {
        return "  <div id=\"Question" + i + "\">\n" +
                "                   <input type='hidden' name='Question" + i + "-type' value='ToF'>" +
                "                   <input type=\"hidden\" name=\"Question" + i + "-id\" value=" + question.getID() + ">" +
                "                <h4>" + question.getQuestionText() + "</h4>\n" +
                "                <div class=\"funkyradio w-50\">\n" +
                "                    <div class=\"funkyradio-success \">\n" +
                "                        <input type=\"radio\"  name=\"AnswerQuestion" + i + "\" id=\"Answer1Qeustion" + i + "\" value=\"true\" checked required />\n" +
                "                        <label for=\"Answer1Qeustion" + i + "\">True</label>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"funkyradio w-50\">\n" +
                "                    <div class=\"funkyradio-danger \">\n" +
                "                        <input type=\"radio\" name=\"AnswerQuestion" + i + "\" id=\"Answer2Qeustion" + i + "\" value=\"false\" />\n" +
                "                        <label for=\"Answer2Qeustion" + i + "\">false</label>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "              </div>";
    }

    private String getStartHtmlCode() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n" +
                "      <title>Form</title>\n" +
                "      <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"img/icon2.png\" />\n" +
                "    <!-- Bootstrap -->\n" +
                "    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "    <!-- css -->\n" +
                "    <link rel=\"stylesheet\" href=\"css/Defalut.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/fillForm.css\">\n" +
                "  </head>\n" +
                "  <body >\n" +
                "    <!--Header -->\n" +
                "      <nav class=\"navbar navbar-toggleable-md navbar-light bg-faded fixed-top opicitBack \">\n" +
                "        <div class=\"container\">\n" +
                "           <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "            <span class=\"navbar-toggler-icon\"></span>\n" +
                "          </button>\n" +
                "          <a class=\"navbar-brand\" href=\"/index.jsp\">Form <img src=\"img/icon2.png\" /> </a>\n" +
                "\n" +
                "          <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
                "            <ul class=\"navbar-nav mr-auto\" id=\"navItems\">\n" +
                "              <li class=\"nav-item active\">\n" +
                "                <a class=\"nav-link\" href=\"/index.jsp\">Home <span class=\"sr-only\">(current)</span></a>\n" +
                "              </li>\n" +
                "              <li class=\"nav-item\">\n" +
                "                <a class=\"nav-link\" href=\"#\">about</a>\n" +
                "              </li>\n" +
                "            </ul>\n" +
                "              <a href=\"#\" class=\"btn btn-danger\"> LogOut</a>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </nav>\n" +
                "<!--Body  -->\n" +
                "      <div class=\"container\">\n" +
                "        <div class=\"jumbotron \">\n" +
                "          <div class=\"container \">\n" +
                "\n" +
                "            <form action='/FillFormCtl' method='Post'>";
    }

    private String getEndHtmlCode(int formId) {
        return "  <input type=\"submit\" class=\"btn btn-danger float-right\" id=\"submit\" value=\"Submit\"/>\n" +
                "\n" +
                "\n" +
                "<a href='AddReport.jsp?formId=" + formId + "'><div class='btn btn-primary btn-lg' >Report</div></a> " +
                "            </form>\n" +
                "\n" +
                "          </div>\n" +
                "        </div>\n" +
                "\n" +
                "      </div>\n" +
                "\n" +
                "\n" +
                "<!-- Footer -->\n" +
                "    <nav class=\"navbar bg-faded fixed-bottom opicitBack \">\n" +
                "        <div class=\"container-fluid align-content-center\">\n" +
                "            Made By  <a class=\"align-self-center text-white\" target=\"_tab\" href=\"\">3L Corpe.</a> &copy;2017\n" +
                "        </div>\n" +
                "    </nav>\n" +
                "\n" +
                "    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n" +
                "    <script src=\"js/jquery.min.js\"></script>\n" +
                "    <!-- Include all compiled plugins (below), or include individual files as needed -->\n" +
                "    <script src=\"js/tether.min.js\"></script>\n" +
                "    <script src=\"js/bootstrap.min.js\"></script>\n" +
                "    <script src=\"js/fillForm.js\">   </script>\n" +
                "\n" +
                "  </body>\n" +
                "</html>\n";
    }
}

