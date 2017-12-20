<%@ page import="com.obj.User" %><%--
  ~ Made By  (c) ZizoNaser
  ~  12/18/17 4:19 PM  
  ~  Twitter: @ZizoNaser
  ~  GitHub: github.com/ZizoNaser 
  --%>

<%--
  Created by IntelliJ IDEA.
  User: zizo
  Date: 12/18/17
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User LoggedInUser = (User) session.getAttribute("LoggedInUser");

    if (session.isNew() || LoggedInUser == null) {
        response.sendRedirect("/index.jsp");

    } else {

%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Form</title>
    <link rel="shortcut icon" type="image/x-icon" href="img/icon2.png"/>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- css -->
    <link rel="stylesheet" href="css/Defalut.css">
</head>
<body>
<!--Header -->
<nav class="navbar navbar-toggleable-md navbar-light bg-faded fixed-top opicitBack ">
    <div class="container">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="#">Form <img src="img/icon2.png"/> </a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto" id="navItems">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">about</a>
                </li>
            </ul>
            <a href="#" class="btn btn-danger"> LogOut</a>
        </div>
    </div>
</nav>
<!--Body  -->
<div class="container">
    <div class="jumbotron ">
        <div class="container ">
            <input type="hidden" id="userName" name="userName" value="<%=LoggedInUser.getUserName()%>">
            <table class="table table-striped">
                <thead>
                <tr>

                    <th>user</th>
                    <th></th>
                    <th class="col-1">Message</th>

                    <th>options</th>
                </tr>
                </thead>
                <tbody id="Msgs">

                </tbody>
            </table>

        </div>
    </div>

</div>


<!-- Footer -->
<nav class="navbar bg-faded fixed-bottom opicitBack ">
    <div class="container-fluid align-content-center">
        Made By <a class="align-self-center text-white" target="_tab" href="http://zizo.esy.es/">ZizoNaser</a> &copy;2017
    </div>
</nav>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/tether.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/ShowMessages.js">
</script>
</body>
</html>

<%
    }
%>