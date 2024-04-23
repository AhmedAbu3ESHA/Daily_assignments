<%--
  Created by IntelliJ IDEA.
  User: BM
  Date: 4/23/2024
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Action</th>
    </tr>

    </thead>
    <c:forEach items="${customersList}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>
                <c:url var="deleteCustomerLink" value="delete">
                    <c:param name="id">${customer.id}</c:param>
                </c:url>

                <a href="${deleteCustomerLink}">delete</a>


                |
        <c:url var="updateCustomerLink" value="update/${customer.id}">
            <c:param name="id">${customer.id}</c:param>
        </c:url>
                <a href="${updateCustomerLink}">update</a>

            </td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
