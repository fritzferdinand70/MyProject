<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri ="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShipmentTypeRegister</title>
<script type="text/javascript">

</script> 
</head>
<body>
<h3>WELCOME TO SHIPMENT TYPE REGISTER</h3>
<form:form action="save" method = "post" modelAttribute="shipmentType" id="myForm">
<pre>
Shipment Mode :
<form:select path="shipMode">
<form:option value="">--select</form:option>
<form:option value="Air">Air</form:option>
<form:option value="Truck">Truck</form:option>
<form:option value="Ship">Ship</form:option>
<form:option value="Train">Train</form:option>
</form:select>
Shipment Code:
<form:input path="shipCode"/>
EnableShipment :
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
</pre>
<input type = "submit" value = "Create Shipment" onclick=""/>

</form:form>

${message }
</body>
</html>