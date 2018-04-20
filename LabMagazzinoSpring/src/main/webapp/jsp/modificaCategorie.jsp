<%@ include file="/jspf/head.jspf"%>

<form:form modelAttribute="categoria" action="modificaCategorie" method="post">
	<form:hidden path="id"/>
	Nome Categoria:<form:input type="text" path="nomeCategoria"/>
	<form:errors path="nomeCategoria"></form:errors><br><br>
	<form:button type="submit" name="btn">Modifica</form:button>
</form:form>
<br>
<div>
	<a href="index">Indietro</a>
</div>

<%@  include file="/jspf/foot.jspf"%>