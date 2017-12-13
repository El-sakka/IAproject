/*
 * Made By  (c) ZizoNaser
 *  12/13/17 5:33 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.controller;

import com.model.AnswerModel;
import com.model.OptionModel;
import com.model.QuestionModel;
import com.obj.Options;
import com.obj.Question;
import com.utils.Pair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

@WebServlet(name = "ShowStatCtl")
public class ShowStatCtl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get the writer object
        PrintWriter out = response.getWriter();
        //prepare variables
        String HtmlCodeStart = getHtmlCodeStart(), HtmlCodeEnd = getHtmlCodeEnd();
        int formId;
        Question question;
        Options option;
        //get the Models
        QuestionModel questionModel = new QuestionModel();
        OptionModel optionModel = new OptionModel();
        //get formId From the View
        formId = Integer.parseInt(request.getParameter("formId"));
        //Get Questions within the form
        Vector<Question> questions = questionModel.getQuestionsByFormID(formId);
        out.print(getHtmlCodeStart());
        for (int i = 0; i < questions.size(); i++) {
            question = questions.elementAt(i);
            if (question.getQuestionType().equalsIgnoreCase("Tof")) {
                out.print(getHtmlCodeForTF(i + 1, question));
            } else if (question.getQuestionType().equalsIgnoreCase("MCQ")) {
                out.print(getHtmlCodeForMCQ(i + 1, question));
            } else if (question.getQuestionType().equalsIgnoreCase("CB")) {
                out.print(getHtmlCodeForCB(i + 1, question));
            } else if (question.getQuestionType().equalsIgnoreCase("SA")) {
                out.print(getHtmlCodeForSA(i + 1, question));
            }
        }
        out.print(getHtmlCodeEnd());

    }

    private String getHtmlCodeStart() {
        return "<!DOCTYPE html> <html lang=\"en\"> \n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n" +
                "    <title>Statistics</title>\n" +
                "\n" +
                "    <!-- Bootstrap -->\n" +
                "    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "    <!-- Defaultcss -->\n" +
                "    <link rel=\"stylesheet\" href=\"css/Defalut.css\">\n" +
                "  </head>\n" +
                "  <body>\n" +
                "      <nav class=\"navbar navbar-toggleable-md navbar-light bg-faded fixed-top top-bar\">\n" +
                "        <div class=\"container\">\n" +
                "           <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "            <span class=\"navbar-toggler-icon\"></span>\n" +
                "          </button>\n" +
                "          <a class=\"navbar-brand\" href=\"#\">Form <img src=\"img/icon2.png\" /> </a>\n" +
                "\n" +
                "          <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
                "            <ul class=\"navbar-nav mr-auto\">\n" +
                "              <li class=\"nav-item active\">\n" +
                "                <a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\n" +
                "              </li>\n" +
                "              <li class=\"nav-item\">\n" +
                "                <a class=\"nav-link\" href=\"#\">about</a>\n" +
                "              </li>\n" +
                "            </ul>\n" +
                "              <button class=\"btn\">\n" +
                "                Login\n" +
                "              </button>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </nav>\n" +
                "      <div class=\"container\">\n" +
                "        <div class=\"jumbotron\">\n";

    }

    private String getHtmlCodeEnd() {
        return "  </div>\n" +
                "    </div>\n" +
                "      <nav class=\"navbar bg-faded fixed-bottom\">\n" +
                "        <div class=\"container-fluid align-content-center\">\n" +
                "            Made By  <a class=\"align-self-center\" target=\"_tab\" href=\"http://zizo.esy.es/\">ZizoNaser</a> &copy;2017\n" +
                "        </div>\n" +
                "\n" +
                "    </nav>\n" +
                "    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n" +
                "    <script src=\"js/jquery.min.js\"></script>\n" +
                "    <!-- Include all compiled plugins (below), or include individual files as needed -->\n" +
                "    <script src=\"js/tether.min.js\"></script>\n" +
                "    <script src=\"js/bootstrap.min.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
                "    <script type=\"text/javascript\">\n" +
                "\n" +
                "        // Load the Visualization API and the corechart package.\n" +
                "        google.charts.load('current', {'packages':['corechart']});\n" +
                "\n" +
                "        // Set a callback to run when the Google Visualization API is loaded.\n" +
                "        google.charts.setOnLoadCallback(drawChart);\n" +
                "\n" +
                "        // Callback that creates and populates a data table,\n" +
                "        // instantiates the pie chart, passes in the data and\n" +
                "        // draws it.\n" +
                "        function drawChart() {\n" +
                "\n" +
                "\n" +
                "\n" +
                "          // Set chart options\n" +
                "          var options = {'title':'Answers',\n" +
                "                          'width':'100%',\n" +
                "                          'height':300,\n" +
                "                          backgroundColor: { fill:'transparent' },\n" +
                "                         'is3D': true\n" +
                "                       };\n" +
                "        $(\".pie-charts\").each(function(){\n" +
                "\n" +
                "                    // Create the data table.\n" +
                "                    var data = new google.visualization.DataTable();\n" +
                "                    data.addColumn('string', 'Option');\n" +
                "                    data.addColumn('number', 'Count');\n" +
                "                    var question = $(this).attr('id');\n" +
                "                    var numberOfOptoins= parseInt($(this).attr('options'));\n" +
                "                    for (var i = 0; i <= numberOfOptoins; i++) {\n" +
                "                      data.addRow([$('#option'+i+question+'Text').html(),parseInt($('#option'+i+question+'Count').html())]);\n" +
                "                    }\n" +
                "                    // Instantiate and draw our chart, passing in some options.\n" +
                "                    var chart = new google.visualization.PieChart(document.getElementById(question+'-chart'));\n" +
                "                    chart.draw(data, options);\n" +
                "        });\n" +
                "        }\n" +
                "        function drawChart2() {\n" +
                "          // Set chart options\n" +
                "          var options = {'title':'QuestionI',\n" +
                "                          'width':'100%',\n" +
                "                          'height':300,\n" +
                "                          backgroundColor: { fill:'transparent' },\n" +
                "                         'is3D': true\n" +
                "                       };\n" +
                "        $(\".bar-charts\").each(function(){\n" +
                "\n" +
                "                    // Create the data table.\n" +
                "                    var data = new google.visualization.DataTable();\n" +
                "                    data.addColumn('string', 'Option');\n" +
                "                    data.addColumn('number', 'Count');\n" +
                "                    var question = $(this).attr('id');\n" +
                "                    var numberOfOptoins= parseInt($(this).attr('options'));\n" +
                "                    for (var i = 0; i <= numberOfOptoins; i++) {\n" +
                "                      data.addRow([$('#option'+i+question+'Text').html(),parseInt($('#option'+i+question+'Count').html())]);\n" +
                "                    }\n" +
                "                    // Instantiate and draw our chart, passing in some options.\n" +
                "                    var chart = new google.visualization.ColumnChart(document.getElementById(question+'-chart'));\n" +
                "                    chart.draw(data, options);\n" +
                "        });\n" +
                "        }\n" +
                "        google.charts.setOnLoadCallback(drawChart2);\n" +
                "      </script>\n" +
                "\n" +
                "  </body>\n" +
                "</html>\n";

    }

    private String getHtmlCodeForTF(int questionNumber, Question question) {
        AnswerModel answerModel = new AnswerModel();
        Vector<Pair<String, Integer>> answers = answerModel.getAnswersForQuestionID(question.getID());
        Pair<String, Integer> answer;
        int numTrue = 0;
        int numFalse = 0;
        for (int i = 0; i < answers.size(); i++) {
            answer = answers.elementAt(i);
            if (answer.getFirst().equalsIgnoreCase("true")) {
                numTrue += answer.getSecond();
            } else {
                numFalse += answer.getSecond();
            }
        }
        if (numTrue == 0 && numFalse == 0) {
            return "\n" +
                    "          <div class=\"container\">\n" +
                    "            <h2>Question " + questionNumber + "</h2>\n" +
                    "            <p>" + question.getQuestionText() + "</p>\n" +
                    "           <h3> No Answers yet</h3>" +
                    "          </div>\n" +
                    "          <hr>\n";

        }
        float propTrue = (float) numTrue / (numTrue + numFalse);
        float propFalse = 1f - propTrue;
        propTrue *= 100;
        propFalse *= 100;
        return "\n" +
                "          <div class=\"container\">\n" +
                "            <h2>Question " + questionNumber + "</h2>\n" +
                "            <p>" + question.getQuestionText() + "</p>\n" +
                "            <div class=\"progress\">\n" +
                "              <div class=\"progress-bar  bg-success progress-bar-striped progress-bar-animated\" role=\"progressbar\" style=\"width:" + propTrue + "%;height:2em;\">\n" +
                "                " + propTrue + "% True\n" +
                "              </div>\n" +
                "              <div class=\"progress-bar bg-danger progress-bar-striped progress-bar-animated\" role=\"progressbar\" style=\"width:" + propFalse + "%;height:2em;\">\n" +
                "                " + propFalse + "% False\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "          <hr>\n";

    }

    private String getHtmlCodeForOption(int questionNumber, int optionNumber, String optionText, int optionCount) {
        return "                 <ul class=\"list-group\">\n" +
                "                  <li class=\"list-group-item justify-content-between\" id=\"option" + optionNumber + "Question" + questionNumber + "\">\n" +
                "                    <span id=\"option" + optionNumber + "Question" + questionNumber + "Text\">" + optionText + "</span>\n" +
                "                    <span class=\"badge badge-default badge-pill\" id=\"option" + optionNumber + "Question" + questionNumber + "Count\">" + optionCount + "</span>\n" +
                "                  </li>\n"
                ;
    }

    private String getHtmlCodeForMCQ(int questionNumber, Question question) {
        AnswerModel answerModel = new AnswerModel();
        OptionModel optionModel = new OptionModel();
        Vector<Options> options = optionModel.getOptions(question.getID());
        Pair<String, Integer> answer;
        Options option;
        Vector<Pair<String, Integer>> answers = answerModel.getAnswersForQuestionID(question.getID());
        String HtmlCodeStart = "  <div class=\"container\">\n" +
                "            <div class=\"row\">\n" +
                "              <div class=\"col-6 pie-charts\" id=\"Question" + questionNumber + "\" options=\"" + answers.size() + "\">\n" +
                "                <h2>Question " + questionNumber + "</h2>\n" +
                "                <p>" + question.getQuestionText() + "</p>\n" +
                "                <ul class=\"list-group\">\n";
        String HtmlCodeAns = "";
        int optionCount = 0;
        for (int i = 0; i < options.size(); i++) {
            optionCount = 0;
            option = options.elementAt(i);
            for (Pair<String, Integer> tmp : answers) {
                if (option.getOptionText().equalsIgnoreCase(tmp.getFirst())) {
                    optionCount = tmp.getSecond();
                }
            }
            HtmlCodeAns += getHtmlCodeForOption(questionNumber, i + 1, option.getOptionText(), optionCount);
        }
        String HtmlCodeEnd = "                </ul>\n" +
                "              </div>\n" +
                "              <span id=\"Question" + questionNumber + "-chart\" class=\"col-6 float-sm-righ\" >\n" +
                "                  Check Your InterNet Connection\n" +
                "              </span>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "          <hr>";
        return HtmlCodeStart + HtmlCodeAns + HtmlCodeEnd;
    }

    private String getHtmlCodeForCB(int questionNumber, Question question) {
        AnswerModel answerModel = new AnswerModel();
        OptionModel optionModel = new OptionModel();
        Vector<Options> options = optionModel.getOptions(question.getID());
        Pair<String, Integer> answer;
        Options option;
        Vector<Pair<String, Integer>> answers = answerModel.getAnswersForQuestionID(question.getID());
        String HtmlCodeStart = "  <div class=\"container\">\n" +
                "            <div class=\"row\">\n" +
                "              <div class=\"col-6 bar-charts\" id=\"Question" + questionNumber + "\" options=\"" + answers.size() + "\">\n" +
                "                <h2>Question " + questionNumber + "</h2>\n" +
                "                <p>" + question.getQuestionText() + "</p>\n" +
                "                <ul class=\"list-group\">\n";
        String HtmlCodeAns = "";
        int optionCount = 0;
        for (int i = 0; i < options.size(); i++) {
            optionCount = 0;
            option = options.elementAt(i);
            for (Pair<String, Integer> tmp : answers) {
                if (option.getOptionText().equalsIgnoreCase(tmp.getFirst())) {
                    optionCount = tmp.getSecond();
                }
            }
            HtmlCodeAns += getHtmlCodeForOption(questionNumber, i + 1, option.getOptionText(), optionCount);
        }
        String HtmlCodeEnd = "                </ul>\n" +
                "              </div>\n" +
                "              <span id=\"Question" + questionNumber + "-chart\" class=\"col-6 float-sm-righ\" >\n" +
                "                  Check Your InterNet Connection\n" +
                "              </span>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "          <hr>";
        return HtmlCodeStart + HtmlCodeAns + HtmlCodeEnd;
    }

    private String getHtmlCodeForshortAnswer(String AnswerText) {
        return "                        <tr>\n" +
                "                            <td>" + AnswerText + "</td>\n" +
                "                        </tr>\n";
    }

    private String getHtmlCodeForSA(int questionNumber, Question question) {
        AnswerModel answerModel = new AnswerModel();
        Pair<String, Integer> answer;
        Vector<Pair<String, Integer>> answers = answerModel.getShortAnswersForQuestionID(question.getID());
        String HtmlCodeStart = "<div class=\"container\">\n" +
                "            <h2>Question " + questionNumber + "</h2>\n" +
                "              <p>" + question.getQuestionText() + "</p>\n" +
                "              <div class=\"row\">\n" +
                "              <div class=\"col-10\">\n" +
                "              </div>\n" +
                "              <!-- Button trigger modal -->\n" +
                "              <button type=\"button\" class=\"btn btn-primary col-2 float-sm-right\" data-toggle=\"modal\" data-target=\"#Question" + questionNumber + "Answers\">\n" +
                "                View Answers\n" +
                "              </button>\n" +
                "\n" +
                "            </div>\n" +
                "\n" +
                "            <!-- Modal -->\n" +
                "            <div class=\"modal fade\" id=\"Question" + questionNumber + "Answers\" tabindex=\"-1\" role=\"dialog\" >\n" +
                "              <div class=\"modal-dialog modal-lg\" role=\"document\">\n" +
                "                <div class=\"modal-content\">\n" +
                "                  <div class=\"modal-header\">\n" +
                "                    <h5 class=\"modal-title\" >Question" + questionNumber + "</h5>\n" +
                "                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" >\n" +
                "                      <span >&times;</span>\n" +
                "                    </button>\n" +
                "                  </div>\n" +
                "                  <div class=\"modal-body\">\n" +
                "                    <table class=\"table table-striped\">\n" +
                "                      <thead>\n" +
                "\n" +
                "                        <tr>\n" +
                "                          <th><p>" + question.getQuestionText() + "</p></th>\n" +
                "                        </tr>\n" +
                "                      </thead>\n" +
                "                      <tbody>\n";

        String HtmlCodeAns = "";
        for (int i = 0; i < answers.size(); i++) {
            answer = answers.elementAt(i);
            HtmlCodeAns += getHtmlCodeForshortAnswer(answer.getFirst());
        }
        String HtmlCodeEnd = "                      </tbody>\n" +
                "                    </table>\n" +
                "                  </div>\n" +
                "                  <div class=\"modal-footer\">\n" +
                "                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          <hr>\n";
        return HtmlCodeStart + HtmlCodeAns + HtmlCodeEnd;
    }

}
