<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.codecool.web.model.Account" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
</head>
<body>
        <% List<Account> accounts = (List<Account>) request.getAttribute("curr"); %>
        <% for (Account acc : accounts) { %>
        <p><i><%= acc.getUsername() %></i>: <%= acc.getEmail() %><br>
         <%= acc.getMentor(acc.isMentor) %> </p>
        <% } %>
</body>
</html>
