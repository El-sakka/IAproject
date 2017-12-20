<%@ page import="com.obj.User" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.obj.Form" %>
<%@ page import="com.model.FormModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Form</title>
    <link rel="shortcut icon" type="image/x-icon" href="/img/icon2.png" />
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- css -->
    <link rel="stylesheet" href="css/HomePage.css">
</head>

  <%
    User LoggedInUser =(User) session.getAttribute("LoggedInUser");
    if(session.isNew() ||LoggedInUser ==null ){
  %>

<body style="padding:0em">
<nav class="navbar navbar-toggleable-md navbar-light bg-faded fixed-top ">
    <div class="container">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="index.jsp">Form <img src="img/icon2.png" /> </a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto" id="navItems">
                <li class="nav-item active">
                    <a class="nav-link" href="/index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">about</a>
                </li>
            </ul>
            <button class="btn btn-info btn-large " data-toggle="modal" data-target="#LoginModal">
                Login
            </button>
        </div>
    </div>
</nav>
<div class="row  align-items-center justify-content-center" style="height:95%; margin:0" >
    <div id="carouselExampleIndicators" class="carousel slide h-100 w-100" data-ride="carousel" >
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner h-100 "   role="listbox" >
            <div class="carousel-item active back-0 h-100 align-items-center justify-content-center">
                <div class="jumbotron w-50 h-50">
                    <div class="display-2 h-25">
                        Do1#!
                    </div>
                    <hr>
                    <p class="h-50">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    <hr>
                    <a href="/SignUp.jsp" class="btn btn-danger float-right">SignUp</a>
                </div>

            </div>
            <div class="carousel-item back-1 h-100 align-items-center justify-content-center ">
                <div class="jumbotron w-50 h-50">
                    <div class="display-2 h-25">
                        Do2#!
                    </div>
                    <hr>
                    <p class="h-50">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    <hr>
                    <a href="/SignUp.jsp" class="btn btn-danger float-right">SignUp</a>
                </div>
            </div>
            <div class="carousel-item back-2 h-100 align-items-center justify-content-center" >
                <div class="jumbotron w-50 h-50">
                    <div class="display-2 h-25">
                        Do3#!
                    </div>
                    <hr>
                    <p class="h-50">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    <hr>
                    <a href="/SignUp.jsp" class="btn btn-danger float-right">SignUp</a>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

</div>
</div>
<nav class="navbar bg-faded footer">
    <div class="container-fluid align-content-center">
        Made By  <a class="align-self-center" target="_tab" href="#">3L Corpe.</a> &copy;2017
    </div>

</nav>
<div id="LoginModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header align-items-center justify-content-center "><div class="display-4">
                Welcome
            </div></div>
            <div class="modal-body">
                <form action="/LogInCtl" method="post">

                    <div class="form-group">
                        <label for="userName">UserName:</label>
                        <input type="text" class="form-control" id="userName" name="userName"  placeholder="Enter  your userName">
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" id="password" name="password"  placeholder="Enter your Password">
                    </div>
                    <br>
                    <a href="/SignUp.jsp" class="btn btn-danger">SignUp</a>
                    <button type="submit" class="btn btn-primary btn-lg float-right">Login</button>
                </form>
            </div>
            <div class="modal-footer align-items-center justify-content-center ">3L Corpe</div>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/tether.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>

<%
    }else if(LoggedInUser.getType().equalsIgnoreCase("sus")){

%>
<body>
<nav class="navbar navbar-toggleable-md navbar-light bg-faded fixed-top top-bar" style="background-color:rgba(100,100 ,100 , 0.9);">
    <div class="container">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="index.jsp">Form <img src="img/icon2.png" /> </a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">about</a>
                </li>
            </ul>

            <a href="/LogOutCtl" > <button class="btn btn-danger ">
                LogOut
            </button></a>
        </div>
    </div>
</nav>

<div class="container"  >
    <div class="jumbotron">
        <div class="display-2">
            Sorry Your Suspended
        </div>
        <hr>
        <div class="display-4">
            You can send Complain tp
            Support@Form.com
        </div>

    </div>

</div>

<nav class="navbar bg-faded footer " style="background-color:rgba(100,100 ,100 , 0.9);" >
    <div class=" align-content-center">
        Made By  <a class="align-self-center text-white" target="_tab" href="#">3L Corpe.</a> &copy;2017
    </div>

</nav>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/tether.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
<%
    }else if(LoggedInUser.getType().equalsIgnoreCase("norm")||LoggedInUser.getType().equalsIgnoreCase("admin")){
%>
<body>
<nav class="navbar navbar-toggleable-md navbar-light bg-faded fixed-top top-bar" style="background-color:rgba(100,100 ,100 , 0.9);">
    <div class="container">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="/index.jsp">Form <img src="img/icon2.png" /> </a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/add-form.jsp">Add Form</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ViewForms.jsp">View Forms</a>
                </li>
<%
    if(LoggedInUser.getType().equalsIgnoreCase("admin")){
        out.print("  <li class=\"nav-item\">\n" +
                "                <a class=\"nav-link\" href=\"#\">View Users</a>\n" +
                "              </li>\n" +
                "              <li class=\"nav-item\">\n" +
                "                  <a class=\"nav-link\" href=\"#\">send Messages</a>\n" +
                "              </li>\n" +
                "\n" +
                "              <li class=\"nav-item\">\n" +
                "                <a class=\"nav-link text-success \" href=\"ShowReports.jsp\">Reports <span id='reportsNum' class=\"badge badge-success\">2</span>  </a>\n" +
                "              </li>");
    }
%>

                <li class="nav-item">
                    <a class="nav-link" href="#">about</a>
                </li>
            </ul>
            <a href="/LogOutCtl" > <button class="btn btn-danger ">
                LogOut
            </button></a>
        </div>
    </div>
</nav>

<div class="fill h-100 align-items-center justify-content-center" style="width:95%;" >
    <div class="row h-50 ">

        <div class="col-4">

        </div>
        <div class="col-4 align-items-center justify-content-center m-2">

            <div class="card" style="width: 100%; background-color:rgba(10,0 ,0 , 0.7);">
                <img class="card-img-top " src="img/unKnown.jpg" style="height:15em" alt="Card image cap">
                <div class="card-block">
                    <h4 class="card-title text-white"><%=LoggedInUser.getName() %>  </h4>
                    <p class="card-text text-info"><%=LoggedInUser.getEmail()%></p>
                </div>
                <div class="card-block ">
                    <%--@TODO Modal Change Password--%>
                    <%--@TODO AJAX GetNumber of messages--%>
                        <button class="btn btn-info btn-large " data-toggle="modal" data-target="#ChangePassword">Change password</button>


                    <a class="card-link text-danger " href="/ShowMessages.jsp">Show Messages <span id="msgNum" class="badge badge-danger"> 2</span>  </a>
                </div>
            </div>
        </div>
        <div class="col-4">
        </div>
    </div>


    <div class="h-25 row w-100 align-items-center justify-content-center">
        <section id="ShowForms">
            <div class="container">
                <div class="row">
                    <div class="col-1 ">  </div>
                    <div class="col-10">
                        <span class="badge badge-default"> Recent Forms</span>
                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                            <div class="carousel-inner align-items-center justify-content-center" role="listbox">
                <%
                    Vector<Form> forms =new FormModel().getAllForms();
                    for (int i = 0; i <forms.size()-4 ; i+=4) {
                        out.print("" +
                                "<div class=\"carousel-item card-deck "+ ((i==0)? " active":" ") +" \">\n" +
                                "                        <div class=\"card border-success mb-3 opicitBack\" style=\"max-width:20rem;max-height:20rem\">\n" +
                                "                          <div class=\"card-header opicitBack\">\n" +
                                "                            "+forms.elementAt(i).getUserName()+"\n" +
                                "                          </div>\n" +
                                "                          <div class=\"card-body text-info\">\n" +
                                "                            <h4 class=\"card-title\">"+forms.elementAt(i).getName()+"</h4>\n" +
                                 
                                "                          </div>\n" +
                                "                           <a href='ShowFormCtl?formId="+forms.elementAt(i).getID()+"'>  <div class=\"card-footer btn btn-primary text-info opicitBack\" >\n" +
                                "                              Fill the Form\n" +
                                "                          </div></a>\n" +
                                "                        </div>\n" +
                                "                        <div class=\"card border-danger opicitBack mb-3\" style=\"max-width: 20rem;\">\n" +
                                "                          <div class=\"card-header opicitBack\">\n" +
                                "                            "+forms.elementAt(i+1).getUserName()+"\n" +
                                "                          </div>\n" +
                                "                          <div class=\"card-body text-danger\">\n" +
                                "                            <h4 class=\"card-title\">"+forms.elementAt(i+1).getName()+"</h4>\n" +

                                "                          </div>\n" +
                                "                           <a href='ShowFormCtl?formId="+forms.elementAt(i+1).getID()+"'>  <div class=\"card-footer btn btn-primary text-info opicitBack\" >\n" +
                                "                              Fill the Form\n" +
                                "                          </div>\n" +
                                "                        </div>\n" +
                                "                        <div class=\"card opicitBack border-warning mb-3\" style=\"max-width: 20rem;\">\n" +
                                "                          <div class=\"card-header opicitBack\">\n" +
                                "                            "+forms.elementAt(i+2).getUserName()+"\n" +
                                "                          </div>\n" +
                                "                          <div class=\"card-body text-warning\">\n" +
                                "                            <h4 class=\"card-title\">"+forms.elementAt(i+2).getName()+"</h4>\n" +

                                "                          </div>\n" +
                                "                             <a href='ShowFormCtl?formId="+forms.elementAt(i+2).getID()+"'>  <div class=\"card-footer btn btn-primary text-info opicitBack\" >\n" +
                                "                              Fill the Form\n" +
                                "                          </div>\n" +
                                "                        </div>\n" +
                                "                        <div class=\"card border-success opicitBack mb-3\" style=\"max-width: 20rem;\">\n" +
                                "                          <div class=\"card-header opicitBack\">\n" +
                                "                            "+forms.elementAt(i+3).getUserName()+"\n" +
                                "                          </div>\n" +
                                "                          <div class=\"card-body text-success\">\n" +
                                "                            <h4 class=\"card-title\">"+forms.elementAt(i+3).getName()+"</h4>\n" +

                                "                          </div>\n" +
                                "                             <div class=\"card-footer btn btn-primary text-info opicitBack\" >\n" +
                                "                              Fill the Form\n" +
                                "                          </div>\n" +
                                "                        </div>\n" +
                                "                      </div>");

                    }
                %>

                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-next " href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon " aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>

                    <a class="carousel-control-prev " href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                </div>
            </div>
        </section>
    </div>
</div>
    <nav class="navbar bg-faded footer " style="background-color:rgba(100,100 ,100 , 0.9);" >
        <div class=" align-content-center">
            Made By  <a class="align-self-center text-white" target="_tab" href="#">3L Corpe.</a> &copy;2017
        </div>

    </nav>
<div id="ChangePassword" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header align-items-center justify-content-center "><div class="display-4">
                Welcome
            </div></div>
            <div class="modal-body">
                <form id="myForm" action="/ChangePasswordCtl" method="get">

                    <div class="form-group">
                        <label for="Oldpassword">Enter your old password:</label>
                        <input type="password" class="form-control" id="Oldpassword" name="Oldpassword"  placeholder="Enter  your Old Password" required>
                    </div>
                    <div class="form-group">
                        <label for="Newpassword">new Password:</label>
                        <input type="password" class="form-control" id="Newpassword" name="Newpassword"  placeholder="Enter your Password"required>
                    </div>
                    <div class="form-group">
                        <label for="Newpassword2">new Password:</label>
                        <input type="password" class="form-control" id="Newpassword2" name="Newpassword2"  placeholder="Enter your Password"required>
                        <small id="Error">the Two password don't Match</small>
                    </div>

                    <br>
                    <input type="submit" id="bat" class="btn btn-primary btn-lg float-right" value="Change"/>
                </form>
            </div>
            <div class="modal-footer align-items-center justify-content-center ">3L Corpe</div>
        </div>
    </div>
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/tether.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
<script>
    function passwordic(inputtxt) {
        var letterNumber = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,15}$/;
        if(inputtxt.match(letterNumber)){
            console.log("true")
            return true;
        }else{

            return false;
        }

        $('#Newpassword').blur(function () {
            if(passwordic($(this).val())){
                $(this).addClass("bg-success");
                $(this).removeClass("bg-danger");
            }else{
                $(this).removeClass("bg-success");
             $(this).addClass("bg-danger");
            }
        });
        $('#Newpassword2').blur(function () {
            if($(this).val() == $('#Newpassword').val()){
                $('#Error').hide();
            }else{
                $('#Error').show();
            }
        });
        $(document).on("click","#bat",function () {
            if ($('#Newpassword').val() == $('#Newpassword2').val() && passwordic($('#Newpassword').val())) {

                $('#myForm').submit();
            } else {
                return false;
            }
        });

    }

</script>

 </body>
</html>

<%
    }
%>