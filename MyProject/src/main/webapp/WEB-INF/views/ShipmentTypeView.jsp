<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShipmentTypeView</title>
</head>
<body>
<h3>ShipmentTypeView</h3>

<pre> <a href="excel?id=${ob.shipId }">EXCEL</a>      <a href="pdf?id=${ob.shipId }">PDF</a></pre>
<table border  ="1">
<tr>
<th>ID</th><td>${ob.shipId}</td>
</tr>

<tr>
<th>MODE</th><td>${ob.shipMode}</td>
</tr>

<tr>
<th>CODE</th><td>${ob.shipCode}</td>
</tr>

<tr>
<th>ENABLE</th><td>${ob.enbShip}</td>
</tr>

<tr>
<th>Grade</th><td>${ob.shipGrade}</td>
</tr>

<tr>
<th>Description</th><td>${ob.shipDesc}</td>
</tr>

</table>
</body>
</html>