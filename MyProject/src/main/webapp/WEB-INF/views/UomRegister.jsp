<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Uom</title>
</head>
<body>
<h3>Welcome to Uom Register Page</h3>

<form:form action="save" method="post" modelAttribute="uomOb">
<pre>
Uom Type :
<form:select path="uomType">
<form:option value="">--Select--</form:option>
<form:option value="packing">PACKING</form:option>
<form:option value="no-packing">NO-PACKING</form:option>
<form:option value="na">-NA-</form:option>
</form:select>
Uom Model :
<form:input path="uomModel"/>
Description :
<form:textarea path="uomDesc"/>
<input type= "submit" value ="Create Uom"/>
</pre>
</form:form>

${message }
</body>
</html>