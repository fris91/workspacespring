<%@ include file="/jspf/head.jspf"%>

<form:form  action="eliminaListini" modelAttribute="listino" method="post">
	<form:hidden path="id"/>
	Nome listino:<form:input type="text" path="nomeListino" readonly="true"/><br><br>
	Data listino:<form:input type="date" path="data" readonly="true"/><br><br>
	<form:button type="submit" name="btn">Cancella</form:button>
</form:form>
<br>
<div>
	<a href="index">Indietro</a>
</div>

<%@  include file="/jspf/foot.jspf"%>