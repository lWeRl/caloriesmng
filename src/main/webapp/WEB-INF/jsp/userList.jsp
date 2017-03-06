<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="message.app"/>

<html>
<head>
    <jsp:include page="../../fragments/headTag.jsp"/>
</head>
<body>
<section>
    <jsp:include page="../../fragments/bodyHeader.jsp"/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Roles</th>
            <th>Active</th>
            <th>Registered</th>
        </tr>
        </thead>
        <c:forEach items="${userList}" var="user">
            <jsp:useBean id="user" scope="page" type="org.lwerl.caloriesmng.model.User"/>
            <tr>
                <td><c:out value="${user.name}"/></td>
                <td><a href="mailto:${user.email}">${user.email}</a></td>
                <td>${user.roles}</td>
                    <%--<td>${user.enabled}</td>--%>
                <td><%=user.isEnabled()%></td>
                    <%--<td><% System.out.println(user.isEnabled());%></td>--%>
                <td><fmt:formatDate value="${user.registered}" pattern="dd-MMMM-yyyy"/></td>
            </tr>
        </c:forEach>
    </table>
</section>
<hr>
<jsp:include page="../../fragments/footer.jsp"/>
</body>
</html>