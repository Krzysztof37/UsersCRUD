<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 18.06.2021
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>ShowUser</title>
</head>
<body>
<h1>UsersCRUD</h1><form action="/user/add"><button type="submit">Dodaj użytkownika</button> </form>

<table>
    <thead>Szczegóły użytkownika</thead>
    <tr><td>Id:</td> <td>${user.getId()}</td></tr>
    <tr><td>Nazwa użytkownika:</td><td>${user.getUsername()}</td></tr>
    <tr><td>Email:</td><td>${user.getEmail()}</td></tr>
</table>



</body>
</html>
