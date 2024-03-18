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
            padding-top: 50px;
            background-color: #533440;
        }
        .container{
            background-color: #E4D4C8;
            margin-right: auto;
            margin-left: auto;
            width: 70%;
            padding-top: 40px;
            /*padding-left: 260px;*/
            text-align: center;
            padding-bottom: 30px;
            border-radius: 5px;
            border-radius: 5px;
        }
        a{
            color: #000;
            text-decoration: none;
            border: 1px solid gray;
            border-radius: 2px;
            padding: 1px 6px;
            background-color: #fff;
            margin-left: 5px;
        }
        /*.container form label{*/
        /*     text-align: left;*/
        /* }*/
        table{
            margin-left: auto;
            margin-right: auto;
            border-color:#000;
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
        <label> Enter final amount  </label>
        <br>
        <br>
        <input type="number" name="finalamount">
        <br>
        <br>
        <label> Enter  percentage </label>
        <br>
        <br>
        <input type="number" name="percentage">
        <br>
        <br>
        <input type="submit" value="show">

        <a href="options.jsp" >back</a>
    </form>
    <br>
    <br>
    ${me}
    <br>
    <br>
    ${message3}
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
