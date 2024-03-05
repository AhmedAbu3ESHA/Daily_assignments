<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<form action="hello-servlet">
    <p> ${question}</p>
    <input type="text"     name="answer">
    <br>
    <input type="submit"    value="start" name="action">
    <br>
    <input type="submit"    value="next" name="action">
</form>
</body>
</html>