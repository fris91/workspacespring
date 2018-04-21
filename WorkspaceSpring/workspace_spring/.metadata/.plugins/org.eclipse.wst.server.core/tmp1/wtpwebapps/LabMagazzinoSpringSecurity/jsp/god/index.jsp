<%@ include file="/jspf/head.jspf"%>

<div class="container fluid">
	<div class="row text-center">
		<div class="btn-group-vertical col-sm-4" role="group" aria-label="...">
			<h2 class="sub-header">Home God</h2>
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation" class="active"><a
					href=${pageContext.request.contextPath}/admin/visualizzaProdotti>
						Prodotti </a></li>
				<li role="presentation" class="active"><a
					href=${pageContext.request.contextPath}/admin/visualizzaCategorie>
						Categorie </a></li>
				<li role="presentation" class="active"><a
					href=${pageContext.request.contextPath}/admin/visualizzaListini>
						Listini </a></li>
				<li role="presentation" class="active"><a
					href=${pageContext.request.contextPath}/god/visualizzaUtenti>
						Utenti </a></li>
			</ul>
		</div>
		<div class="col-sm-8">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="hardware-vector.jpg" alt="hardware"
							style="width: 100%; height: auto;" />
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="shoes-vector.jpg" alt="shoes"
							style="width: 100%; height: auto;" />
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="vector-balls.jpg" alt="balls"
							style="width: 100%; height: auto;" />
						<div class="carousel-caption"></div>
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="/jspf/foot.jspf"%>