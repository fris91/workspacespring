<%@ include file="/jspf/head.jspf"%>

<div class="container">
	<h2 class="sub-header">Prodotti</h2>

	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>NOME</th>
					<th>DESCRIZIONE</th>
					<th>FOTO</th>
					<th>CATEGORIA</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="prod" items="${prodotti}">
					<tr>
						<td>${prod.nome}</td>
						<td>${prod.descrizione}</td>
						<td>${prod.foto}</td>
						<td>${prod.categoria.nomeCategoria}</td>
						<td><a href="modificaProdotti?id=${prod.id}">Modifica <span
								class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
						<td><a href="eliminaProdotti?id=${prod.id}">Cancella <span
								class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
						<td><a href="aggiungiListini?Id=${prod.id}">Aggiungi a
								listino<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
						</a></td>
					</tr>
				</c:forEach>
		</table>
	</div>
	<div>
		<form action="navigazione" method="post" class="pager">
			<div class="form-group">
				<a href="inserimentoProdotti">
					<button type="button" class="btn btn-basic btn-lg">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
						Inserimento
					</button>
				</a>
				<nav aria-label="Page navigation" class="navigation-centered">
					<ul class="pagination">
						<li>
							<button class="btn btn-default glyphicon glyphicon-fast-backward"
								type="submit" name="btn" value="prima"></button>
						</li>
						<li>
							<button class="btn btn-default glyphicon glyphicon-chevron-left"
								type="submit" name="btn" value="prec"></button>
						</li>
						<li><select name="vis">
								<c:forEach var="num" items="${combo}">
									<c:choose>
										<c:when test="${num==selCombo}">
											<option value="${num}" selected>${num}</option>
										</c:when>
										<c:otherwise>
											<option value="${num}">${num}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></li>
						<li>
							<button class="btn btn-default" type="submit" name="btn"
								value="change">Visualizza</button>
						</li>
						<li>
							<button class="btn btn-default glyphicon glyphicon-chevron-right"
								type="submit" name="btn" value="succ"></button>
						</li>
						<li>
							<button class="btn btn-default glyphicon glyphicon-fast-forward"
								type="submit" name="btn" value="ultima"></button>
						</li>
					</ul>
				</nav>
			</div>
		</form>
	</div>
</div>

<%@  include file="/jspf/foot.jspf"%>