function refresh() {
    console.log("refresh");
    $.ajax({
        url: '/GetMessagesCtl',
        data: {},
        success: function (responseText) {
            $('#Msgs').html(responseText);
        }
    });

}

$(document).on("click", ".read", function () {
    var msgid = $(this).parent().parent().attr('id');
    $.ajax({
        url: '/MarkMessageAsReadCtl',
        data: {
            msgID: msgid
        },
        success: function (responseText) {
            refresh();
        }
    });
    $(this).parent().parent().removeClass("bg-warning");
    $(this).remove();
});
$(document).on("click", ".remove", function () {
    var msgid = $(this).parent().parent().attr('id');
    $.ajax({
        url: '/RemoveMsgCtl',
        data: {
            msgID: msgid
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
/*
 * Made By  (c) ZizoNaser
 *  12/18/17 4:21 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

