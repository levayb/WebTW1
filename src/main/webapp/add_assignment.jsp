<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add assignment</title>
    <link rel="stylesheet" href="css/brendon.css">
    <script type="text/javascript" src="brendon/brendon.js"></script>
    <link rel="stylesheet" href="css/add_assignment.css">
</head>

<body>
<a href="curriculum_mentor.jsp">Go back</a>
<form action="assignment" method="post" class="assignment_form">
    <br/>Name: <input type="text" name="name" placeholder="name">
    <br/>Image link: <input type="text" name="imgsrc" placeholder="image link">
    <br/>About paragraph: <input type="text" name="about_data" placeholder="about data">
    <br/>Origin paragraph: <input type="text" name="origin_data" placeholder="origin data">
    <br/>Spread parahraph: <input type="text" name="spread_data" placeholder="spread data">
    <audio id="audio" src="brendon/brendon.mp3"></audio>
    <div class="brendon">
        <img onclick="play()" src="images/brendon.png"/>
    </div>
    <br><br><input type="submit" value="Create Assignment">
</form>
</body>


</html>
