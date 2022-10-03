<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda</title>
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

	<div class="container mt-5 mb-5">
		<h2 class="mb-3 text-center">Minha agenda	</h2>
		<a href="create.html" class="btn btn-info mb-2">
		            Novo Contato
		        </a>
			
			<div class="table-responsive-md">
				<table class="mt-3 table table-bordered align-middle text-center">
					<thead class="table-light">
						<tr>
							<th scope="col">Nome</th>
							<th scope="col">Telefone</th>
							<th scope="col">Email</th>
							<th scope="col">Ações</th>
						</tr>
					</thead>

					<tbody>
						<jstl:forEach items="${listaContatos}" var="contatos">
							<tr>
								<td>${contatos.nome}</td>
								<td>${contatos.telefone}</td>
								<td>${contatos.email}</td>
								
								<td class="p-2">
									<a href="Alterar?id=${contatos.id}" 
									class="btn btn-outline-info me-2">Editar</a> 
									<a href="Excluir?id=${contatos.id}"
									onclick="return confirm('Deseja Excluir?')"
									class="btn btn-outline-danger">Excluir</a>
								</td>
							</tr>
						</jstl:forEach>

					</tbody>
				</table>
			</div>
	</div>
</body>

</html>