<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="css/add_assignment.css">
<jsp:include page="../snippets/head.jsp">
    <jsp:param name="title" value="Add assignment"/>
</jsp:include>
<body>
<h1>Add new assignment</h1>
<div class="assignment_form">
    <form method="post" action="addassignment">
        <br/><textarea type="text" name="name" placeholder="Name" class="give"></textarea>
        <br/><textarea type="text" name="imgsrc" placeholder="Image source" class="give"></textarea>
        <br/><textarea type="text" name="about" placeholder="About" class="give"></textarea>
        <br/><textarea type="text" name="origin" placeholder="Origin" class="give"></textarea>
        <br/><textarea type="text" name="spread" placeholder="Ppread" class="give"></textarea>
        <br/><input type="submit" value="Create new assignment" class="button">
    </form>
</div>
<a href="home.jsp">Back to the main page</a>
<jsp:include page="../snippets/show-info.jsp"/>
<jsp:include page="../snippets/show-error.jsp"/>
</body>
</html>
