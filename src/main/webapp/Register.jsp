<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.model.Email" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width-device-width, inital-scale=1.0">
    <title>Wazaaap</title>
</head>
<body>
    <h1>Wazaaaap</h1>
    <% List<Email> emails = (List) request.getAttribute("service"); %>
    <% for (Email e :emails){ %>
    <p><%= e.getEmail() %></p>
<% } %>
<a href="index.html">Back to <em>business</em></a>
<br>
</body>
</html>
