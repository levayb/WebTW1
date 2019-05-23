<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<jsp:include page="../snippets/head.jsp">
    <jsp:param name="title" value="Read assignment"/>
</jsp:include>
<body>
<h1>Current assignment</h1>
<p>Name: <c:out value="${assignment.name}"/></p>
<p>Img link: <c:out value="${assignment.imgsrc}"/></p>
<p>About: <c:out value="${assignment.about}"/></p>
<p>Origin: <c:out value="${assignment.origin}"/></p>
<p>Spread: <c:out value="${assignment.spread}"/></p>
</body>
<a href="home.jsp">Back to the main page</a>
<jsp:include page="../snippets/show-info.jsp"/>
<jsp:include page="../snippets/show-error.jsp"/>
</html>
