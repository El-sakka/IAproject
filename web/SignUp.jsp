<%--
  ~ Made By  (c) ZizoNaser
  ~  12/19/17 1:27 AM  
  ~  Twitter: @ZizoNaser
  ~  GitHub: github.com/ZizoNaser 
  --%>

<%--
  Created by IntelliJ IDEA.
  User: zizo
  Date: 12/19/17
  Time: 1:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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

        </div>
    </div>
</nav>
<!--Body  -->
<div class="container">
    <div class="jumbotron">
        <form action="/SignUpCtl" method="post">
            <div class=" row ">
                <div class=" container-fluid align-content-center">
                    <div class="display-3">
                        Welcome
                    </div>
                </div>
            </div>
            <hr>
            <div class="form-group">
                <label for="name">Please Enter Your Name</label>
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <input type="name" class="form-control" name="name" id="name" placeholder="name e.g Ahmed "
                           required>
                    <div id="nameFaild" class="input-group-addon bg-danger">&#9888;</div>
                    <div id="nameSuccess" class="input-group-addon bg-success"> &#10004;</div>
                </div>
                <small id="nameHelper" class="text-muted">
                    Must be > 2 characters long.
                </small>
            </div>
            <br>
            <div class="form-group">
                <label for="userName">Enter UserName</label>
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <input type="text" class="form-control" name="userName" id="userName"
                           placeholder="Username e.g. Ahmed11 " required>
                    <div id="userNameFailed" class="input-group-addon bg-danger">&#9888;</div>
                    <div id="userNameSuccess" class="input-group-addon bg-success"> &#10004;</div>
                </div>
                <small id="userNameHelper" class="text-muted">
                    Must be > 4 characters and numbers long with no spaces.
                </small>
                <div id="userNameError" class="alert alert-danger alert-dismissible fade show" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        &times;
                    </button>
                    <strong>Wrong UserName!</strong> This userName is Used try another one please!
                </div>
            </div>
            <br>
            <div class="form-group">
                <label for="email">Enter E-mail</label>
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <input type="email" class="form-control" name="email" id="email"
                           placeholder="Email e.g Ahmed@example.com" required>
                    <div id="emailFaild" class="input-group-addon bg-danger">&#9888;</div>
                    <div id="emailSuccess" class="input-group-addon bg-success"> &#10004;</div>
                </div>
                <small id="emailHelper" class="text-muted">
                    Must be > 7 characters and numbers long with no spaces.
                </small>
                <div id="emailError" class="alert alert-danger alert-dismissible fade show" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        &times;
                    </button>
                    <strong>Wrong Email!</strong> This email is Used try another one please!
                </div>
            </div>
            <br>
            <div class="form-group">
                <label for="password">Enter your Password</label>
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <input type="password" class="form-control" name="password" id="password"
                           placeholder="Enter Your Password" required>
                    <div id="passwordFaild" class="input-group-addon bg-danger ">&#9888;</div>
                    <div id="passwordSuccess" class="input-group-addon bg-success "> &#10004;</div>
                </div>
                <small id="passwordHelper" class="text-muted">
                    Must be > 7 and < 16 characters, at least one uppercase letter, one lowercase letter, one number and
                    one special character
                </small>
                <br>
                <label for="password2">ReEnter your Password</label>
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <input type="password" class="form-control" name="password2" id="password2"
                           placeholder="ReEnter Your Password" required>
                    <div id="password2Faild" class="input-group-addon bg-danger ">&#9888;</div>
                    <div id="password2Success" class="input-group-addon bg-success "> &#10004;</div>
                </div>
                <div id="passwordError" class="alert alert-danger alert-dismissible fade show" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        &times;
                    </button>
                    <strong>Doesn't Match</strong> the two passwords didn't match
                </div>
            </div>

            <input type="submit" name="bat" class="btn btn-danger float-right" id="bat" value="SignUp"/>
        </form>
    </div>
</div>
<!-- Footer -->
<nav class="navbar bg-faded fixed-bottom opicitBack ">
    <div class="container-fluid align-content-center">
        Made By <a class="align-self-center text-white" target="_tab" href="#">3L Corpe</a> &copy;2017
    </div>
</nav>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/tether.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/SignUp.js"></script>


</body>
</html>
