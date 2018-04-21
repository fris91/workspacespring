<%@ include file="/jspf/head.jspf"%>

<div class="container">
	<div class="row">
		<h2 class="sub-header">Categorie</h2>

		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>NOME CATEGORIA</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cat" items="${categorie}">
						<tr>
							<td>${cat.nomeCategoria}</td>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</div>

<%@  include file="/jspf/foot.jspf"%>