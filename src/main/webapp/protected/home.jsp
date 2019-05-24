<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="css/home.css">
<jsp:include page="../snippets/head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body>
<h1>Home</h1>
<h2>Links</h2>
<table class="table">
    <tr>
        <td><a href="accounts">Accounts</a></td>
        <td><a href="assignments">Assignments</a></td>
        <td><a href="addassignment">Add assignment</a></td>
        <td><a href="account">Current account</a></td>
    </tr>
</table>
<jsp:include page="../snippets/logout.jsp"/>
<jsp:include page="../snippets/show-info.jsp"/>
<jsp:include page="../snippets/show-error.jsp"/>
</body>
</html>
