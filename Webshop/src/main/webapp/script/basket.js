$(document).ready(function value() {
    var topping = 0;
    var bottom = 0;
    var total = 0;

    $(".toppingbutton").click(function (event) {
        topping = 0;
        $(".toppingbutton:checked").each(function () {
            topping += parseInt($(this).val());
            total = topping + bottom;
        });

        if (total == 0) {
            $('#value').val('');
        } else {
            $('#value').val(total);
        }

        $(".bottombutton").click(function (event) {
            bottom = 0;
            $(".bottombutton:checked").each(function () {
                bottom += parseInt($(this).val());
                total = topping + bottom;
            });

            if (total == 0) {
                $('#value').val('');
            } else {
                $('#value').val(total);
            }
        });
        total = topping + bottom;
    });

});
