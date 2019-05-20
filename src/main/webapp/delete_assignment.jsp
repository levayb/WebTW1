<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.Assignment" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <title>Delete assignment</title>
</head>
<body>
<a href="curriculum_mentor.jsp">Go back</a>
<div class="bigdelete">
    <% List<Assignment> assignments = (List<Assignment>) request.getAttribute("assignments"); %>
    <form action="deleteassignment" method="post" class="delete_assignment">
        <select name="selection">
            <% if (!assignments.isEmpty()) { %>
            <% for (Assignment a : assignments) { %>

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
