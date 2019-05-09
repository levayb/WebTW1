<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.Account" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Userlist</title>
    <link rel="stylesheet" href="css/users.css">
    <link rel="stylesheet" href="css/brendon.css">
    <script type="text/javascript" src="brendon/brendon.js"></script>
</head>
<body>
<div class="links2">
    <table class="links_table2">
        <tr>
            <td>
                <a href="home" class="back">Back to homepage</a>
            </td>
        </tr>
        <tr>
            <td>
                <a href="logout" class="out">Logout</a>
            </td>
        </tr>
    </table>

</div>
<div>
    <table class="center" style="overflow-x:auto;">
        <tr>
            <td class="top">Username</td>
            <td class="top">Email</td>
            <td class="top">Status</td>
            <% List<Account> accounts = (List<Account>) request.getAttribute("accounts"); %>
            <% for (Account acc : accounts) { %>
            <% if (!acc.getUsername().equals("admin")) { %>
        </tr>
        <tr>
            <td><b><%= acc.getUsername() %>
            </b></td>
            <td><b><%= acc.getEmail() %>
            </b></td>
            <td><b><%= acc.getMentor(acc.isMentor) %>
                <b></b></td>
        </tr>
        <% }
        } %></table>
</div>
    <form action="delete" method="post">
    <% List<Account> curr = (List<Account>) request.getAttribute("curr"); %>
    <% String current = curr.get(0).getUsername(); %>
    <% if (current.equals("admin")) { %>
        <select name="selection">
        <% for (Account a : accounts) { %>
            <% if (!a.getUsername().equals("admin")) { %>

                    <option value=<%=a.getUsername()%>><%=a.getUsername()%></option>
            <% }
            } %>
        </select>
        <input type="submit" value="Delete"></a>
    <% } %>
    </form>
<audio id="audio" src="brendon/brendon.mp3"></audio>
<div class="brendon">
    <img onclick="play()" src="images/brendon.png"/>
</div>
</body>
</html>
