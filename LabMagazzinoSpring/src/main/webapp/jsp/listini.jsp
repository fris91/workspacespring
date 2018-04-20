<%@ include file="/jspf/head.jspf" %>
    
<div class="container">
  <div class="row">
    <h2 class="sub-header">Listini</h2>

	<div class="table-responsive">
		<table class="table table-striped">
		    <thead>
		        <tr>
		            <th>NOME</th>
                    <th>PERIODO</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
		    </thead>

			<c:forEach var="lis" items="${listini}">
				<tr>
					<td>${lis.nomeListino}</td>
					<td>${lis.formatDate()}</td>
					<td>
					    <a href="visualizzaSingoloListino?Id=${lis.id}">
					        Visualizza 
					        <span class="glyphicon glyphicon-search" aria-hidden="true"></span> 
					    </a>
					</td>
					<td>
					    <a href="modificaListini?Id=${lis.id}">
					        Modifica
					        <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 
					    </a>
					</td>
					<td>
					    <a href="eliminaListini?Id=${lis.id}">
					        Cancella 
					        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					    </a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

    <div class="row pager">
        <a href="inserimentoListini">
		    <button type="button" class="btn btn-basic btn-lg">
				Nuovo Listino
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
			</button> 
		</a>
    </div>

  </div>
</div>

<%@  include file="/jspf/foot.jspf" %>