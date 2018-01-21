$('#showOrder').on('show.bs.modal', function (e) {
   // $(this).find('.test').html('ID: ' + e.relatedTarget.id);
    $(this).find('.displayOrder').load('visordre.jsp?id=' + e.relatedTarget.id);
});