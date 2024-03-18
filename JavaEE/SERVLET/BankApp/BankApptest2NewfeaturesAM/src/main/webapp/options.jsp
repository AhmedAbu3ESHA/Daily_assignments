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

    </style>
</head>
<body>
<div class="container">
    <form autocomplete="off" action="servlet-servlet" method="post">
        <a href="finalcash.jsp" >calculates end of period cash</a>
        <br>
        <br>
        <a href="numofyears.jsp" >calculates number of years the amount will reach final amount</a>
        <br>
        <br>
        <a href="percent.jsp" >calculates percentage that will make user reachs the final amount</a>
        <br>
        <br>
        <a href="loan.jsp" >Amotrized Loan</a>
    </form>

</div>
</body>
</html>
