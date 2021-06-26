<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<html>
<head>
    <title>Create Accident</title>
</head>
<body>
<form:form action="save" modelAttribute="accident">
    <table>
        <form:hidden path="id"/>
        <tr>
            <td>Название:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td>Адресс:</td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>