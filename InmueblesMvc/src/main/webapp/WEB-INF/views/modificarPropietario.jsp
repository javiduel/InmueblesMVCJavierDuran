<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 
	prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar los datos del Propietario</title>
</head>
<body>
Modificar los datos del propietario 
<br />
<br />	
	<form:form method="post" commandName="propietario">
		<form:hidden path="idPropietario"/>
		Nombre:<form:input path="nombre"/><br />
		DNI:<form:input path="dni"/><br />
		<input type="submit" value="Guardar" />
    </form:form>
</body>
</html>