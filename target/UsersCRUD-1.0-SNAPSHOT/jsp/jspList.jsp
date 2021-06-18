<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 17.06.2021
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>UserList</title>
</head>
<body>
<h1>UsersCRUD</h1>
<h2>Lista Użytkowników</h2><form action="/user/add"> <button type="submit">Dodaj użytkownika</button></form>

<table>
    <tbody>
    <tr><td>Id:</td><td>Nazwa użytkownika:</td><td>Email</td><td>Akcja</td>
    </tr>
<c:forEach items="${userList}" var="user">
    <tr>
        <td>${user.getId()}</td><td>${user.getUsername()}</td><td>${user.getEmail()}</td><td><a href="/user/read?id=${user.getId()}&name=${user.getUsername()}&email=${user.getEmail()}">Edytuj</a>
    <a href="/user/show?id=${user.getId()}">Pokaż</a> <a href="/user/delete?id=${user.getId()}">Usuń</a> </td>
    </tr>


</c:forEach>
    </tbody>
</table>


</body>
</html>
