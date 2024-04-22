<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form ">
<table border="1">

        <c:forEach items="${CustomerList}" var="d">
            <tr>
                <td> firstName : ${d.firstName} || lastName: ${d.lastName} || email: ${d.email} </td>
            </tr>
        </c:forEach>
        
    </table>
</form>
</body>
</html>