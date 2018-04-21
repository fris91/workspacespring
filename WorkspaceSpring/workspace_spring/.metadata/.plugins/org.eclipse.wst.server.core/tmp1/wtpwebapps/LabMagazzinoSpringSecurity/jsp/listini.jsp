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
				</tr>
			</c:forEach>
		</table>
	</div>
  </div>
</div>

<%@  include file="/jspf/foot.jspf" %>