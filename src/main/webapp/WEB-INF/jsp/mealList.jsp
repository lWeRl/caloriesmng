<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="dandelion" uri="http://github.com/dandelion" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setBundle basename="messages.app"/>

<html>
<dandelion:bundle includes="mainDatatable"/>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3><fmt:message key="meals.title"/></h3>
            <c:set var="ajaxUrl" value="/ajax/profile/meals/"/>
            <div class="view-box">
                <a class="btn btn-sm btn-info" id="add">Add Meals</a>
                <%--<a class="btn btn-sm btn-info" id="between_btn">Get Between</a>--%>
                <%--<a class="btn btn-sm btn-info" id="clear">All</a>--%>
                <%--<a class="btn btn-sm btn-info" id="update">Update</a>--%>
                <datatables:table id="datatable" url="${ajaxUrl}" row="meal" theme="bootstrap3" cssClass="table table-striped" pageable="false" info="false">
                    <datatables:column title="Description" property= "description"/>
                    <datatables:column title="Calories" property="calories"/>
                    <datatables:column title="Date/Time"  sortInitDirection="asc" property="date"/>
                    <datatables:column filterable="false" sortable="false" renderFunction="renderUpdateBtn"/>
                    <datatables:column filterable="false" sortable="false" renderFunction="renderDeleteBtn"/>
                </datatables:table>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Meals details:</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post" id="detailsForm">
                    <input hidden="hidden" id="id">

                    <div class="form-group">
                        <label for="description" class="control-label col-xs-3">Description:</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="description" name="description" placeholder="description">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="calories" class="control-label col-xs-3">Calories:</label>
                        <div class="col-xs-9">
                            <input type="number" class="form-control" id="calories" name="calories" placeholder="calories" min="0">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="date" class="control-label col-xs-3">Date/Time:</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="date" name="date" placeholder="">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-9 col-xs-9">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="between">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Meals details:</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="datesForm">

                    <div class="form-group">
                        <label for="startDate" class="control-label col-xs-3">Start date:</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="startDate" name="starDate" placeholder="start" required="required">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="endDate" class="control-label col-xs-3">End Date:</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="endDate" name="endDate" placeholder="end">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-9 col-xs-9">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<%--<section>--%>
    <%--<table border="1" cellpadding="8" cellspacing="0">--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th>Description</th>--%>
            <%--<th>Date</th>--%>
            <%--<th>Calories</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<c:forEach items="${mealList}" var="meal">--%>
            <%--<jsp:useBean id="meal" scope="page" type="org.lwerl.caloriesmng.model.UserMeal"/>--%>
            <%--<tr>--%>
                <%--<td><c:out value="${meal.description}"/></td>--%>
                <%--<c:set var="fixDateTime" value="${fn:replace({meal.date}, 'T', ' ')}" />--%>
                <%--<fmt:parseDate value="${fixDateTime}" pattern="[yyyy-MM-dd HH:mm]" var="parsedDateTime" type="both" />--%>
                <%--<td><fmt:formatDate pattern="dd MMMM yyyy HH:mm" value="${parsedDateTime}"/></td>--%>
                <%--<td>${meal.calories}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>
<%--</section>--%>
<%--<hr>--%>
<jsp:include page="fragments/footer.jsp"/>
</body>
<script type="text/javascript">

    var form = $('#detailsForm');
    var between = $('#between');
    var ajaxUrl = 'ajax/profile/meals/';

    $('#endDate').datetimepicker({dateFormat:"yy-mm-dd"});
    $('#startDate').datetimepicker({dateFormat:"yy-mm-dd"});

    $(function () {
        $('#date').datetimepicker({dateFormat:"yy-mm-dd"});

    });

    $('#add').click(function () {
        form.find("input").each(function () {
            $(this).val("");
        });
        $('#id').val(0);
        $('#editRow').modal();
    });

    $('#update').click(function () {
        updateTable(ajaxUrl);
    });

    $('#between_btn').click(function () {
        $('#datesForm').find("input").each(function () {
            $(this).val("");
        });
        $('#between').modal();
    });

    $('#clear').click(function () {
        ajaxUrl.val('ajax/profile/meals/');
        updateTable(ajaxUrl);
    });

    form.submit(function () {
        save();
        return false;
    });

    between.submit(function () {
        $.ajax({
            url: ajaxUrl + 'between',
            type: "GET",
            data: form.serialize(),
            success: function (data) {
                $('#between').modal('hide');
                updateTable(ajaxUrl);
                successNoty('Saved');
            }
        });
    });

    
    function updateTable(ajaxUrl) {
        $.get(ajaxUrl, function (data) {
            oTable_datatable.fnClearTable();
            $.each(data, function (key, item) {
                oTable_datatable.fnAddData(item);
            });
            oTable_datatable.fnDraw();
        });
    }

    function renderDeleteBtn(data, type, row) {
        if (type == 'display') {
            return '<a class="btn btn-xs btn-danger" onclick="deleteRow(' + row.id + ')">Delete</a>';
        }
        return data;
    }
    function renderUpdateBtn(data, type, row) {
        if (type == 'display') {
            return '<a class="btn btn-xs btn-primary" onclick="updateRow(' + row.id + ')">Update</a>';
        }
        return data;
    }
    function save() {
        $.ajax({
            url: ajaxUrl + $('#id').val(),
            type: "POST",
            data: form.serialize(),
            success: function (data) {
                $('#editRow').modal('hide');
                updateTable(ajaxUrl);
                successNoty('Saved');
            }
        });
    }

    function deleteRow(id) {
        $.ajax({
            url: ajaxUrl + id,
            type: 'DELETE',
            success: function () {
                updateTable(ajaxUrl);
                successNoty('Deleted');
            }
        });
    }

    function updateRow(id) {
        $.get(ajaxUrl + id, function (data) {
            $.each(data, function (key, value) {
                form.find("input[name='" + key + "']").val(value);
            });
            $('#id').val(id);
            $('#editRow').modal();
        });
    }
</script>
</html>