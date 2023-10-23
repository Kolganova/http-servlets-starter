<%--
  Created by IntelliJ IDEA.
  User: kiskadi
  Date: 2023-10-22
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/registration" method="post">
    <label for="userId">USERNAME:
        <input type="text" name="name" id="userId">
    </label></br>
    <label for="birthdayId">BIRTHDAY:
        <input type="date" name="birthday" id="birthdayId">
    </label></br>
    <label for="emailId">EMAIL:
        <input type="email" name="email" id="emailId">
    </label></br>
    <label for="passwordId">PASSWORD:
        <input type="password" name="password" id="passwordId">
    </label></br>
    <select name="role" id="roleId">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value="${role}">${role}</option>
        </c:forEach>
    </select></br>
    <c:forEach var="gender" items="${requestScope.genders}">
        <input type="radio" name="gender" value="${gender}"> ${gender}
        </br>
    </c:forEach>
    <button type="submit">SEND</button>
</form>
</body>
</html>
