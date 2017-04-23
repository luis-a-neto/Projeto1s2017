<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/lumen/bootstrap.min.css" integrity="sha384-gv0oNvwnqzF6ULI9TVsSmnULNb3zasNysvWwfT/s4l8k5I+g6oFz9dye0wg3rQ2Q" crossorigin="anonymous">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Pedido</title>
	</head>
	
	<body>
	
		<div class="jumbotron"><h1>Visualizar pedido</h1></div>
		
		<div class="container">
			
			<div class="table-responsive col-md-12">
				<table class="table table-striped">
					<thead>
						<tr>
						    <th>Descrição</th>
							<th>Quantidade</th>
							<th class="actions">Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty produtos}">
							<tr class="warning">
								<td colspan="3">
									Pedido vazio! Coloque pelo menos um produto.
								</td>
							</tr>
						</c:if>
						<c:forEach var="pv" items="${produtos}">
							<tr>
								<td>${pv.produto.descricao}</td>
								<td>${pv.qtde}</td>
								<td class="actions">
									<div class="btn-group">
										<a class="btn btn-danger btn-xs btn-group" href="deletar_produtoVenda?id=${pv.id}">Excluir</a>
									</div>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="2">Adicionar produto</td>
							<td class="actions">
								<div class="btn-group">
									<a class="btn btn-danger btn-xs btn-group" href="criar_produtoVenda?id=${venda.id}">Adicionar</a>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>