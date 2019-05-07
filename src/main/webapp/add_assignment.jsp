<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add assignment</title>
    <link rel="stylesheet" href="css/brendon.css">
    <script type="text/javascript" src="brendon/brendon.js"></script>
</head>

<body>
<form action="assignment" method="post">
    <br/>name:<input type="text" name="name" placeholder="name">
    <br/>imgsrc:<input type="text" name="imgsrc" placeholder="imgsrc">
    <br/>about_data:<input type="text" name="about_data" placeholder="about_data">
    <br/>origin_data:<input type="text" name="origin_data" placeholder="origin_data">
    <br/>spread_data:<input type="text" name="spread_data" placeholder="spread_data">
    <audio id="audio" src="brendon/brendon.mp3"></audio>
    <div class="brendon">
        <img onclick="play()" src="images/brendon.png"/>
    </div>
    <br/><input type="submit" value="Submit">
</form>
</body>

</html>
