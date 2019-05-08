<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.Assignment" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Userlist</title>
    <link rel="stylesheet" href="css/users.css">
    <link rel="stylesheet" href="css/brendon.css">
    <script type="text/javascript" src="brendon/brendon.js"></script>
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
    <table class="center" style="overflow-x:auto;">
        <tr>
            <% List<Assignment> assignments = (List<Assignment>) request.getAttribute("assignments"); %>
            <% for (Assignment ass : assignments) { %>
        </tr>
            <td><%= ass.getName() %>
            </td>
        <% } %></table>
</div>
<audio id="audio" src="brendon/brendon.mp3"></audio>
<div class="brendon">
    <img onclick="play()" src="images/brendon.png"/>
</div>
</body>
</html>
