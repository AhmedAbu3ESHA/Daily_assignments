
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
${msg}
<div class="container">
    <form action="servlet-servlet">
        <input type="hidden" name="intent" value="save">
        <label> phone </label>
        <br>
        <br>
        <input type="number" name="pho">
        <br>
        <br>
        <input type="submit" name="intent" value="Register">
        <br>
        <br>
        ${message2}
        ${message9}
    </form>
</div>
</body>
</html>