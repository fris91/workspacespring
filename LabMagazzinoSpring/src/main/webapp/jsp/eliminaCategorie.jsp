<%@ include file="/jspf/head.jspf"%>

<form:form modelAttribute="categoria" action="eliminaCategorie" method="post">
	<form:hidden path="id"/>
	Nome Categoria:<form:input type="text" path="nomeCategoria" readonly="true"/><br><br>
	<form:button type="submit" name="btn">Elimina</form:button>
</form:form>
<br>
<div>
	<a href="index">Indietro</a>
</div>

<%@  include file="/jspf/foot.jspf"%>