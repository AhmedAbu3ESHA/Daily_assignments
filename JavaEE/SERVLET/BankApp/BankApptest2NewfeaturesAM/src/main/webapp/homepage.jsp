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
        <h4 style="color: brown"> This option for guests : </h4>
        <br>
        <br>
        calculates end of period cash.
        <br>
        <br>
        <a href="index.jsp"  >Guest</a>
        <br>
        <br>
        <h4 style="color: brown"> you must Login or register to have the following options: </h4>
        <br>
        <br>
        calculates number of years the amount will reach final amount.
        <br>
        <br>
        calculates percentage that will make user reachs the final amount.
        <br>
        <br>
        calculates the payback period.
        <br>
        <br>
        amortized loans.
        <br>
        <br>
        <a href="login.jsp"  >Login</a>
        <a href="reg.jsp"  >Register</a>

    </form>
</div>
</body>
</html>
