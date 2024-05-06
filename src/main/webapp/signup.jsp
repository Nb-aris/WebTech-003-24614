<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>SignUp</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #cccccc;
        }

        .signup-container {
            width: 25%;
            margin-top: 100px;
            margin-left: 600px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .signup-container form label {
            font-weight: bold;
            margin-bottom: 5px;
            display: block;
        }

        .signup-container form input[type="text"],
        .signup-container form input[type="password"] {
            width: calc(100% - 12px);
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .signup-container form input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .signup-container form input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .signup-container h1{
            text-align: center;
            color: #007bff;
            font-size: 22px;
        }
        .si
    </style>
</head>
<body>
<div class="container">
    <div class="header-side">
        <a href="index.jsp">Home</a>
    </div>
    <%--    <img src="university.JPG" alt="">--%>
</div>
<div class="signup-container">
    <h1>Sign Up</h1>
    <form action="SignUp_Servlets" method="post">
        <label>Full name</label><br>
        <input type="text" name="name" required><br>
        <label>Email</label><br>
        <input type="text" name="email" required><br>
        <label>Create password</label><br>
        <input type="password" name="password" required><br>
        <input type="hidden" name="type_of_usr">
        <input type="submit" value="SignUp">
    </form>
</div>
</body>
</html>
