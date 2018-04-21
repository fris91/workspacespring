<%@ include file="/jspf/head.jspf"%>

	<form action="registration" method="get" >
		<button class="btn btn-md btn-warning btn-block" type="Submit">Vai alla Pagina di Registrazione</button>
	</form>
	
	<div class="container">
		<form action="<%=request.getContextPath()%>/login" method="POST" class="form-signin">
			<h3 class="form-signin-heading">Benvenuto</h3>
			<br/>
			 
			<input type="text" id="email" name="email"  placeholder="Email"
				class="form-control" /> <br/> 
			<input type="password"  placeholder="Password"
				id="password" name="password" class="form-control" /> <br /> 
				<c:if test="${param.error}">
			<div align="center" >
				<p style="font-size: 20; color: #FF1C19;">Email or Password invalid, please verify</p>
			</div>
			</c:if>
			<button class="btn btn-lg btn-primary btn-block" name="Submit" value="home" type="Submit" value="Login">
				Accedi
			</button>
		</form>
	</div>

<%@  include file="/jspf/foot.jspf"%>