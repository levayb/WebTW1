<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="css/assignment.css">
<jsp:include page="../snippets/head.jsp">
    <jsp:param name="title" value="Assignments"/>
</jsp:include>
<body>
<div>
    <h1>Assignments</h1>
    <table class="center">
        <thead>
        <tr>
            <th>Name</th>
            <th>Picture</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="assignment" items="${assignments}">
            <tr>
                <td>${assignment.name}</td>
                <td><img src=" ${assignment.imgsrc}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="loader">
    <h2>Read an assignment</h2>
    <form action="assignment" method="post">
        <select name="name">
            <c:forEach var="assignment" items="${assignments}">
                <option value="${assignment.name}">${assignment.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Read">
    </form>
</div>
<div class="deleter">
    <h2>Delete an assignment</h2>
    <form action="assignmentdelete" method="post">
        <select name="name">
            <c:forEach var="assignment" items="${assignments}">
                <option value="${assignment.name}">${assignment.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Read">
    </form>
    <a href="home.jsp">Back to the main page</a>
</div>
<jsp:include page="../snippets/show-info.jsp"/>
<jsp:include page="../snippets/show-error.jsp"/>
</body>
</html>
