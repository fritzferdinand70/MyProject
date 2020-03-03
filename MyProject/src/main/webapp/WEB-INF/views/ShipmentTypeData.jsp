<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix = "cc" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShipmentTypeData</title>
</head>
<body>
<h3>Welcome to Shipment Type Data</h3>
<c:choose>
<c:when test="${!empty list }">
<table border = "1">
<tr>
<th>ID</th>
<th>MODE</th>
<th>CODE</th>
<th>ENABLE</th>
<th>GRADE</th>
<th>DESC</th>
<th colspan="3">OPERATION</th>
</tr>

<c:forEach items="${list}" var="ob">
<tr>
<td>${ob.shipId}</td>
<td>${ob.shipMode}</td>
<td>${ob.shipCode}</td>
<td>${ob.enbShip}</td>
<td>${ob.shipGrade}</td>
<td>${ob.shipDesc}</td>
<td><a href = "edit?sid=${ob.shipId }">EDIT</a></td>
<td><a href = "delete?sid=${ob.shipId }">DELETE</a></td>
<td><a href = "view?sid=${ob.shipId }">VIEW</a></td>
<td></td>
</tr>
</c:forEach>
</table>
</c:when>

<c:otherwise>
<h3>NO DATA FOUND !!</h3>
</c:otherwise>
</c:choose>

${message}
</body>
</html>