<%@ include file="/jspf/head.jspf" %>

	<form:form modelAttribute="prodotto" action="modificaProdotti" method="post">
		<form:hidden path="id"/>
		Nome Prodotto:<form:input type="text" path="nome" placeholder="Nome"/>
		<form:errors path="nome"></form:errors><br><br> 
		Categoria:	<form:select path="categoria.id">
						<form:option value="-1" label="Categoria"/>
 				  		<form:options items="${categoria}" itemValue="id" itemLabel="nomeCategoria"/>
					</form:select>
		<form:errors path="categoria"></form:errors><br><br>
		Descrizione:<form:input type="text" path="descrizione" placeholder="Descrizione"/>
		<form:errors path="descrizione"></form:errors><br><br>
		Foto:<form:input type="text" path="foto" placeholder="Foto"/>
		<form:errors path="foto"></form:errors><br><br>
		<form:button type="submit">Modifica</form:button>
	</form:form><br>

<%@  include file="/jspf/foot.jspf" %>