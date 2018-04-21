<%@ include file="/jspf/head.jspf"%>

	<form action="login" method="get" >
		<button class="btn btn-md btn-warning btn-block" type="Submit">Vai alla Pagina di Login</button>
	</form>	
	
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form:form autocomplete="off" action="registration"
					modelAttribute="utente" method="post" class="form-horizontal"
					role="form">
					<h2>Registrazione</h2>
					<div class="form-group">
						<div class="col-sm-9">
						<form:errors path="nome">
						</form:errors> 
						<form:input type="text" path="nome" placeholder="Name"
								class="form-control" /> 
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9">
						<form:errors path="cognome"/>
							<form:input type="text" path="cognome"
								placeholder="Last Name" class="form-control" /> 
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<form:input type="text" path="email" placeholder="Email"
								class="form-control" />
							<form:errors path="email" />	
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<form:input type="password" path="password"
								placeholder="Password" class="form-control" />
							<form:errors path="password"/>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9">
							<form:button type="submit" class="btn btn-primary btn-block">Register User</form:button>
						</div>
					</div>
					
					<span >${successMessage}</span>
					
					
				</form:form>
			</div>
		</div>
	</div>

<%@  include file="/jspf/foot.jspf"%>