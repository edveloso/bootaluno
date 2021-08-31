<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>



	<div id="principal" class="container">


		<div class="jumbotron">
			<h1>
				<i class="fa fa-bandcamp" aria-hidden="true"></i> Gestão de alunos
			</h1>
			<h3>Com springboot</h3>
		</div>

		<h2>Inscrição em turma</h2>


		<div class="card">
			<div class="card-header"></div>
			<div class="card-body">
				<h5 class="card-title">${aluno.nome }</h5>
				<p class="card-text">${aluno.email}</p>
			</div>
		</div>


		<p>
		<div class="row">
			<div class="col-sm-6">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Lista de cursos inscritos</h5>

						<table class="table table-striped">
							<tbody>
								<c:forEach var="turma" items="${aluno.turmas}">
									<tr>
										<td>${turma.codigo}</td>
										<td>${turma.nome}</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Lista de cursos a se inscrever</h5>


						<table class="table table-striped">
							<tbody>
								<c:forEach var="turma" items="${turmas}">
									<tr>
										<td>${turma.codigo}</td>
										<td>${turma.nome}</td>
										<td><a
											href='<c:url value="/aluno/salvarInscricao/${aluno.codigo}/${turma.codigo}" />'>
												<button class="btn btn-primary" type="button">Inscrever</button>
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>


					</div>
				</div>
			</div>
		</div>




		


	</div>





	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>

</body>
</html>