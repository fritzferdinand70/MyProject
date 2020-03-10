<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Documents</title>
</head>
<body>
<h3> WELCOME TO UPLOAD DOCUMENTS PAGE</h3>
<form action = "upload" method="post" enctype="multipart/form-data">
<pre>
ID  : <input type = "text" name="fileId"/>
Doc : <input type = "file" name="fileOb"/>
<input type = "submit" value = "upload">
</pre>

</form>
<table border = "1">
<tr>
<th>FILE ID</th>
<th>FILE NAME</th>
<th>LINK</th>
</tr>

<c:forEach items = "${list }" var = "ob">
<tr>

<td>${ob[0]}</td>
<td>${ob[1]}</td>
<td><a href = "download?fid=${ob[0]}">DOWNLOAD</a></td>
</tr>

</c:forEach>
</table>

${message}
</body>
</html>