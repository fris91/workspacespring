<%@ include file="/jspf/head.jspf" %>
    
<div class="container">
  <div class="row">
	<h2 class="sub-header">Aggiungi Prodotto a Listino</h2>

	<form:form class="col-sm-4 col-sm-offset-4 pager" modelAttribute="prodottolistino" action="aggiungiListini" method="post">
		<form:hidden path="id.id_prodotto" value="${prodotto.id}"/>
		<div class="form-group">
			<label for="idname">Nome Prodotto</label>
			<input class="form-control" disabled id="idname" type="text" value="${prodotto.nome}"/>
		</div>
		
		<div class="form-group">
			<label for="idprezzo">Prezzo</label>
			<div class="input-group">
				<div class="input-group-addon">$</div>
				<form:input class="form-control" id="idprezzo" type="number" path="prezzo" placeholder="0.00"/>
				<div class="input-group-addon">.00</div>
			</div>
			<form:errors path="prezzo"></form:errors>
		</div>	
		
		<div class="form-group">	
			<label for="idsconto">Sconto</label>
			<form:select path="sconto.id" class="form-control" id="idsconto">
		   		<form:option value="-1" label="Sconto"/>
 				<form:options items="${sconti}" itemValue="id" itemLabel="nomeSconto"/>
			</form:select>
			<form:errors path="sconto"></form:errors>
		</div>
			
		<div class="form-group">	
			<label for="idlistino">Listino</label>
			<form:select path="id.id_listino" class="form-control" id="idlistino">
		   		<form:option value="-1" label="Listino"/>
 				<form:options items="${listini}" itemValue="id" itemLabel="nomeListino"/>
			</form:select>
			<form:errors path="listino"></form:errors>
		</div>
		
		<form:button class="col-sm-4 col-sm-offset-4 btn btn-primary" type="submit" name="btn">Inserimento</form:button>
		
	</form:form>
	
  </div>
  
  	<div class="row">
		<a href="visualizzaProdotti">
		    <button type="button" class="btn btn-default btn-sm">
			    <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
				Indietro
			</button>
		</a>	
	</div>
</div>

<%@  include file="/jspf/foot.jspf" %>