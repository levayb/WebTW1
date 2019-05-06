<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.Account" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/profile.css">
    <link rel="stylesheet" href="css/brendon.css">
    <script type="text/javascript" src="brendon/brendon.js"></script>
    <title>Profile</title>
</head>
<body>
<div class="links">
    <table class="links_table">
        <tr>
            <td>
                <a href="home">Go back</a>
            </td>
        </tr>
        <tr>
            <td>

            </td>
        </tr>
        <tr>
            <td>
                <a href="changestatus">Change status</a>
            </td>
        </tr>
        <tr>
            <td>

            </td>
        </tr>
        <tr>
            <td>
                <a href="logout">Logout</a>
            </td>
        </tr>
    </table>
</div>
<div class="table">
    <table class="accounts">
        <tr>
            <th>Username</th>
            <th>Email</th>
            <th>Status</th>
            <% List<Account> accounts = (List<Account>) request.getAttribute("curr"); %>
            <% for (Account acc : accounts) { %>
        </tr>
        <tr>
            <td><b><%= acc.getUsername() %>
            </td>
            <td><i><%= acc.getEmail() %>
            </td>
            <br>
            <td><%= acc.getMentor(acc.isMentor) %>
            </td>
            <% } %>
        </tr>

    </table>
</div>
<audio id="audio" src="brendon/brendon.mp3"></audio>
<div class="brendon">
    <img onclick="play()" src="images/brendon.png"/>
</div>
</body>
</html>
