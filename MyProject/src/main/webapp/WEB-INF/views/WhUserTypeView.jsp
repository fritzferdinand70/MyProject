<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUserTypeView</title>
</head>
<h3>Welcome to WhUserTypeView</h3>
<body>
<pre><a href="excel?wid=${whOb.whId }">EXCEL</a>      <a href="pdf?wid=${whOb.whId }">PDF</a></pre>
<table border="2">
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
</tr>

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
</tr>
</table>

</body>
</html>