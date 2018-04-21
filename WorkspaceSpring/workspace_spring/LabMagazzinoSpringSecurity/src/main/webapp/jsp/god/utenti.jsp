<%@ include file="/jspf/head.jspf"%>

<div class="container">
	<h2 class="sub-header">Prodotti</h2>

	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>NOME</th>
					<th>COGNOME</th>
					<th>RUOLO</th>
					<th>EMAIL</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${utenti}">
					<tr>
						<td>${user.nome}</td>
						<td>${user.cognome}</td>
						<td>${user.ruolo.ruolo}</td>
						<td>${user.email}</td>
					</tr>
				</c:forEach>
		</table>
	</div>
</div>

<%@  include file="/jspf/foot.jspf"%>