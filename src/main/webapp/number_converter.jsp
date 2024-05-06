<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Converter</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <div class="body-side">
        <div class="header-side">
            <a href="index.jsp">Home</a>
        </div>
        <div class="container-c">
            <div class="title-c">
                <h1>Converter</h1>
            </div>
            <div class="ui-button">
                <form action="convert" method="GET">
                    <label>Enter Base 10 Number </label>
                    <input type="text" name="num" ><br><br>
                    <button type="submit" name="bn" value="Binary">Binary</button>
                    <button type="submit" name="hex" value="Hexa">Hexa</button>
                    <button type="submit" name="oct" value="Octal">Octal</button>
                    <button type="submit" name="Clr" value="Clear">Clear</button>
                </form>
            </div>
            <h2>Result</h2>
            <p>Number: <%=  request.getAttribute("numbers")%></p>
            <p>Status: <%=  request.getAttribute("result")%></p>
            <p>~ <%=  request.getAttribute("status")%></p>
            <label class="msg" name="msg"></label>
        </div>

        <form action="index.jsp">
            <button type="submit" class="back-home">Back Home</button>
        </form>
    </div>
</div>
</body>
</html>