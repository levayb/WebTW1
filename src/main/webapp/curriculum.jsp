<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class="text">
    <% List<Assignment> curr = (List<Assignment>) request.getAttribute("curr"); %>
    <% for (Assignment a : curr) { %>
    <h1><%=a.getName()%>
    </h1>
    <img src="<%=a.getImgsrc()%>"/>
    <h2><%=a.getAbout()%>
    </h2>
    <p><%=a.getAbout_data()%>
    </p>
    <h2><%=a.getOrigin()%>
    </h2>
    <p><%=a.getOrigin_data()%>
    </p>
    <h2><%=a.getSpread()%>
    </h2>
    <p><%=a.getSpread_data()%>
    </p>
    <% } %>
    <br>
    <br>
    <a href="home">Back to Home</a>
</div>
</body>
</html>
