<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<jsp:include page="snippets/head.jsp">
    <jsp:param name="title" value="Register"/>
</jsp:include>
<body>
<h1>Register</h1>
<form method="post" action="register">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="text" name="email">
    <select name="selection">
      <option value="false">student</option>
      <option value="true">mentor</option>
    </select>
    <input type="submit" value="Register">
</form>
<a href="login">Login here</a>
<jsp:include page="snippets/show-error.jsp"/>
</body>
</html>
