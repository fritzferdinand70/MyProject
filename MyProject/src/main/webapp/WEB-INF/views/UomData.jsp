<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uom Data</title>
</head>
<body>
<h3>Welcome to Uom Data Page</h3>
<pre>
<a href="excel">EXCEL</a>			<a href="pdf">PDF</a>
<c:choose>
<c:when test="${!empty list }">
<table border="1">
<tr>
<th>UOM ID</th>
<th>UOM TYPE</th>
<th>UOM MODEL</th>
<th>DESC</th>
<th colspan = "3">OPERATIONS</th>
</tr>

<c:forEach items="${list}" var="ob">
<tr>
<td>${ob.uomId}</td>
<td>${ob.uomType}</td>
<td>${ob.uomModel}</td>
<td>${ob.uomDesc}</td>
<td><a href = "view?uid=${ob.uomId }">VIEW</a></td>
<td><a href="edit?uid=${ob.uomId }">EDIT</a></td>
<td><a href="delete?uid=${ob.uomId }">DELETE</a></td>
</tr>
</c:forEach>
</table>
</c:when>

<c:otherwise>
<h3>No Data found !!</h3>
</c:otherwise>
</c:choose>

${message }
</pre>


</body>
</html>