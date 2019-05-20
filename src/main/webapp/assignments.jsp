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
<a href="curriculum_mentor.jsp">Go back</a>
<% List<Assignment> assignments = (List<Assignment>) request.getAttribute("assignments"); %>
<div class="split left">
    <table class="assignment_names">
        <% for (Assignment assignment : assignments) { %>
        <tr>
            <td><%= assignment.getName() %>
            </td>
            <td><img src="<%= assignment.getImgsrc()%>"></td>
            <td></td>
            <% } %></tr>
    </table>
</div>
<br>
<div class="split right">
    <br>
    <h1><%= assignments.get(0).getName()%>
    </h1>
    <br>
    <img src="<%= assignments.get(0).getImgsrc() %>" alt="logo"/>
    <br>
    <h2>About</h2>
    <p><%= assignments.get(0).getAbout_data()%>
    </p>
    <h2>Origin</h2>
    <p><%= assignments.get(0).getOrigin_data()%>
    </p>
    <h2>Spread</h2>
    <p><%= assignments.get(0).getSpread_data()%>
    </p>
</div>
</body>
</html>
