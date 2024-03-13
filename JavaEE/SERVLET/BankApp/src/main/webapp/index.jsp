<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>


<%@ page import = "jakarta.servlet.http.*,jakarta.servlet.*" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<form action="servlet-servlet" method="post">
    <input type="hidden" name="intent" value="show">
<label> amount </label>
    <input type="text" name="amount">
    <br>
    <label>years</label>
    <input type="text" name="year">
    <br>
    <label> percentage  </label>
        <input type="text" name="percentage">
        <br>
        <br>
        <input type="submit" value="show">

    <a href="savedata.jsp">save</a>
</form>
<br>
<br>
<table border="1">

    <c:forEach items="${transaction}" var="d">
        <tr style="color: ${color}">
            <td>Amount : ${d.amount} || years: ${d.year} || percent: ${d.percent}% || percent: ${d.balance}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>