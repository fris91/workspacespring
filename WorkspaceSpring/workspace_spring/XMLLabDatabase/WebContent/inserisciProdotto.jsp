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

	<form name="formNuovoProdotto" action="ioProdotti" method="post">

		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOME</th>
						<th>DESCRIZIONE</th>
						<th>CATEGORIA</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="prod" items="${prodotti}">
						<tr>
							<td>${prod.id}</td>
							<td>${prod.nome}</td>
							<td>${prod.descrizione}</td>
							<td>${prod.categoria.nomeCategoria}</td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td><input type="text" name="nome" placeholder="Nome"></input></td>
						<td><input type="text" name="desc" placeholder="Descrizione"></input></td>
						<td><select name="categoria">
								<option value="-1">Seleziona categoria</option>
								<c:forEach var="c" items="${cat}">

									<option value="${c.id}">${c.nomeCategoria}</option>

								</c:forEach>
						</select></td>
					</tr>
				</tbody>
			</table>
		</div>
		<button type="submit" name="btnVisualizzaProdotti"
			value="creaProdotto">Crea Prodotto</button>

	</form>
</body>
</html>