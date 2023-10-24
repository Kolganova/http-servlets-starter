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
<img src="${pageContext.request.contextPath}/images/users/cat.jpeg" alt="User image">
<form action="/registration" method="post" enctype="multipart/form-data">
    <label for="userId">Username:
        <input type="text" name="name" id="userId">
    </label></br>
    <label for="birthdayId">Birthday:
        <input type="date" name="birthday" id="birthdayId" required>
    </label></br>
    <label for="emailId">Image:
        <input type="file" name="image" id="imageId">
    </label></br>
    <label for="emailId">email:
        <input type="text" name="email" id="emailId">
    </label></br>
    <label for="passwordId">password:
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
    <div>
        <c:if test="${not empty requestScope.errors}">
            <div style="color: red">
                <c:forEach var="error" items="${requestScope.errors}">
                    <span>${error.message}</span>
                </br>
                </c:forEach>
            </div>
        </c:if>
    </div>
</form>
</body>
</html>
