<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<jsp:include page="snippets/head.jsp">
    <jsp:param name="title" value="Login"/>
</jsp:include>
<link rel="stylesheet" href="css/login.css">
<body>
<h1>Login</h1>
<div>
    <h2>Login to your account</h2>
    <form method="post" action="login">
        <input type="text" name="username" placeholder="username">
        <input type="password" name="password" placeholder="password">
        <input type="submit" value="Login">
        <a href="register">Register here</a>
    </form>
</div>
<jsp:include page="snippets/show-error.jsp"/>
</body>
</html>
