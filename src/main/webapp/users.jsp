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
    <link rel="stylesheet" href="brendon.css">
    <script type="text/javascript" src="brendon.js"></script>
</head>
<body>
<a href="home">Back to homepage</a>
<a href="logout" class="out">Logout</a>
<div>
    <table class="center">
        <tr>
            <th>Username</th>
            <th>Email</th>
            <th>Status</th>
            <% List<Account> accounts = (List<Account>) request.getAttribute("accounts"); %>
            <% for (Account acc : accounts) { %>
        </tr>
        <td><b><%= acc.getUsername() %>
        </b></td>
        <td><i><%= acc.getEmail() %>
        </i></td>
        <td><%= acc.getMentor(acc.isMentor) %>
        </td>
        <% } %></table>
</div>
<audio id="audio" src="brendon.mp3" ></audio>
<div class="brendon">
  <img onclick="play()" src="brendon.png"/>
</div>
</body>
</html>
