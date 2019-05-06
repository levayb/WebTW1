<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Register</title>
  <link rel="stylesheet" href="register.css">
  <link rel="stylesheet" href="brendon.css">
  <script type="text/javascript" src="brendon.js"></script>
</head>

<body>
  <h1>Register</h1>
  <div style="text-align: center;">
    <h2>Create an account</h2>
    <div class="form">
      <form class="login-form" action="account" method="post">
        <br />username:<input type="text" name="username" placeholder="username">
        <br />password:<input type="password" name="password" placeholder="password">
        <br />e-mail:<input type="email" name="email" placeholder="email">
        <br />
        <select name="selection">
          <option value="false">student</option>
          <option value="true">mentor</option>
        </select>
        <audio id="audio" src="brendon.mp3"></audio>
        <div class="brendon">
            <img onclick="play()" src="brendon.png"/>
        </div>
        <br /><input type="submit" value="Submit">
      </form>
    </div>
  </div>
</body>

</html>
