<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
            <th>Description</th>
            <th>Date</th>
            <th>Calories</th>
        </tr>
        </thead>
        <c:forEach items="${mealList}" var="meal">
            <jsp:useBean id="meal" scope="page" type="org.lwerl.caloriesmng.model.UserMeal"/>
            <tr>
                <td><c:out value="${meal.description}"/></td>
                <c:set var="fixDateTime" value="${fn:replace({meal.date}, 'T', ' ')}" />
                <fmt:parseDate value="${fixDateTime}" pattern="[yyyy-MM-dd HH:mm]" var="parsedDateTime" type="both" />
                <td><fmt:formatDate pattern="dd MMMM yyyy HH:mm" value="${parsedDateTime}"/></td>
                <td>${meal.calories}</td>
            </tr>
        </c:forEach>
    </table>
</section>
<hr>
<jsp:include page="../../fragments/footer.jsp"/>
</body>
</html>