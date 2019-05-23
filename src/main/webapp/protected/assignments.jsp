<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<jsp:include page="../snippets/head.jsp">
    <jsp:param name="title" value="Assignments"/>
</jsp:include>
<body>
<h1>Assignments</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Img</th>
            <th>About</th>
            <th>Origin</th>
            <th>Spread</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="assignment" items="${assignments}">
            <tr>
                <td>${assignment.id}</td>
                <td>${assignment.name}</td>
                <td>${assignment.imgsrc}</td>
                <td>${assignment.about}</td>
                <td>${assignment.origin}</td>
                <td>${assignment.spread}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<h2>Read an assignment
<form action="assignment" method="post">
    <select name="name">
        <c:forEach var="assignment" items="${assignments}">
            <option value="${assignment.name}">${assignment.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Read">
</form>
<h2>Delete an assignment
<form action="assignmentdelete" method="post">
    <select name="name">
        <c:forEach var="assignment" items="${assignments}">
            <option value="${assignment.name}">${assignment.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Read">
</form>
<a href="home.jsp">Back to the main page</a>
<jsp:include page="../snippets/show-info.jsp"/>
<jsp:include page="../snippets/show-error.jsp"/>
</body>
</html>
