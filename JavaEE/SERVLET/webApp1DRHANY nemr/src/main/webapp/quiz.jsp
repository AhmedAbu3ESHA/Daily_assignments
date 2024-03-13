<%--
  Created by IntelliJ IDEA.
  User: bm
  Date: 3/5/2024
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="QuizServlet">

    <p> ${country}</p>
    <br>
    <br>
    <select name="answer">
    <option disabled selected hidden value="">please select</option>
    <c:forEach items="${items }" var="name">
    <option>${name}</option>
    </c:forEach>
    </select>
    
    <br>
    <br>
    <input type="submit" value="start" name="action" />
    <input type="submit" value="next" name="action" ${nextEnabled} />
    <br>
    ${score}


</form>

</body>
</html>
