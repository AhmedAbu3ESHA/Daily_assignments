<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add customer form</title>
</head>
<style>
.center {
  margin-left: auto;
  margin-right: auto;
}
.blue-button{
    background: #25A6E1;
    filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
    padding:3px 5px;
    color:#fff;
    font-family:'Helvetica Neue',sans-serif;
    font-size:12px;
    border-radius:2px;
    -moz-border-radius:2px;
    -webkit-border-radius:4px;
    border:1px solid #1A87B9
}
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>
<body>

<form:form  modelAttribute="customer" action="/CustomerManagmentSystem/processaddcustomer">

Lirst name : <form:input    path="firstName" size="30" maxlength="30"/> <br> 
<br>
Fast name  : <form:input    path="lastName"  size="30" maxlength="30"/><br> 
<br>
Email      : <form:input    path="email"     size="30" maxlength="30"/><br>
<br>
<input type ="submit"  value="Add Customer"><br>
<br>
</form:form >

<form:form modelAttribute="customer" action="/CustomerManagmentSystem/processgetcustomer" >
<br>
<input type ="submit"  value="Show Customers"><br>
<br>
    <table class="center">
    <tr>
        <th width="120">   ID           </th>
        <th width="120">  First Name  </th>
        <th width="120">  Last Name   </th>
        <th width="120">  email       </th>
        <th width="120">   Edit         </th>
        <th width="120">   Delete       </th>
    </tr>
    <c:forEach var="customer" items="${CustomerList}" >
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
            <td><a href="<c:url value='/updateCustomer/${customer.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/deleteCustomer/${customer.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
   
    </form:form>
</body>
</html>