<%@ include file="/jspf/head.jspf"%>

<div class="container">
	<div class="row">
		<h2 class="sub-header">Listini</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>FOTO</th>
						<th>NOME</th>
						<th>PREZZO</th>
						<th>SCONTO</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="prodottiListino" items="${prodottiListino}">
					<form:form modelAttribute="id" action="eliminaSingoloProdotto" method="post">
						<tr>
							<td><img style="width:60; height:60" src="immagini/${prodottiListino.prodotto.foto}" class="image-responsive" ></td>
							<td>${prodottiListino.prodotto.nome}</td>
							<c:choose>
								<c:when test="${prodottiListino.sconto.sconto!=0}">
							       	<td style="text-decoration:line-through">${prodottiListino.prezzo}</td>
									<td>${prodottiListino.prezzo*(prodottiListino.sconto.sconto)/100}</td>
								</c:when>
								<c:otherwise>
									<td>${prodottiListino.prezzo}</td>
									<td>-</td>
									</c:otherwise>
							</c:choose>
							<form:hidden path="id_prodotto" value="${prodottiListino.id.id_prodotto}"/>
							<form:hidden path="id_listino" value="${prodottiListino.id.id_listino}"/>
							<td><form:button type="submit" class="btn btn-primary">Rimuovi</form:button></td>
						</tr>
					</form:form>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="row">
		<a href="visualizzaListini">
			<button type="button" class="btn btn-default btn-sm">
				<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
				Indietro
			</button>
		</a>
	</div>
</div>

<%@  include file="/jspf/foot.jspf"%>