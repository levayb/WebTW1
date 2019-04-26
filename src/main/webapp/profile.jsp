<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.Account" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="profile.css">
    <title>Profile</title>
</head>
<body>
  <div class="table">
    <table>
      <tr>
        <th>Username</th>
        <th>Email</th>
        <th>Status</th>
        <% List<Account> accounts = (List<Account>) request.getAttribute("curr"); %>
        <% for (Account acc : accounts) { %>
      </tr>
      <tr>
        <td><b><%= acc.getUsername() %></td>
        <td><i><%= acc.getEmail() %></td>
        <br>
          <td><%= acc.getMentor(acc.isMentor) %></td>
          <% } %>
      </tr>

    </table>
  </div>

        <a href="changestatus">Change status</a>

        <a href="home">Go back</a>

        <a href="logout">Logout</a>


</body>
</html>
