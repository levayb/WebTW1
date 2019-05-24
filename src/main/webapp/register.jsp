<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<jsp:include page="snippets/head.jsp">
    <jsp:param name="title" value="Register"/>
</jsp:include>
<link rel="stylesheet" href="css/register.css">
<body>
<h1>Register</h1>
<div>
    <h2>Create an account</h2>
    <form method="post" action="register">
        <input type="text" name="username" placeholder="username">
        <input type="password" name="password" placeholder="password">
        <input type="text" name="email" placeholder="email">
        <select name="selection">
            <option value="false">student</option>
            <option value="true">mentor</option>
        </select>
        <input type="submit" value="Register">
        <a href="login">Login here</a>
    </form>
</div>
<jsp:include page="snippets/show-error.jsp"/>
</body>
</html>
