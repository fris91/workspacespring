<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${prodotto!=null}">
			<span>***Prodotto***</span>
			<br>
			<span>Id: ${prodotto.id}</span>
			<br>
			<span>Nome: ${prodotto.nome}</span>
			<br>
			<span>Descrizione: ${prodotto.descrizione}</span>
			<br>
			<span>Prezzo: ${prodotto.prezzo}</span>
			<br>
			<span>*********</span>
			<br>
		</c:when>
		<c:otherwise>
			<c:forEach var="p" items="${prodotti}">
				<span>***Prodotto***</span>
				<br>
				<span>Id: ${p.id}</span>
				<br>
				<span>Nome: ${p.nome}</span>
				<br>
				<span>Descrizione: ${p.descrizione}</span>
				<br>
				<span>Prezzo: ${p.prezzo}</span>
				<br>
				<span>*********</span>
				<br>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	
	<br>
	<a href="index.jsp">Indietro</a>
	
</body>
</html>