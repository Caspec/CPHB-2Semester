$("#CRHovedeStaden").click(function() {
    if($(this).is(":checked")) {
        $("#crh").show();
    } else {
        $("#crh").hide();
    }
});

$("#CRSjælland").click(function() {
    if($(this).is(":checked")) {
        $("#crs").show();
    } else {
        $("#crs").hide();
    }
});

$("#CRNordJylland").click(function() {
    if($(this).is(":checked")) {
        $("#crn").show();
    } else {
        $("#crn").hide();
    }
});

$("#CRMidtJylland").click(function() {
    if($(this).is(":checked")) {
        $("#crm").show();
    } else {
        $("#crm").hide();
    }
});

$("#CRSydDanmark").click(function() {
    if($(this).is(":checked")) {
        $("#crsy").show();
    } else {
        $("#crsy").hide();
    }
});