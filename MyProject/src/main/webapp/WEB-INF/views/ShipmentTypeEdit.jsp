<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditShipmentType</title>
</head>
<body>
<h3>ShipmentTypeEdit</h3>
<pre>
<form:form action= "update" method="post" modelAttribute="shipmentType">
Shipment Id :
<form:input path="shipId" readonly="true"/>
Shipment Mode :
<form:select path="shipMode">
<form:option value="">--select--</form:option>
<form:option value="Air">Air</form:option>
<form:option value="Truck">Truck</form:option>
<form:option value="Ship">Ship</form:option>
<form:option value="Train">Train</form:option>
</form:select>
Shipment Code :
<form:input path = "shipCode"/>
Enable Shipment :
<form:select path = "enbShip">
<form:option value="">--select--</form:option>
<form:option value="yes">yes</form:option>
<form:option value="no">no</form:option>
</form:select>
Shipment Grade :
<form:radiobutton path="shipGrade" value="A"/>A
<form:radiobutton path="shipGrade" value="B"/>B
<form:radiobutton path="shipGrade" value="C"/>C
Description :
<form:textarea path="shipDesc"/>
<input type = submit value = "update"/>
</form:form>
</pre>
</body>
</html>