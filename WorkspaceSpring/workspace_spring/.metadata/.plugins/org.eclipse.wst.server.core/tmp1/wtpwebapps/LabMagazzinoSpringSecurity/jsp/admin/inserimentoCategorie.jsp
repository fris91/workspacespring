<%@ include file="/jspf/head.jspf"%>

<form:form  action="inserimentoCategorie" modelAttribute="categoria" method="post">
	Nome Categoria:<form:input type="text" path="nomeCategoria" placeholder="Categoria"/>
	<form:errors path="nomeCategoria"></form:errors><br><br>
<form:button type="submit" name="btn">Inserisci</form:button>
</form:form>

<%@  include file="/jspf/foot.jspf"%>