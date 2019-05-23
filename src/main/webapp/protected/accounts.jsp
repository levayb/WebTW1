<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<jsp:include page="../snippets/head.jsp">
    <jsp:param name="title" value="Accounts"/>
</jsp:include>
<body>
<h1>Accounts</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Password</th>
            <th>Email</th>
            <th>Mentor</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="account" items="${accounts}">
            <tr>
                <td>${account.id}</td>
                <td>${account.username}</td>
                <td>${account.password}</td>
                <td>${account.email}</td>
                <td>${account.mentor}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<form action="accountdelete" method="post">
    <select name="username">
        <c:forEach var="account" items="${accounts}">
            <option value="${account.username}">${account.username}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Delete an account">
</form>
<a href="home.jsp">Back to the main page</a>
<jsp:include page="../snippets/show-info.jsp"/>
<jsp:include page="../snippets/show-error.jsp"/>
</body>
</html>
