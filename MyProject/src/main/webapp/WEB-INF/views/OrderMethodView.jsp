<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderMethod View</title>
</head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>MODE</th>
<th>CODE</th>
<th>TYPE</th>
<th>ACCEPT</th>
<th>DESCRIPTION</th>
</tr>

<tr>
<td>${om.orderId }</td>
<td>${om.orderMode }</td>
<td>${om.orderCode }</td>
<td>${om.orderType }</td>
<td>${om.orderAccept }</td>
<td>${om.orderDesc }</td>
</tr>
</table>
</body>
</html>