<%@ page %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/brendon.css">
    <script type="text/javascript" src="brendon/brendon.js"></script>
</head>

<body>

<h1>Memecool MMS Homepage</h1>

<div>
    <table class="table">
        <tr>
            <td>
                <a href="curriculum_mentor.jsp">Curriculum</a>
            </td>
            <td></td>
            <td></td>
            <td>
                <a href="currentuser">Current user</a>
            </td>
            <td></td>
            <td></td>
            <td>
                <a href="userlist">Registered users</a>
            </td>
            <td></td>
            <td></td>
            <td>
                <a href="logout">Logout</a>
            </td>
        </tr>
    </table>
</div>
<audio id="audio" src="brendon/brendon.mp3"></audio>
<div class="brendon">
    <img onclick="play()" src="images/brendon.png"/>
</div>

</body>

</html>
