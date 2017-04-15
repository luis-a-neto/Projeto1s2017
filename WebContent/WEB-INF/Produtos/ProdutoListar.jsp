<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/lumen/bootstrap.min.css" integrity="sha384-gv0oNvwnqzF6ULI9TVsSmnULNb3zasNysvWwfT/s4l8k5I+g6oFz9dye0wg3rQ2Q" crossorigin="anonymous">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Produtos</title>
	</head>
	
	<body>
	
		<div class="jumbotron"><h1>Listagem de Produtos</h1></div>
		
		<div class="container">
			
			<div class="table-responsive col-md-12">
				<table class="table table-striped">
					<thead>
						<tr>
						    <th>Código</th>
							<th>Nome</th>
							<th>Descrição</th>
							<th>Preço de Custo</th>
							<th>Preço de Venda</th>
							<th class="actions">Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="produto" items="${produtos}">
							<tr>
								<td>${produto.id}</td>
								<td>${produto.nome}</td>
								<td>${produto.descricao}</td>
								<td>${produto.precoCusto}</td>
								<td>${produto.precoVenda}</td>
								<td class="actions">
									<div class="btn-group">
										<a class="btn btn-info btn-xs btn-group" href="editar_produto?id=${produto.id}">Editar</a>
										<a class="btn btn-danger btn-xs btn-group" href="deletar_produto?id=${produto.id}">Excluir</a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>