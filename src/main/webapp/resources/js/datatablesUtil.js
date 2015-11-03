var ajaxUrlDB;

function makeEditable() {

    $('#add').click(function () {
        $('#editRow input').val('');
        $('#editRow #id').val(0);
        $('#editRow').modal();
    });

    $('#datatable').on("click", ".delete", function () {
        deleteRow($(this).parent().parent().attr("id"));
    });

    $('#datatable').on("click", ".edit", function () {
        editRow($(this).parent().parent().attr("id"));
    });

    $('#detailsForm').submit(function () {
        var id = $("#editRow").find("input#id").val();
        if (id == 0) {
            save();
        } else {
            update(id);
        }
        return false;
    });

    $('#datatable').on("click", ".btn-toggle", function () {
        $(this).find('.btn').toggleClass('active');
        if ($(this).find('.btn-primary').size() > 0) {
            $(this).find('.btn').toggleClass('btn-primary');
        }
        $(this).find('.btn').toggleClass('btn-default');
        updateUserActive($(this).parent().parent().attr("id"));
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(event, jqXHR, options, jsExc);
    });
}

function updateUserActive(id) {
    $.get(ajaxUrl + "active/" + id, function () {
        updateTable();
        successNoty('Changed');
    });
}

function editRow(id) {
    var editModal = $('#editRow');
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, item) {
            editModal.find("#" + key).val(item)
        })
    });
    editModal.modal();
}


function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: 'DELETE',
        success: function () {
            updateTable();
            successNoty('Deleted');
        }
    });
}

function updateTable() {

    $.ajax({
        type: "GET",
        url: ajaxUrlDB,
        contentType: "application/json",
        data: $('#filterForm').serialize(),
        success: function (data) {
            oTable_datatable.fnClearTable();
            $.each(data, function (key, item) {
               oTable_datatable.fnAddData(item);
            });
            oTable_datatable.fnDraw();
        }
    });


    //$.get(ajaxUrl, function (data) {
    //    oTable_datatable.fnClearTable();
    //    $.each(data, function (key, item) {
    //        oTable_datatable.fnAddData(item);
    //    });
    //    oTable_datatable.fnDraw();
    //});
}

function update(id) {
    var serialized = $('#detailsForm').serializeArray();
    var s = '';
    var data = {};
    for (s in serialized) {
        data[serialized[s]['name']] = serialized[s]['value']
    }
    var o = JSON.stringify(data);

    debugger;
    $.ajax({
        type: "PUT",
        url: ajaxUrl + id,
        contentType: "application/json",
        data: o,
        success: function () {
            $('#editRow').modal('hide');
            updateTable();
            successNoty('Updated');
        }
    });
}

function save() {
    var serialized = $('#detailsForm').serializeArray();
    var s = '';
    var data = {};
    for (s in serialized) {
        data[serialized[s]['name']] = serialized[s]['value']
    }
    var o = JSON.stringify(data);

    debugger;
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        contentType: "application/json",
        data: o,
        success: function () {
            $('#editRow').modal('hide');
            updateTable();
            successNoty('Saved');
        }
    });
}

var failedNote;

function closeNote() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(text) {
    closeNote();
    noty({
        text: text,
        type: 'success',
        layout: 'bottomRight',
        timeout: true
    });
}

function failNoty(event, jqXHR, options, jsExc) {
    closeNote();
    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + "<br>",
        type: 'error',
        layout: 'bottomRight'
    });
}
