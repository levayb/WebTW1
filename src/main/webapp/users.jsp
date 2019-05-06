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
<div class="links2">
    <table class="links_table2">
        <tr>
            <td>
                <a href="home" class="back">Back to homepage</a>
            </td>
        </tr>
        <tr>
            <td>
                <a href="logout" class="out">Logout</a>
            </td>
        </tr>
    </table>

</div>
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
        <td><b><%= acc.getEmail() %>
        </b></td>
        <td><b><%= acc.getMentor(acc.isMentor) %>
            <b></b></td>
        <% } %></table>
</div>
<audio id="audio" src="brendon.mp3"></audio>
<div class="brendon">
    <img onclick="play()" src="brendon.png"/>
</div>
</body>
</html>
