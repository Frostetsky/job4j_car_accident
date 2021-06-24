<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Accident</title>
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">String</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="text" items="${list}">
    <tr>
        <td>${text}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>