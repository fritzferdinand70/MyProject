<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderMethod Register</title>
</head>
<body>
<h3>Welcome to OrderMethod Register Page</h3>
<form:form action = "save" method="post" modelAttribute="orderMethod">
<pre>
Order Mode :
<form:radiobutton path="orderMode" value="Sale"/>Sale
<form:radiobutton path="orderMode" value="Purchase"/>Purchase
Order Code :
<form:input path="orderCode"/>
Order Type :
<form:select path="orderType">
<form:option value="">--Select--</form:option>
<form:option value="FIFO">FIFO</form:option>
<form:option value="LIFO">LIFO</form:option>
<form:option value="FMFO">FMFO</form:option>
<form:option value="FEFO">FEFO</form:option>
</form:select>
Order Accept :
<form:checkbox path="orderAccept" value="Multi-Model"/>Multi-Model
<form:checkbox path="orderAccept" value="Accept Return"/>Accept Return
Description :
<form:textarea path="orderDesc"/>
<input type="submit" value="CreateOrderMethod"/>
</pre>
</form:form>

${message}
</body>
</html>