<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<jsp:include page="../snippets/head.jsp">
    <jsp:param name="title" value="Add assignment"/>
</jsp:include>
<body>
<h2>Add new assignment</h2>
<form method="post" action="addassignment">
    <input type="text" name="name">
    <input type="text" name="imgsrc">
    <input type="text" name="about">
    <input type="text" name="origin">
    <input type="text" name="spread">
    <input type="submit" value="Create new assignment">
</form>
<a href="home.jsp">Back to the main page</a>
<jsp:include page="../snippets/show-info.jsp"/>
<jsp:include page="../snippets/show-error.jsp"/>
</body>
</html>
