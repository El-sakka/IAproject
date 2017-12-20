/*
 * Made By  (c) ZizoNaser
 *  12/19/17 4:38 AM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */
$(document).on("click", ".option", function () {
    if (parseInt($(this).val()) == 0) {
        $(this).val(1);
    } else {
        $(this).val(0)
    }
});


