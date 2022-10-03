<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Contato</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="main">
		<h4 class="text-center my-4">Alterar contato: ${contatos.nome}</h4>
		<div class="container d-flex justify-content-center flex-wrap mb-5">


			<form action="Alterar" method="post" class="form-control "
				style="width: 680px;">

				<input type="hidden" name="id" value="${contatos.id}">
				<fieldset>

					<div class="form-group mb-3 col-12">
						<label for="nome" class="form-label">Nome: </label> <input
							type="text" class="form-control" name="nome"
							value="${contatos.nome}">
					</div>
					<div class="row">
						<div class="form-group col-3">
							<label for="telefone" class="form-label">Telefone:</label> <input
								type="text" class="form-control" name="telefone"
								value="${contatos.telefone}">
						</div>

						<div class="form-group mb-3 col-9">
							<label for="email" class="form-label">Email: </label> <input
								type="text" class="form-control" name="email"
								value="${contatos.email}">
						</div>
					</div>
					<button type="submit" class="btn btn-outline-success">Atualizar</button>
				</fieldset>
			</form>
		</div>
	</div>

</body>
</html>