<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="dandelion" uri="http://github.com/dandelion" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<fmt:setBundle basename="messages.app"/>

<html>
<dandelion:bundle includes="mainDatatable"/>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3><fmt:message key="users.title"/></h3>
            <div class="view-box">
                <a class="btn btn-sm btn-info" id="add">Add User</a>

                <datatables:table id="datatable" data="${userList}" row="user" theme="bootstrap3"
                                  cssClass="table table-striped" pageable="false" info="false">

                    <datatables:column title="Name" property="name"/>
                    <datatables:column title="Email"><a href="<c:url value="mailto:${user.email}"/>">${user.email}</a>
                    </datatables:column>
                    <datatables:column title="Roles" property="roles"/>
                    <datatables:column title="Active">
                        <input type="checkbox"
                               <c:if test="${user.enabled}">checked</c:if> id="active_${user.id}"/>
                    </datatables:column>
                    <datatables:column title="Registered">
                        <fmt:formatDate value="${user.registered}" pattern="dd-MMMM-yyyy"/>
                    </datatables:column>
                    <datatables:column filterable="false" sortable="false">
                        <a class="btn btn-xs btn-danger delete" id="${user.id}">Delete</a>
                    </datatables:column>
                    <%--<datatables:column sortable="false" renderFunction="renderUpdateBtn"/>--%>
                    <%--<datatables:column sortable="false" renderFunction="renderDeleteBtn"/>--%>

                    <datatables:callback type="init" function="makeEditable"/>
                </datatables:table>
            </div>
        </div>
    </div>
</div>
<%--<section>--%>
<%--<table border="1" cellpadding="8" cellspacing="0">--%>
<%--<thead>--%>
<%--<tr>--%>
<%--<th>Name</th>--%>
<%--<th>Email</th>--%>
<%--<th>Roles</th>--%>
<%--<th>Active</th>--%>
<%--<th>Registered</th>--%>
<%--</tr>--%>
<%--</thead>--%>
<%--<c:forEach items="${userList}" var="user">--%>
<%--<jsp:useBean id="user" scope="page" type="org.lwerl.caloriesmng.model.User"/>--%>
<%--<tr>--%>
<%--<td><c:out value="${user.name}"/></td>--%>
<%--<td><a href="mailto:${user.email}">${user.email}</a></td>--%>
<%--<td>${user.roles}</td>--%>
<%--&lt;%&ndash;<td>${user.enabled}</td>&ndash;%&gt;--%>
<%--<td><%=user.isEnabled()%></td>--%>
<%--&lt;%&ndash;<td><% System.out.println(user.isEnabled());%></td>&ndash;%&gt;--%>
<%--<td><fmt:formatDate value="${user.registered}" pattern="dd-MMMM-yyyy"/></td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--</section>--%>
<jsp:include page="fragments/footer.jsp"/>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">User details:</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post" id="detailsForm">
                    <input hidden="hidden" id="id">

                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3">Name:</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name" placeholder="name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="control-label col-xs-3">Email:</label>
                        <div class="col-xs-9">
                            <input type="email" class="form-control" id="email" name="email" placeholder="email">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="control-label col-xs-3">Password:</label>
                        <div class="col-xs-9">
                            <input type="password" class="form-control" minlength="5" id="password" name="password" placeholder="">
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
</body>
<script type="text/javascript">
    var ajaxUrl = 'ajax/admin/users/';
    //    $(document.ready( function (
    $(function () {
        makeEditable();
    });
</script>
</html>