<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="cl.ulagos.electivo2.ping.boundary.*" %>
<%@ page import="cl.ulagos.electivo2.ping.entity.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creación de Fusibles</title>
</head>
<body>
	<%  try{
		
		CreaFusibles creaFusibles;
		javax.naming.InitialContext ctx = new javax.naming.InitialContext(); 
		creaFusibles = (CreaFusibles) ctx.lookup("java:app/electivo2/CreaFusibles");
		EspecificacionFusibles especificacionFusibles = new EspecificacionFusibles(Tamano.MEDIANO, Marca.F1);
		creaFusibles.creaFusibles(especificacionFusibles);
		creaFusibles.obtenerFusibles();
		
		//manufacturaAutomovil.inicializar();
	}catch (Exception e) {
		System.out.println("Problema:"+ e);
	} %>
</body>
</html>