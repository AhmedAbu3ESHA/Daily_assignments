<%--
  Created by IntelliJ IDEA.
  User: BM
  Date: 4/21/2024
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet">
    <a href="${pageContext.request.contextPath}/resources/css/style.css"></a>
    <style type="text/css">
        .error{
            color: red;
        }
    </style>
</head>
<body>

<h1>Add Customer Form</h1>

<form:form action="${pageContext.request.contextPath}/customer/process-add-customer/" modelAttribute="theCustomer">
    <form:hidden path="id"/>

    First Name: <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/> <br>
    Last Name: <form:input path="lastName"/><br>
    Email: <form:input path="email"/><form:errors path="email" cssClass="error"/> <br>

    <input type="submit" value="add customer">

</form:form>

</body>
</html>
