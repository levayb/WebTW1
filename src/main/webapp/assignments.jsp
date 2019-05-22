<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.Assignment" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assignments</title>
    <link rel="stylesheet" href="css/assignment.css">
</head>
<body>
<% List<Assignment> assignments = (List<Assignment>) request.getAttribute("assignments"); %>
<br>
<div>
    <a href="home">Go back</a>
    <br>
    <br>
    <br>
    <form action="loadassignment" method="post">
        <select name="selectionn">
            <% for (Assignment a : assignments) { %>
            <% if (!a.getName().isEmpty()) { %>

            <option value=<%=a.getName()%>><%=a.getName()%>
            </option>
            <% }
            } %>
        </select>
        <input type="submit" value="View" class="button">
    </form>
    <br>
    <form action="deleteassignment" method="post" class="delete_assignment">
        <select name="selection">
            <% for (Assignment a : assignments) { %>
            <% if (!a.getName().isEmpty()) { %>

            <option value=<%=a.getName()%>><%=a.getName()%>
            </option>
            <% }
            } %>
        </select>
        <input type="submit" value="Delete" class="button">
    </form>
</div>
</body>
</html>
