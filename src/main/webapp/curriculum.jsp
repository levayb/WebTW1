<%@ page import="com.codecool.web.model.Assignment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Curriculum</title>
    <link rel="stylesheet" href="css/curriculum.css">
    <link rel="stylesheet" href="css/brendon.css">
    <script type="text/javascript" src="brendon/brendon.js"></script>
</head>
<body>
<a href="home">Back to Home</a>
<div>
    <% List<Assignment> assignments = (List<Assignment>) request.getAttribute("assignments"); %>
    <h1><%= assignments.get(0).getName()%>
    </h1>
    <img src="https://pbs.twimg.com/media/DV4pD0pVAAUVWFf.png">
    <h2>About</h2>
    <p><%= assignments.get(0).getAbout_data()%>p>
    <h2>Origin</h2>
    <p><%= assignments.get(0).getOrigin_data()%>
    </p>
    <h2>Spread</h2>
    <p><%= assignments.get(0).getSpread_data()%>
    </p>
</div>
</body>
</html>
