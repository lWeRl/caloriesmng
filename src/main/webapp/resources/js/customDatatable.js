/**
 * Created by lWeRl on 13.03.2017.
 */
function makeEditable(ajaxUrl) {
    $('#add').click(function () {
        $('#id').val(0);
        $('#editRow').modal();
    });

    $('.delete').click(function () {
        deleteRow($(this).attr("id"));
    });

    $('#detailsForm').submit(function(){
        save();
        return false;
    });
}
function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: 'DELETE',
        success: function () {
            updateTable();
            // success('Deleted')
        }
    });
}
function updateTable() {
    $.get(ajaxUrl, function (data) {
        oTable_datatable.fnClearTable();
        $.each(data, function (key, item) {
            oTable_datatable.fnAddData(item);
        });
        oTable_datatable.fnDraw();
    });
}
function save() {
    var frm = $('#detailsForm');
    $.ajax({
        type:"POST",
        url: ajaxUrl + $('#id').val(),
        data:frm.serialize(),
        success: function (data) {
            $('#editRow').modal('hide');
            updateTable();
            // success('Saved');
        }
    });
}