/*
 * Made By  (c) ZizoNaser
 *  12/19/17 1:28 AM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */
var errors = [];
$(document).ready(function () {
    $('#nameFaild').hide();
    $('#nameSuccess').hide();
    $('#nameHelper').hide();
    $('#userNameFailed').hide();
    $('#userNameSuccess').hide();
    $('#userNameHelper').hide();
    $('#userNameError').hide();
    $('#emailFaild').hide();
    $('#emailSuccess').hide();
    $('#emailHelper').hide();
    $('#emailError').hide();
    $('#passwordFaild').hide();
    $('#passwordSuccess').hide();
    $('#password2Faild').hide();
    $('#password2Success').hide();
    $('#passwordError').hide();
    $('#passwordHelper').hide();
});

function alphanumericAndWS(inputtxt) {
    var letterNumber = /^[\w\-\s]+$/;
    if (inputtxt.match(letterNumber)) {
        return true;
    } else {

        return false;
    }
}

function alphanumeric(inputtxt) {
    var letterNumber = /^[0-9a-zA-Z]+$/;
    if (inputtxt.match(letterNumber)) {
        return true;
    } else {

        return false;
    }
}

function passwordic(inputtxt) {
    var letterNumber = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,15}$/;
    if (inputtxt.match(letterNumber)) {
        console.log("true");
        return true;
    } else {

        return false;
    }
}

function isName(V) {

    if (V.length >= 3 && alphanumericAndWS(V)) {
        $('#nameSuccess').show();
        $('#nameFaild').hide();
        $('#nameHelper').hide();
        return true;

    } else {
        $('#nameSuccess').hide();
        $('#nameFaild').show();
        $('#nameHelper').show();
        return false;
    }
}

var LastValidN;

function isUserName(V) {
    console.log(V);
    if (V.length >= 5 && alphanumeric(V)) {
        $('#userNameHelper').hide();
        $('#userNameFailed').hide();
        if (V == LastValidN) return true;
        $.ajax({
            url: '/CheckUserName',
            data: {
                userName: V
            },
            success: function (responseText) {
                if (responseText == "Valid") {
                    LastValidN = V;
                    $('#userNameSuccess').show();
                    $('#userNameHelper').hide();
                    $('#userNameFailed').hide();
                    $('#userNameError').hide();
                    return true;
                } else {
                    $('#userNameFailed').show();
                    $('#userNameError').show();
                    $('#userNameSuccess').hide();
                    return false;
                }
            }
        });

    } else {
        $('#userNameHelper').show();
        $('#userNameFailed').show();
        $('#userNameSuccess').hide();
        return false;
    }

}

var LastValidE;

function isEmail(V) {

    console.log(V);
    if (V.length >= 8) {
        $('#emailHelper').hide();
        $('#emailError').hide();
        if (V == LastValidE) return true;
        $.ajax({
            url: '/CheckEmail',
            data: {
                email: V
            },
            success: function (responseText) {
                if (responseText == "Valid") {
                    LastValidE = V;
                    $('#emailFaild').hide();
                    $('#emailSuccess').show();
                    $('#emailHelper').hide();
                    $('#emailError').hide();
                    return true;
                } else {
                    $('#emailFaild').show();
                    $('#emailSuccess').hide();
                    $('#emailHelper').hide();
                    $('#emailError').show();
                    return false;
                }
            }
        });

    } else {
        $('#emailFaild').show();
        $('#emailSuccess').hide();
        $('#emailHelper').show();
        $('#emailError').hide();
        return false;
    }

}


$('#name').blur(function () {
    var x = isName($(this).val());
});
$('#userName').blur(function () {
    var x = isUserName($(this).val());
});
$('#email').blur(function () {
    var x = isEmail($(this).val());
});
$('#password').blur(function () {
    if (passwordic($(this).val())) {
        $('#passwordFaild').hide();
        $('#passwordSuccess').show();
        $('#passwordError').hide();
        $('#passwordHelper').hide();
    } else {
        $('#passwordFaild').show();
        $('#passwordSuccess').hide();
        $('#passwordError').hide();
        $('#passwordHelper').show();
    }
});
$('#password2').blur(function () {
    if ($(this).val() == $('#password').val()) {
        $('#password2Faild').hide();
        $('#password2Success').show();
        $('#passwordError').hide();

    } else {
        $('#password2Faild').show();
        $('#password2Success').hide();
        $('#passwordError').show();

    }
});

$(document).on("click", "#bat", function () {
    if ($('#password').val() == $('#password2').val() && passwordic($('#password').val()) && isEmail($('#email').val()) && isUserName($('#userName').val()) && isName($("#name").val())) {

        $('form').submit();
    } else {
        return false;
    }
});