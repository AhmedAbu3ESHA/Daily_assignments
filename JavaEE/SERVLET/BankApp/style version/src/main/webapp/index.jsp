<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>


<%@ page import = "jakarta.servlet.http.*,jakarta.servlet.*" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Bank App</title>
    <style>
        body{
            background-image: url("bg.jpg");
            background-size:cover;
            padding-top: 50px;
        }
        .container{
            background-color: rgba(255, 255, 255, 0.69);
            margin-right: auto;
            margin-left: auto;
            width: 60%;
            padding-top: 20px;
            padding-left: 20px;
            text-align: center;
            padding-bottom: 20px;
            border-radius: 5px;
            border-radius: 5px;

        }
        a, .btn{
            color: #000;
            text-decoration: none;
            border: 1px solid gray;
            border-radius: 10px;
            padding: 1px 6px;
            background-color:#b9b3b35c;
            margin-bottom: 5px;
            font-size: 16px;
            text-transform: capitalize;
        }
        p{
            text-transform: capitalize;
            font-weight: bold;
            padding-bottom: 5px;
            font-size: 13px;

        }
        h4{
            font-size: 23px;
            font-variant:small-caps;
        }
    </style>
</head>
<body>
<div class="container">
    <form autocomplete="off" action="servlet-servlet" method="post">
        <input type="hidden" name="intent" value="show">
        <label> Enter your amount </label>
        <br>
        <br>
        <input type="number" name="amount">
        <br>
        <br>
        <label> Enter number of years </label>
        <br>
        <br>
        <input type="number" name="year">
        <br>
        <br>
        <label> Enter  percentage  </label>
        <br>
        <br>
        <input type="number" name="percentage">
        <br>
        <br>
        <input type="submit" value="show" class="btn">
        <a href="reg.jsp" >Register</a>
    </form>
    <br>
    <br>
    ${me}
    <br>
    <br>
    ${message5}
    ${message6}
    ${message7}
    <table border="1">

        <c:forEach items="${transaction}" var="d">
            <tr>
                <td> Amount : ${d.amount} || Years: ${d.year} || Percent: ${d.percent}% || Balance : ${d.balance}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
