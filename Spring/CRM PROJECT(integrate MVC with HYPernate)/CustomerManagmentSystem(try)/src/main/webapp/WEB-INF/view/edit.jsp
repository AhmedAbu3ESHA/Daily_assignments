<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form  modelAttribute="theCustomer" action="${pageContext.request.contextPath}/processaddcustomer" method="post">

<form:hidden path ="id"/>
List name : <form:input    path="firstName" size="30" maxlength="30"/> <br> 
<br>
Fast name  : <form:input    path="lastName"  size="30" maxlength="30"/><br> 
<br>
Email      : <form:input    path="email"     size="30" maxlength="30"/><br>
<br>
<input type ="submit"  value="Add Customer"><br>
<br>
</form:form >


</body>
</html>