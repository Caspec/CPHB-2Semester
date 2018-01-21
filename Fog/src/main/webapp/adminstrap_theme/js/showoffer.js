$('#showOffer').on('show.bs.modal', function (e) {
   // $(this).find('.test').html('ID: ' + e.relatedTarget.id);
    $(this).find('.displayOffer').load('vistilbud.jsp?id=' + e.relatedTarget.id);
});

