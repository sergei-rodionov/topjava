var ajaxUrl = 'ajax/profile/meals/';
var datatableApi;

function updateTable() {
    $.ajax({
        type: "POST",
        url: ajaxUrl + 'filter',
        data: $('#filter').serialize(),
        success: function (data) {
            updateTableByData(data);
        }
    });
    return false;
}

$(function () {
    datatableApi = $('#datatable').DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "bPaginate": false,
        "bInfo": false,
        "aoColumns": [
            {
                "mData": "dateTime"
            },
            {
                "mData": "description",
                "render": function (data, type, full, meta) {
                    return type === 'display' && data.length > 40 ?
                    '<span title="' + data + '">' + data.substr(0, 38) + '...</span>' :
                        data;
                }
            },
            {
                "mData": "calories"
            },
            {
                "sDefaultContent": "Edit",
                "bSortable": false,
                "mRender": renderEditBtn
            },
            {
                "sDefaultContent": "Delete",
                "bSortable": false,
                "mRender": renderDeleteBtn
            }
        ],
        "aaSorting": [
            [
                0,
                "desc"
            ]
        ],
        "createdRow": function (row, data, dataIndex) {
            if (data.exceed) {
                $(row).addClass("exceeded");
            } else {
                $(row).addClass("normal")
            }

        },
        "initComplete": makeEditable
    });

    $('#filter').submit(function () {
        updateTable();
        return false;
    });
    // makeEditable();
    init();
});

function init() {
}

$('#dateTime').datetimepicker({
    format: 'Y-m-d H:i',
    lang: 'ru',
    closeOnDateSelect: true
});

$('#startDate').datetimepicker({
    timepicker: false,
    format: 'Y-m-d',
    lang: 'ru',
    closeOnDateSelect: true
});
$('#endDate').datetimepicker({
    timepicker: false,
    format: 'Y-m-d',
    lang: 'ru',
    closeOnDateSelect: true
});
$('#startTime').datetimepicker({
    datepicker: false,
    format: 'H:i'
});
$('#endTime').datetimepicker({
    datepicker: false,
    format: 'H:i'
});
