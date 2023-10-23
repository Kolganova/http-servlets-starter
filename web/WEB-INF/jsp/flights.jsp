<%--
  Created by IntelliJ IDEA.
  User: kiskadi
  Date: 2023-10-19
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Полеты</title>
</head>
<body>
<h1>Список перелетов</h1>
<ul>
    <c:forEach var="flight" items="${requestScope.flights}">
    <li>
        <a href="${pageContext.request.contextPath}/tickets?flightId=${flight.id}">${flight.description}</a>
    </li>
</ul>
</c:forEach>
</body>
</html>
