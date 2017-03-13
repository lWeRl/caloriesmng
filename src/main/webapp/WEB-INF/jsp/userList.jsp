<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="dandelion" uri="http://github.com/dandelion" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<fmt:setBundle basename="messages.app"/>

<html>
<dandelion:bundle includes="datatables"/>
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
                    <datatables:column title="Email"><a href="<c:url value="mailto:${user.email}"/>">${user.email}</a> </datatables:column>
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
<hr>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>