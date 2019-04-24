<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.Account" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Userlist</title>
</head>
<body>
    <% List<Account> accounts = new ArrayList<>(); %>
    <% if (request.getAttribute("accounts") != null){ %>
        <% accounts.addAll((List<Account>)request.getAttribute("accounts")); %>
    <% } %>
    <% for (Account acc : accounts) { %>
    <p><i><%= acc.getUsername() %></i>: <%= acc.getEmail() %><br>
     <%= acc.getMentor(acc.isMentor) %> </p>
    <% } %>
</body>
</html>
