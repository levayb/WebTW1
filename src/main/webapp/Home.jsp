<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="Error.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        <link rel="stylesheet" href="home.css">
    </head>
    <body>
        <br/><br/><br/><br/><br/>
        <div style="text-align: center;">
            <h2>
            <%
            String a=session.getAttribute("username").toString();
            out.println("Cső  "+a);
            %>
            </h2>
            <br/>
            <br/>
            <br/><br/><br/><br/><br/>
        <a href="logout.jsp">Logout</a>
        </div>

    </body>
</html>
