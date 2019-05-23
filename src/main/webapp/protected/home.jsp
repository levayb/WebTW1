<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<jsp:include page="../snippets/head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body>
<h1>Home</h1>
<h2>Links</h2>
<ul>
    <li><a href="accounts">Accounts</a></li>
    <li><a href="assignments">Assignments</a></li>
    <li><a href="addassignment">Add assignment</a></li>
    <li><a href="account">Current account</a></li>
</ul>
<jsp:include page="../snippets/logout.jsp"/>
<jsp:include page="../snippets/show-info.jsp"/>
<jsp:include page="../snippets/show-error.jsp"/>
</body>
</html>
