<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="css/curriculum.css">
<jsp:include page="../snippets/head.jsp">
    <jsp:param name="title" value="Read assignment"/>
</jsp:include>
<body>
<h1>Current assignment</h1>
<div class="text">
    <h1>Name: <c:out value="${assignment.name}"/></h1>
    <img src="<c:out value="${assignment.imgsrc}"/>"/>
    <h2>About</h2>
    <p>About: <c:out value="${assignment.about}"/></p>
    <h2>Origin</h2>
    <p>Origin: <c:out value="${assignment.origin}"/></p>
    <h2>Spread</h2>
    <p>Spread: <c:out value="${assignment.spread}"/></p>
    <a href="home.jsp">Back to the main page</a>
</div>
</body>
<jsp:include page="../snippets/show-info.jsp"/>
<jsp:include page="../snippets/show-error.jsp"/>
</html>
