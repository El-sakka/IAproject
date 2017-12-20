/*
 * Made By  (c) ZizoNaser
 *  12/18/17 9:38 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */
$(document).on("click", ".sus", function () {
    var formId = $(this).parent().parent().attr('id');
    $.ajax({
        url: '/SuspendFormCtl',
        data: {
            formId: formId
        },
        success: function (responseText) {
            refresh();
            $(this).removeClass("sus");
            $(this).removeClass("btn-info");
            $(this).html(">");
            $(this).attr("title", "Resume");
            $(this).addClass("resume");
            $(this).addClass("btn-success");
            $(this).parent().parent().addClass("bg-info");
        }
    });


});
$(document).on("click", ".resume", function () {
    var formId = $(this).parent().parent().attr('id');
    $.ajax({
        url: '/UnSuspendForm',
        data: {
            formId: formId
        },
        success: function (responseText) {
            $(this).removeClass("resume");
            $(this).removeClass("btn-success");
            $(this).parent().parent().removeClass("bg-info");
            $(this).html("||");
            $(this).attr("title", "Suspend");
            $(this).addClass("sus");
            $(this).addClass("btn-info");
            refresh();
        }
    });

});


function refresh() {
    console.log("refresh");
    $.ajax({
        url: '/GetFormsCtl',
        data: {
            // @TODO
        },
        success: function (responseText) {
            $('#forms').html(responseText);
        }
    });

}

$(document).on("click", ".remove", function () {
    var formId = $(this).parent().parent().attr('id');
    $.ajax({
        url: '/RemoveFormCtl',
        data: {
            formId: formId
        },
        success: function (responseText) {
            refresh();
        }
    });
    $(this).parent().parent().remove();
});

$(document).ready(function () {
    refresh();

    var int1 = setInterval("refresh()", 5000);

});

