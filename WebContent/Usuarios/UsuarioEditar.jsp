<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/lumen/bootstrap.min.css" integrity="sha384-gv0oNvwnqzF6ULI9TVsSmnULNb3zasNysvWwfT/s4l8k5I+g6oFz9dye0wg3rQ2Q" crossorigin="anonymous">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Usuários</title>
	</head>
	<body>

		<div class="jumbotron"><h1>Cadastro de Usuário</h1></div>
		
		<div class="container">
			<form action="login.do" name="login" method="POST">
				<div class="row form-group">
					<div class="col-md-4"><label for="id">Usuário:</label></div>
					<div class="col-md-8"><input type="text" class="form-control" name="login" disabled value="${Usuario.login}"/></div>
				</div>
				
				<div class="row form-group">
					<div class="col-md-4"><label class="radio-inline"><input type="radio" name="acesso" value="gerente">Gerente</label></div>
					<div class="col-md-4"><label class="radio-inline"><input type="radio" name="acesso" value="vendedor">Vendedor</label></div>
					<div class="col-md-4"><label class="radio-inline"><input type="radio" name="acesso" value="estoque">Estoquista</label></div>
				</div>
				
				<div class="row">
					<div class="btn-group btn-group-justified">
						<div class="btn-group"><button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-floppy-disk"></span> Salvar</button></div>
						<div class="btn-group"><button class="btn btn-warning"><span class="glyphicon glyphicon-asterisk"></span> Reset de senha</button></div>
						<div class="btn-group"><button type="reset" class="btn btn-danger"><span class="glyphicon glyphicon-remove-sign"></span> Cancelar</button></div>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>