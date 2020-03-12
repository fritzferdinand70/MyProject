<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uom View</title>
</head>
<body>
<h3>Welcome to Uom View</h3>
<table border="2">
<tr>
<th>UOMID</th>
<th>UOMTYPE</th>
<th>UOMMODEL</th>
<th>DESCRIPTION</th>
</tr>
<tr>
<td>${ob.uomId}</td>
<td>${ob.uomType}</td>
<td>${ob.uomModel}</td>
<td>${ob.uomDesc}</td>
</tr>
</table>
</body>
</html>