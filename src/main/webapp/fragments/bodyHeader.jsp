<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%--<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>

<fmt:setLocale value="en"/>
<fmt:setBundle basename="messages.app"/>
<header><fmt:message key="app.title"/></header>

<%--<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">--%>
    <%--<div class="container">--%>

        <%--<c:url value="/meals" var="meals"/>--%>
        <%--<a href="${meals}" class="navbar-brand"><fmt:message key="app.title"/></a>--%>

        <%--<div class="collapse navbar-collapse">--%>
            <%--<c:url value="/logout" var="logout"/>--%>
            <%--<form:form class="navbar-form navbar-right" action="${logout}" method="post">--%>
                <%--<sec:authorize access="isAuthenticated()">--%>
                    <%--<sec:authorize access="hasRole('ROLE_ADMIN')">--%>
                        <%--<c:url value="/users" var="users"/>--%>
                        <%--<a class="btn btn-info" role="button" href="${users}"><fmt:message key="users.title"/></a>--%>
                    <%--</sec:authorize>--%>
                    <%--<c:url value="/profile" var="profile"/>--%>
                    <%--<a class="btn btn-info" role="button" href="${profile}">${userTo.name} profile</a>--%>
                    <%--<input type="submit" class="btn btn-primary" value="Logout">--%>
                <%--</sec:authorize>--%>
            <%--</form:form>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
