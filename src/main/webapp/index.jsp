<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
  <title>Login</title>
  <link rel="stylesheet" href="login.css">
</head>
<body>
  <h1>Professional Street Learn Management System</h1>
  <div style="text-align: center;">
    <h2>Login to your account</h2>
    <div class="register-page">
      <form action="logincheck" method="post">
        <br />username:<input type="text" name="username" placeholder="username">
        <br />password:<input type="password" name="password" placeholder="password">
        <br /><input type="submit" value="Submit">
        <a href="register.html">Register here</a>
      </form>
      <jsp:include page="snippets/show-error.jsp"/>
    </div>
  </div>
</body>

</html>
