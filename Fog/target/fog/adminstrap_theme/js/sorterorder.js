$("#CIkkegodkendt").click(function() {
    if($(this).is(":checked")) {
        $("#cik").show();
    } else {
        $("#cik").hide();
    }
});

$("#CGodkendt").click(function() {
    if($(this).is(":checked")) {
        $("#cgo").show();
    } else {
        $("#cgo").hide();
    }
});

$("#CPakket").click(function() {
    if($(this).is(":checked")) {
        $("#cpo").show();
    } else {
        $("#cpo").hide();
    }
});

$("#CAfsendt").click(function() {
    if($(this).is(":checked")) {
        $("#cao").show();
    } else {
        $("#cao").hide();
    }
});