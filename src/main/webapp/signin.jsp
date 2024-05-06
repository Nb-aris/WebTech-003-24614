<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="style.css">
<html>
<head>
    <title>Sign In</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #cccccc;
        }

        .signin-container {
            width: 25%;
           margin-top: 100px;
            margin-left: 600px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .signin-container form label {
            font-weight: bold;
            margin-bottom: 2px;
            display: block;

        }

        .signin-container form input[type="text"],
        .signin-container form input[type="password"] {
            width: calc(100% - 16px);
            padding: 12px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;

        }

        .signin-container form input[type="submit"] {
            width: 50%;
            padding: 12px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            margin-left: 100px;
            margin-top: 40px;
        }

        .signin-container form input[type="submit"]:hover {
            background-color: #0056b3;

        }
        .signin-container h1{
            text-align: center;
            color: #007bff;
            font-size: 22px;
        }
        .signin-container img{
            margin-left: 150px;
            padding: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header-side">
        <a href="index.jsp">Home</a>
    </div>
    <%--    <img src="university.JPG" alt="">--%>
</div>
<div class="signin-container">
<%--              <h1>Log in</h1>--%>
    <img src="login-img.jpg" alt="">
    <form action="SignIn_Servlets" method="post">
        <label>Email</label><br>
        <input type="text" name="email" placeholder="Email" required><br>
        <label>Password</label><br>
        <input type="password" name="password"  placeholder="Password" required><br>
        <input type="checkbox" name="admins" value="admin">
        <input type="submit" value="LogIn">
    </form>
</div>

</body>
</html>
