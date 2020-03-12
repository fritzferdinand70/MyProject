<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UOM Edit</title>
</head>
<body>
<h3>Welcome to Uom Edit Page</h3>
<form:form action = "update" method="post" modelAttribute="uomOb">
<pre>
UOM ID:
<form:input path="uomId" readonly="true"/>
UOM TYPE:
<form:input path="uomType" />
UOM MODEL :
<form:input path = "uomModel"/>
DESCRIPTION :
<form:textarea path="uomDesc"/>
<input type = "submit" value = "Update"/>
</pre>
</form:form>
</body>
</html>