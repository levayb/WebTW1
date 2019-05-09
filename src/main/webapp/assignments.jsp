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
<div>
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
<div>
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
<div class="actual_text">
    <h1><%= assignments.get(5).getName()%>
    </h1>
    <img src="<%= assignments.get(5).getImgsrc()%>">
    <h2>About</h2>
    <p><%= assignments.get(5).getAbout_data()%>
    </p>
    <h2>Origin</h2>
    <p><%= assignments.get(5).getOrigin_data()%>
    </p>
    <h2>Spread</h2>
    <p><%= assignments.get(5).getSpread_data()%>
    </p>
</div>
</body>
</html>
