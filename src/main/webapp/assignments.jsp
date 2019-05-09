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
<div>
    <table class="assignment_names">
        <% List<Assignment> assignments = (List<Assignment>) request.getAttribute("assignments"); %>
        <% for (Assignment assignment : assignments) { %>
        <tr>
            <td><%= assignment.getName() %>
            </td>
            <td><img src="<%= assignment.getImgsrc()%>"></td>
            <td></td>
            <% } %></tr>
    </table>
</div>
</body>
</html>
