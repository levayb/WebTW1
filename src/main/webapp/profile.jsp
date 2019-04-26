<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.Account" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="profile.css">
    <link rel="stylesheet" href="brendon.css">
    <script type="text/javascript" src="brendon.js"></script>
    <title>Profile</title>
</head>
<body>
        <% List<Account> accounts = (List<Account>) request.getAttribute("curr"); %>
        <% for (Account acc : accounts) { %>
        <p>Username: <b><%= acc.getUsername() %>
        </b> Email: <i><%= acc.getEmail() %>
        </i><br>
        <p>Status: <%= acc.getMentor(acc.isMentor) %>
        </p>
        <% } %>

        <a href="changestatus">Change status</a>

        <a href="home">Go back</a>

        <a href="logout">Logout</a>

  <audio id="audio" src="brendon.mp3" ></audio>
  <div class="brendon">
      <img onclick="play()" src="brendon.png"/>
  </div>
</body>
</html>
