$('#showUser').on('show.bs.modal', function (e) {
   // $(this).find('.test').html('ID: ' + e.relatedTarget.id);
    $(this).find('.displayRegion').load('visbruger.jsp?id=' + e.relatedTarget.id);
});

