<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.Account" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Userlist</title>
    <link rel="stylesheet" href="users.css">
</head>
<body>
        <% List<Account> accounts = (List<Account>) request.getAttribute("accounts"); %>
        <% for (Account acc : accounts) { %>
        <p>Username: <b><%= acc.getUsername() %>
        </b> Email: <i><%= acc.getEmail() %>
        </i><br>
        <p>Status: <%= acc.getMentor(acc.isMentor) %>
        </p>
        <% } %>

        <a href="home.html">Back to homepage</a>
</body>
</html>
