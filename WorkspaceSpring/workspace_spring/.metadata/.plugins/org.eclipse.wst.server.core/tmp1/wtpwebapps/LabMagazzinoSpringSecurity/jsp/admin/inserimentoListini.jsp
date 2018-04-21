<%@ include file="/jspf/head.jspf"%>

<form:form  action="inserimentoListini" modelAttribute="listino" method="post">
	Nome listino:<form:input type="text" path="nomeListino" placeholder="Listino"/>
	<form:errors path="nomeListino"></form:errors><br><br>
	Data listino:<form:input type="date" path="data" placeholder="yyyy-mm-dd"/>
	<form:errors path="data"></form:errors><br><br>
	<form:button type="submit" name="btn">Inserisci</form:button>
</form:form>

<%@  include file="/jspf/foot.jspf"%>