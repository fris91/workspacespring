<%@ include file="/jspf/head.jspf" %>

	<form:form modelAttribute="prodotto" action="eliminaProdotti" method="post">
		<form:hidden path="id"/>
		Nome Prodotto:<form:input type="text" path="nome" readonly="true"/><br><br>
		Categoria:	<form:select path="categoria.id" disabled="true">
						<form:option value="-1" label="Categoria"/>
 				  		<form:options items="${categoria}" itemValue="id" itemLabel="nomeCategoria"/>
					</form:select><br><br>
		Descrizione:<form:input type="text" path="descrizione" readonly="true"/><br><br>
		Foto:<form:input type="text" path="foto" readonly="true"/><br><br>
	<form:button type="submit">Elimina</form:button>
	</form:form><br>
	<div>
		<a href="index">Indietro</a>
	</div>

<%@  include file="/jspf/foot.jspf" %>