<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<link rel="stylesheet" href="webjars/datatables/1.10.9/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="webjars/datetimepicker/2.3.4/jquery.datetimepicker.css">

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <section>
                <%--http://stackoverflow.com/questions/10327390/how-should-i-get-root-folder-path-in-jsp-page--%>
                <h3><a href="${pageContext.request.contextPath}">Home</a></h3>

                <h3><fmt:message key="meals.title"/></h3>

                <form class="form-horizontal" role="form" id="filterForm">

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="startDate">From Date:</label>

                        <div class="col-sm-3"><input type="date" class="form-control date-picker" id="startDate"
                                                     name="startDate"></div>

                        <label class="control-label col-sm-2" for="startTime">From Time:</label>

                        <div class="col-sm-2"><input type="time" class="form-control" id="startTime" name="startTime">
                        </div>
                        <button class="btn btn-sm btn-success" type="submit">Filter</button>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="endDate">To Date:</label>

                        <div class="col-sm-3"><input type="date" class="form-control date-picker" id="endDate"
                                                     name="endDate"></div>

                        <label class="control-label col-sm-2" for="endTime">To Time:</label>

                        <div class="col-sm-2"><input type="time" class="form-control" id="endTime" name="endTime"></div>
                    </div>

                </form>
                <hr>
                <a class="btn btn-sm btn-info" id="add">Add Meal</a>
                <hr>
                <table class="table table-striped display" id="datatable">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Description</th>
                        <th>Calories</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                    <%--<c:forEach items="${mealList}" var="meal">
                        <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.to.UserMealWithExceed"/>
                        <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                            <td>
                                    <fmt:parseDate value="${meal.dateTime}" pattern="y-M-dd'T'H:m" var="parsedDate"/>
                                    <fmt:formatDate value="${parsedDate}" pattern="dd-MMMM-yyyy HH:mm" />

                                &lt;%&ndash;<%=TimeUtil.toString(meal.getDateTime())%>&ndash;%&gt;
                            </td>
                            <td>${meal.description}</td>
                            <td>${meal.calories}</td>
                            <td><a class="btn btn-xs btn-primary edit" href="meals/update?id=${meal.id}">Update</a></td>
                            <td><a class="btn btn-xs btn-danger delete" href="meals/delete?id=${meal.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>--%>
                </table>
            </section>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>

<%--modal edit view--%>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title"><fmt:message key="meals.edit"/></h2>
            </div>
            <div class="modal-body">
                <%--<jsp:useBean id="meal" type="ru.javawebinar.topjava.model.UserMeal" scope="request"/>--%>
                <form class="form-horizontal" id="detailsForm">
                    <input type="hidden" id="id" name="id" value="${meal.id}">

                    <div class="form-group">
                        <label class="control-label col-xs-3">DateTime:</label>

                        <div class="col-xs-9"><input type="datetime-local" value="${meal.dateTime}" id="dateTime"
                                                     name="dateTime"></div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3">Description:</label>

                        <div class="col-xs-9"><input type="text" value="${meal.description}" size=40 id="description"
                                                     name="description"></div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3">Calories:</label>

                        <div class="col-xs-9"><input type="number" value="${meal.calories}" id="calories"
                                                     name="calories"></div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Save</button>
                        <button class="btn btn-default" data-dismiss="modal">Cancel</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/datetimepicker/2.3.4/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="webjars/datatables/1.10.9/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="webjars/noty/2.2.4/jquery.noty.packaged.min.js"></script>
<script type="text/javascript" src="resources/js/datatablesUtil.js"></script>
<script type="text/javascript">

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
    $('#dateTime').datetimepicker({
        format: 'Y-m-d H:i',
        lang: 'ru',
        closeOnDateSelect: true
    });

    $('#filterForm').submit(function () {
        ajaxUrlDB = ajaxUrl + 'filter'
        updateTable();
        return false;
    });

    var ajaxUrl = 'ajax/meals/';

    $(document).ready(function () {
        ajaxUrlDB = ajaxUrl;
    });
    $(function () {
        oTable_datatable = $('#datatable').DataTable(
                {
                    "ajax": {
                        url: ajaxUrlDB,
                        dataSrc: ''
                    },
                    "paging": false,
                    "info": false,
                    "columns": [
                        {
                            "data": "dateTime"
                        },
                        {
                            "data": "description"
                        },
                        {
                            "data": "calories"
                        },
                        {
                            "defaultContent": "",
                            "orderable": false
                        },
                        {
                            "defaultContent": "",
                            "orderable": false
                        }
                    ],
                    "order": [
                        [
                            0,
                            "desc"
                        ]
                    ],
                    "rowCallback": function (nRow, aData, iDisplayIndex) {
                        nRow.setAttribute("id", aData["id"]);
                        if (aData["exceed"]) {
                            $(nRow).addClass("exceeded");
                        } else {
                            $(nRow).addClass("normal");
                        }
                        var id = aData["id"];
                        $("td:eq(3)", nRow).html("<a class=\"btn btn-xs btn-primary edit\">Update</a>");
                        $("td:eq(4)", nRow).html("<a class=\"btn btn-xs btn-danger delete\">Delete</a>");
                        return nRow;
                    }
                });

        makeEditable();
    });
</script>
</html>
