<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add customer form</title>
</head>
<body>

<form:form action="addCustomerSucsses" modelAttribute="theCustomer">

first name :<form:input path="firstName"/>
last name<form:input path="lastName"/>
email <form:input path="email"/>


<input type ="submit"  value="Add Customer">
</form:form >


</body>
</html>