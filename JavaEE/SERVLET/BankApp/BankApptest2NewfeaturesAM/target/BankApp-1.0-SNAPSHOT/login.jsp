
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>


<%@ page import = "jakarta.servlet.http.*,jakarta.servlet.*" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>
        body{
            padding-top: 50px;
            background-color: #533440;
        }
        .container{
            background-color: #E4D4C8;
            margin-right: auto;
            margin-left: auto;
            width: 50%;
            padding-top: 40px;
            /*padding-left: 260px;*/
            text-align: center;
            padding-bottom: 30px;
            border-radius: 5px;
        }

        table{
            margin-left: auto;
            margin-right: auto;
            border-color:#000;
        }
    </style>
</head>
<body>
${msg}
<div class="container">
    <form action="servlet-servlet">
        <input type="hidden" name="intent" value="Login">
        <label> phone </label>
        <br>
        <br>
        <input type="number" name="phone">
        <br>
        <br>
        <input type="submit" value="Login">
        <br>
        <br>
        ${message2}
        ${message3}
        ${message8}
        <table border="1">

            <c:forEach items="${transaction}" var="d">
                <tr>
                    <td> Amount : ${d.amount} || Years: ${d.year} || Percent: ${d.percent}% || Balance : ${d.balance}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>