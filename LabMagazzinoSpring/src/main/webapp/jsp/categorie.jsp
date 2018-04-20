<%@ include file="/jspf/head.jspf" %>

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
						<td><a href="modificaCategorie?id=${cat.id}">
							Modifica 
							<span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
						</td>
						<td><a href="eliminaCategorie?id=${cat.id}">
							Cancella
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
						</td>
					</tr>
			    </c:forEach>
		    </table>
	    </div>
	</div>
    <div class="row pager">
	    <a href="inserimentoCategorie">
		    <button type="button" class="btn btn-basic btn-lg">
			    Nuova Categoria
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
			</button>
	    </a>
	</div>
</div>

<%@  include file="/jspf/foot.jspf" %>