<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
IdInmueble          : ${inmueble.idInmueble}<br />
Direccion           : ${inmueble.direccion}<br />
Precio              : ${inmueble.precio}<br />
IdPropietario       : ${inmueble.propietario.idPropietario}<br />
Nombre Propietario  : ${inmueble.propietario.nombre}<br />
IdInquilino         : ${inmueble.inquilino.idInquilino}<br />
Nombre Inquilino    : ${inmueble.inquilino.nombre}<br />
</body>
</html>