<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="com.codecool.web.model.Assignment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Curriculum</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/curriculum.css">
</head>
<body>
<% List<Assignment> curr = (List<Assignment>) request.getAttribute("curr"); %>
<% for (Assignment a : curr) { %>
    <p><%=a.getName()%></p>
    <img src="<%=a.getImgsrc()%>"/>
    <p><%=a.getAbout()%></p>
    <p><%=a.getAbout_data()%></p>
    <p><%=a.getOrigin()%></p>
    <p><%=a.getOrigin_data()%></p>
    <p><%=a.getSpread()%></p>
    <p><%=a.getSpread_data()%></p>
<% } %>
<a href="home">Back to Home</a>
</body>
</html>
