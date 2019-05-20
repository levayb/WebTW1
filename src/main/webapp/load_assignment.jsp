<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.codecool.web.model.Assignment" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Curriculum</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/curriculum.css">
    <link rel="stylesheet" href="css/brendon.css">
    <script type="text/javascript" src="brendon/brendon.js"></script>
</head>
<body>
<% List<Assignment> assignments = (List<Assignment>) request.getAttribute("assignments"); %>
<% for (Assignment a : assignments) { %>
    <% if (!a.getName().isEmpty()) { %>
        <% a.getName(); %>
    <% }
    } %>
<a href="readassignment">Read</a>
</body>
</html>
