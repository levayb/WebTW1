<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<jsp:include page="../snippets/head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body>
<h1>Current profile</h1>
<p>Username: <c:out value="${account.username}"/></p>
<p>Password: <c:out value="${account.password}"/></p>
<p>Email: <c:out value="${account.email}"/></p>
<p>Mentor: <c:out value="${account.mentor}"/></p>
</body>
<form action="accountchange" method="post">
    <input type="submit" value="Change status">
</form>
<a href="home.jsp">Back to the main page</a>
<jsp:include page="../snippets/show-info.jsp"/>
<jsp:include page="../snippets/show-error.jsp"/>
</html>
