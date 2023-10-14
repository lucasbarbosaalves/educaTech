<%--
  Created by IntelliJ IDEA.
  User: Lukas
  Date: 14/10/2023
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<form action="/register" method="post">

    <span>${requestScope.message}</span>

    <br>
    <label for="name">Name</label>
    <input type="text" id="name" name="name">

    <br>

    <label for="email">Email</label>
    <input type="text" id="email" name="email">

    <br>

    <label for="password">Password</label>
    <input type="password" id="password" name="password">

    <button type="submit">Register</button>

</form>

<a href="/login.jsp">Login</a>

</body>
</html>