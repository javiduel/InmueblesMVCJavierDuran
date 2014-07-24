<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Datos del inmueble<br />
	<form:form method="post" commandName="inmueble">
		Direccion:<form:input path="direccion"/><br />
		Precio:<form:input path="precio"/><br />
		IdPropietario: <form:select path="idPropietario">
			<form:options items="${propietario}"/>
		</form:select>
		<br />
		IdInquilino: <form:select path="idInquilino">
			<form:options items="${inquilino}"/>
		</form:select>
		<br />
	<input type="submit" value="Guardar" />

	</form:form>


</body>
</html>