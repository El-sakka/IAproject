function refresh() {
    console.log("refresh");
    $.ajax({
        url: '/GetReportsCtl',
        data: {
            // @TODO
        },
        success: function (responseText) {
            $('#reports').html(responseText);
        }
    });

}

$(document).on("click", ".read", function () {
    var reportID = $(this).parent().parent().attr('id');
    $.ajax({
        url: '/MarkReportAsReadCtl',
        data: {
            reptId: reportID
        },
        success: function (responseText) {
            refresh();
        }
    });
    $(this).parent().parent().removeClass("bg-info");
    $(this).remove();
});
$(document).on("click", ".remove", function () {
    var reportID = $(this).parent().parent().attr('id');
    $.ajax({
        url: '/RemoveRptCtl',
        data: {
            reptId: reportID
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

