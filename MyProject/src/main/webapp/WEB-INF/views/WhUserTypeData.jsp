<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUserTypeData</title>
</head>
<body>
	<h3>Welcome To WhUserTypeData</h3>
	<pre>
	<a href="excel">EXCEL</a>          <a href="pdf">PDF</a>
<c:choose>

<c:when test="${!empty list }">
<table border="3">
<tr>
<th>ID</th>
<th>TYPE</th>
<th>CODE</th>
<!-- <th>FOR</th> -->
<th>EMAIL</th>
<th>CONTACT</th>
<th>ID TYPE</th>
<th>IF OTHER</th>
<th>ID NUMBER</th>
<th colspan="3">OPERATIONS</th>

</tr>

<c:forEach items="${list}" var="whOb">

<tr>
<td>${whOb.whId }</td>
<td>${whOb.userType }</td>
<td>${whOb.userCode }</td>
<%--<td>${whOb.userFor}</td>  --%> 
<td>${whOb.userEmail }</td>
<td>${whOb.userContact }</td>
<td>${whOb.userIdType}</td>
<td>${whOb.userIdTypeOther }</td>
<td>${whOb.userIdNumber }</td>
<td><a href="view?wid=${ whOb.whId}">VIEW</a></td>
<td><a href="edit?wid=${whOb.whId }">EDIT</a></td>
<td><a href="delete?wid=${ whOb.whId}">DELETE</a></td>
</tr>

</c:forEach>
</table>
</c:when>

<c:otherwise>
<h3>No Data Found</h3>
</c:otherwise>

</c:choose>

</pre>

	${message }
</body>
</html>