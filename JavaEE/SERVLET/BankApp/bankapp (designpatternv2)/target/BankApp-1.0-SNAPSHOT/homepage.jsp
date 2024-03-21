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
        a{
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
        .fbox{
            display: flex;

        }
        h4{
            font-size: 23px;
            font-variant:small-caps;
        }
        .left,.right{
            width: 40%;
            margin-left: 5%;
            border: gray 1px solid;
            border-radius: 5px;
            padding-bottom: 5px;
            justify-content: center;
            align-items: center;

        } table,tr,td{
              font-weight: bold;
              font-size: 16px;

          }


    </style>
</head>
<body>
<div class="container">

    <form autocomplete="off" action="servlet-servlet" method="post">
        <div class="fbox">
            <div class="right">
                <h4 style="color: brown"> Guest mode </h4>
                <p>calculate cash</p>
                <a href="index.jsp">Guest</a>
            </div>

            <div class="left">
                <h4 style="color: brown">User mode </h4>
                <p>calculate cash</p>
                <p>calculate years</p>
                <p>calculate percentage</p>
                <p>calculate Npv</p>
                <p>Amortized loans</p>
                <a href="login.jsp"  >Login</a>
                <a href="homeregister.jsp"  >Register</a>
            </div>
        </div>



    </form>
</div>
</body>
</html>
