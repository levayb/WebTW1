<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="css/profile.css">
<jsp:include page="/snippets/head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<link rel="stylesheet" href="css/users.css">
<body>
<h1>Current profile</h1>
<div>
    <table class="accounts">
        <tr>
            <td>Username: <c:out value="${account.username}"/></td>
            <td>Email: <c:out value="${account.email}"/></td>
            <td>Mentor: <c:out value="${account.mentor}"/></td>
        </tr>
    </table>
</div>
<br>
<div class="remover">
    <form action="accountchange" method="post">
        <input type="submit" value="Change status">
    </form>
    <br>
    <a href="home.jsp">Back to the main page</a>
</div>
</body>
<jsp:include page="/snippets/show-info.jsp"/>
<jsp:include page="/snippets/show-error.jsp"/>
</html>
