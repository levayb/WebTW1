<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.Assignment" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assignments</title>
    <link rel="stylesheet" href="css/users.css">
    <link rel="stylesheet" href="css/brendon.css">
    <script type="text/javascript" src="brendon/brendon.js"></script>
</head>
<body>
<div>
    <table class="center" style="overflow-x:auto;">
        <tr>
            <% List<Assignment> assignments = (List<Assignment>) request.getAttribute("assignments"); %>
            <% for (Assignment ass : assignments) { %>
            <td><%= ass.getName() %>
            </td>
            <td><img src="<%= ass.getImgsrc()%>"></td>
            <td><%= ass.getAbout()%>
            </td>
            <td><%= ass.getAbout_data()%>
            </td>
            <td><%= ass.getOrigin()%>
            </td>
            <td><%= ass.getOrigin_data()%>
            </td>
            <td><%= ass.getSpread()%>
            </td>
            <td><%= ass.getSpread_data()%>
            </td>
        </tr>
        <% } %></table>
</div>
<audio id="audio" src="brendon/brendon.mp3"></audio>
<div class="brendon">
    <img onclick="play()" src="images/brendon.png"/>
</div>
</body>
</html>
