<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUserTypeEdit</title>
</head>
<body>
<h3>Welcome to WhUserType Edit Page</h3>
<pre>
<form:form action="update" method="post" modelAttribute="whUserType">
User ID :
<form:input path="whId" readonly="true"/>
User Type :
<form:radiobutton path="userType" value="Vendor"/>Vendor
<form:radiobutton path="userType" value="Customer"/>Customer
User Code :
<form:input path="userCode"/>
<!-- User For : -->
<%--<form:input path="userFor"/> --%>
User Email :
<form:input path="userEmail"/>
User Contact :
<form:input path="userContact"/>
User ID Type :
<form:select path="userIdType">
<form:option value=""/>--Select--
<form:option value="PANCARD"/>PANCARD
<form:option value="AADHAR"/>AADHAR
<form:option value="VOTER ID"/>VOTER ID
<form:option value="OTHER"/>OTHER
</form:select>
*If Other :
<form:input path="userIdTypeOther"/>
ID NUMBER :
<form:input path="userIdNumber"/>
<input type="submit" value="Update User">
</form:form>
</pre>
</body>
</html>