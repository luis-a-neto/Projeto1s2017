<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuario</title>
</head>
<body>
	<div class="titulo">Login</div>

	<div class="corpo">
		<form action="login.do" name="login" method="POST">
			<div class="container">
				<span class="textlabel">Nome de usuário:</span> <span
					class="textinput"><input type="text" name="login" value=""
					accesskey="l" placeholder="Escreva seu nome de usuário" /></span>
			</div>

			<div class="container">
				<span class="textlabel">Senha:</span> <span class="textinput"><input
					type="password" name="senha" value="" accesskey="s"
					placeholder="Senha" /></span>
			</div>

			<div class="buttons">
				<input type="submit" value="Fazer login" /> <input type="reset"
					value="Limpar" />
				<div>
</body>
</html>