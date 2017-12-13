/*
 * Made By  (c) ZizoNaser
 *  12/13/17 1:06 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

function answerString(i, j){
    return ' <div class="form-group"  id="Answer' + i + 'Question' + j + '">'
        + '<div class="input-group">'
        + '<input type="text" id="A' + i + 'Q' + j + '" name="Answer' + i + 'Question' + j + '"  class="form-control" placeholder="Enter the option" >'
        + '<div class="btn input-group-addon btn-danger RemoveAnswer" ans="' + i + '">x</div>'
        +'</div>'
        + '</div>'
        ;
}
function questionString(i) {
    return '<div id="Question' + i + '" class="container">'
        +'<div class="form-group">'
        + '<label for="Question' + i + '-text"id="lb1-' + i + '">Enter the Question </label>'
        + '<div class="btn btn-danger btn-sm removeQuestion float-sm-right">X</div>'
        + '<input type="text" class="form-control" name="Question' + i + '-text" id="Question' + i + '-text" placeholder="Enter the Question" required>'
        +'</div>'
        + '<div class="form-group">'
        + '<label for="Question' + i + '-type" id="lb2-' + i + '" >Select Question Type</label>'
        + '<select class="form-control" name="Question' + i + '-type" id="Question' + i + '-type" required>'
        +'<option value="" disabled selected>Select your option</option>'
        + '<option value="MCQ">MCQ</option>'
        +'<option value="ToF">True/False</option>'
        + '<option value="SA">ShortAnswer</option>'
        + '<option value="CB">Check Boxs</option>'
        +'</select>'
        +'</div>'
        + '<div class="Answers" id="Answers' + i + '" hidden>'
        + '<label >Enter the Answer/s</label>'
        + '<button title="Add new Answer" class="btn btn-info btn-sm float-sm-right addnewAnswer" >+</button>'
        + '<button title="Remove the last Answer" class="btn btn-danger btn-sm float-sm-right removeLastAnswer">-</button>'
        + '<div class="form-group"  id="Answer1Question' + i + '">'
        + '<div class="input-group">'
        + '<input type="text" id="A1Q' + i + '" name="Answer1Question' + i + '"  class="form-control" placeholder="Enter the option" value="">'
        + '<div class="btn input-group-addon btn-danger RemoveAnswer disabled" ans="1">x</div>'
        +'</div>'
        +'</div>'
        +'</div>'
        + '<input type="hidden" id="Answers' + i + 'Count" name="Answers' + i + 'Count" value="1">'
        +'<div class="form-check">'
        +'<label class="form-check-label">'
        + '<input type="hidden" id="Question' + i + '-requirement" name="Question' + i + '-requirement" value="no">'
        + '<input type="checkbox" id="cb' + i + '" tmp="Question' + i + '" class="form-check-input checkRequire">'
        + 'Required'
        +'</label>'
        +'</div>'
        +'<hr>'
        + '</div>'

        ;
}

$(document).on("click","select",function(){
    var len = $(this).parent().parent().attr("id").length;
    var questionNumber = $(this).parent().parent().attr("id").substring(8, len);
    console.log($(this).parent().parent().attr("id") + " " + questionNumber);
    if (this.value == 'CB' || this.value == 'MCQ') {
        $('#Answers' + questionNumber).prop('hidden', false);
        $('#Answer1Question' + questionNumber).prop('required', true);
    }else{
        $('#Answers' + questionNumber).prop('hidden', true);
        $('#Answer1Question' + questionNumber).prop('required', false);
    }
    console.log($('#Answer1Question' + questionNumber).prop('required'));

});


$(document).on("click", ".removeLastAnswer", function () {
    var tmp2 = $(this).parent().attr("id");
    var questionNumber = parseInt(tmp2.substring(7, tmp2.length));
    var lastAnswerNumber = parseInt($('#Answers' + questionNumber + 'Count').val());
    if (lastAnswerNumber > 1) {
        $('#Answers' + questionNumber + 'Count').val(lastAnswerNumber - 1);
        $('#Answer' + lastAnswerNumber + 'Question' + questionNumber).remove();
    }
    return false;
});

$(document).on("click",".addnewAnswer",function(){
    var tmp2 = $(this).parent().attr("id");
    var questionNumber = parseInt(tmp2.substring(7, tmp2.length));
    var lastAnswerNumber = parseInt($('#Answers' + questionNumber + 'Count').val());
    $('#Answers' + questionNumber + 'Count').val(lastAnswerNumber + 1);
    var y = answerString(lastAnswerNumber + 1, questionNumber);
    $(this).parent().append(y);

});

$(document).on("click", "#addNewQuestion", function () {
    $(QuestionCount).val(parseInt($(QuestionCount).val()) + 1);
    $(Questions).append(questionString($(QuestionCount).val()));

});
$(document).on("click", "#removeLastQuestion", function () {
    var questions = parseInt($(QuestionCount).val());
    console.log(questions);
    if (parseInt($(QuestionCount).val()) > 1) {
        $('#Question' + questions).remove();
        $(QuestionCount).val(questions - 1);
    }

});
$(document).on("click", ".RemoveAnswer", function () {
    var ansnumber = parseInt($(this).attr("ans"));
    var tmp = ansnumber;
    var tmp2 = $(this).parent().parent().parent().attr("id");
    var questionNumber = parseInt(tmp2.substring(7, tmp2.length));
    var lastAnswerNumber = parseInt($('#Answers' + questionNumber + 'Count').val());
    if (ansnumber == 1) {
        $(this).prev().prop("required", true);

    }else{
        $('#Answers' + questionNumber + 'Count').val(lastAnswerNumber - 1);
        $(this).parent().parent().remove();
        for (var i = ansnumber; i < lastAnswerNumber; i++) {
            $('#Answer' + (i + 1) + 'Question' + questionNumber).attr("id", 'Answer' + (i) + 'Question' + questionNumber);
        }
    }
});
$(document).on("click", ".checkRequire", function () {
    if ($('#' + $(this).attr("tmp") + '-requirement').val() == "no") {
        $('#' + $(this).attr("tmp") + '-requirement').val("yes");
    } else {
        $('#' + $(this).attr("tmp") + '-requirement').val("no")
    }
});
$(document).on("click", ".removeQuestion", function () {
    var numOfQuesions = parseInt($('#QuestionCount').val());
    $('#QuestionCount').val(numOfQuesions - 1);
    var parentID = $(this).parent().parent().attr("id");
    console.log(numOfQuesions + "  " + parentID + " ");
    var questionNumber = parseInt(parentID.substring(8, parentID.length));

    $(this).parent().parent().remove();
    for (var i = questionNumber; i < numOfQuesions; i++) {
        changeQuestionID(i);
    }
});
$(document).on("click", "#submitter", function () {
    return true;
});

function changeQuestionID(i) {
    var lastAnswerNumber = parseInt($("#Answers" + (i + 1) + "Count").val());
    for (var j = 1; j <= lastAnswerNumber; j++) {
        $('#Answer' + (j) + 'Question' + (i + 1)).attr("id", 'Answer' + (j) + 'Question' + (i));
        $('#A' + j + 'Q' + (i + 1)).attr("name", 'Answer' + j + 'Question' + i);
        $('#A' + j + 'Q' + (i + 1)).attr("id", 'A' + j + 'Q' + i);
    }
    $('#Question' + (i + 1)).attr("id", 'Question' + (i));
    $('#lb1-' + (i + 1)).attr("for", 'Question' + i + '-text');
    $('#lb1-' + (i + 1)).attr("id", 'lb1-' + (i));
    $('#Question' + (i + 1) + '-text').attr("name", 'Question' + i + '-text');
    $('#Question' + (i + 1) + '-text').attr("id", 'Question' + i + '-text');
    $('#lb2-' + (i + 1)).attr("for", 'Question' + i + '-type');
    $('#lb2-' + (i + 1)).attr("id", 'lb2-' + (i));
    $('#Question' + (i + 1) + '-type').attr("name", 'Question' + i + '-type');
    $('#Question' + (i + 1) + '-type').attr("id", 'Question' + i + '-type');
    $('#Answers' + (i + 1)).attr("id", 'Answers' + (i));
    $('#Answers' + (i + 1) + 'Count').attr("name", 'Answers' + i + 'Count');
    $('#Answers' + (i + 1) + 'Count').attr("id", 'Answers' + i + 'Count');
    $('#Question' + (i + 1) + '-requirement').attr('name', 'Question' + (i) + '-requirement');
    $('#Question' + (i + 1) + '-requirement').attr('id', 'Question' + (i) + '-requirement');
    $('#cb' + (i + 1)).attr('tmp', 'Question' + (i));
    $('#cb' + (i + 1)).attr('id', 'cb' + (i));
}
