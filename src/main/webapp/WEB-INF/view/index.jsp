<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<html>
<head>
    <title>Accident</title>
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col", bgcolor="yellow">№</th>
        <th scope="col", bgcolor="yellow">Название</th>
        <th scope="col", bgcolor="yellow">Описание</th>
        <th scope="col", bgcolor="yellow">Адресс</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="accident" items="${accidents}">
    <tr>
        <td>${accident.id}</td>
        <td>${accident.name}</td>
        <td>${accident.description}</td>
        <td>${accident.address}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>