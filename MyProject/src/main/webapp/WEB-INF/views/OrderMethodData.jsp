<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderMethod Data</title>
</head>
<body>
<h3>Welcome to OrderMethod Data</h3>
<pre><a href="excel">EXCEL</a>       <a href = "pdf">PDF</a></pre>
<c:choose>
<c:when test="${!empty list}">
<table border="2">
<tr>
<th>ID</th>
<th>MODE</th>
<th>CODE</th>
<th>TYPE</th>
<th>ACCEPT</th>
<th>DESCRIPTION</th>
<th colspan="3">OPERATION</th>
</tr>

<c:forEach items="${list }" var="om">
<tr>
<td>${om.orderId }</td>
<td>${om.orderMode }</td>
<td>${om.orderCode }</td>
<td>${om.orderType }</td>
<td>${om.orderAccept }</td>
<td>${om.orderDesc }</td>
<td><a href="view?id=${om.orderId }">VIEW</a></td>
<td><a href="delete?id=${om.orderId }">DELETE</a></td>
<td><a href="edit?id=${om.orderId }">EDIT</a></td>
</tr>
</c:forEach>

</table>
</c:when>

<c:otherwise>
<h3>No Data Found !!</h3>
</c:otherwise>
</c:choose>

${message }
</body>
</html>