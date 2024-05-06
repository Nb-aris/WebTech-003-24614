<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Admission</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }

        .reg-container {
            width: 400px;
            margin-top: 20px;
            margin-left: 550px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .reg-container form label {
            font-weight: bold;
            margin-bottom: 5px;
            display: block;
        }

        .reg-container form input[type="text"],
        .reg-container form input[type="date"],
        .reg-container form select {
            width: calc(100% - 12px);
            padding: 9px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .reg-container form input[type="file"] {
            margin-bottom: 15px;
        }

        .reg-container form input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .reg-container form input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .reg-container h1{
            text-align: center;
            color: #007bff;
            font-size: 22px;
        }
        .sign
    </style>
</head>
<body>
<div class="container">
    <div class="header-side">
        <a href="index.jsp">Home</a>

    </div>
    <%--    <img src="university.JPG" alt="">--%>
</div>
<div class="reg-container">
    <h1>Admission</h1>
    <form action="AdmisionServlets" method="Post">
        <label for="">Full name</label><br>
        <input type="text" name="name"><br>
        <label id="Genders">Gender</label><br>
        <select id="gender" name="gender" required><br>
            <option value="">Select Gender</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
        </select><br>
<%--        <label>Birth date</label><br>--%>
<%--        <input type="date" name="bd" required><br>--%>
        <label for="">email</label><br>
        <input type="text" name="email"><br>
        <label>Course to study</label><br>
        <select name="course" id="" required>
            <option value="">Select Course</option>
            <option value="Big data">Big data</option>
            <option value="AI">AI</option>
            <option value="Data science">Data science</option>
        </select><br>
        <input type="hidden" name="status">
        <label >Passport Picture (JPG/PNG):</label><br>
        <input type="file" name="passportPicture" accept=".jpg,.jpeg,.png"><br>
        <label >Other Document (PDF):</label><br>
        <input type="file" name="otherDocument" accept=".pdf"><br>
        <input type="submit" value="Submit">
    </form>
    </div>
</body>
</html>
