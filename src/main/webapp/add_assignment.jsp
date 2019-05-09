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
<br><br>
<form action="assignment" method="post" class="assignment_form">
    <h4>Create an assignment</h4>
    <br/><textarea type="text" name="name" placeholder="Assignment name" class="give" rows="10" cols="10"></textarea>
    <br/><textarea type="text" name="imgsrc" placeholder="Direct link to image" class="give"></textarea>
    <br/><textarea type="text" name="about_data" placeholder="About paragraph" class="give"></textarea>
    <br/><textarea type="text" name="origin_data" placeholder="Origin paragraph" class="give"></textarea>
    <br/><textarea type="text" name="spread_data" placeholder="Spread paragraph" class="give"></textarea>
    <audio id="audio" src="brendon/brendon.mp3"></audio>
    <div class="brendon">
        <img onclick="play()" src="images/brendon.png"/>
    </div>
    <br><br><input type="submit" value="Create Assignment" class="button">
</form>
</body>


</html>
