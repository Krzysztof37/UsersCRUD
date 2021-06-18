<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 17.06.2021
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add</title>
</head>
<body>
<h1>UsersCRUD</h1>
<form action="/user/list"><button type="submit">Lista użytkowników</button></form>
<h2>Dodaj użytkownika</h2>
<form action="/user/add" method="post">
  <label>Nazwa użytkownika:</label></br>
  <input type="text" name="name"><br>
  <label>Email:</label></br>
  <input type="text" name="email"><br>
  <label>Hasło:</label></br>
  <input type="text" name="password"></br>
<button type="submit">Wyślij</button>

</form>


</body>
</html>
