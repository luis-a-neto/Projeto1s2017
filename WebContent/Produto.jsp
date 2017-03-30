<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Produtos</title>
		<link rel="stylesheet" href="stylesheet.css" type="text/css"/>
	</head>
	<body>

		<div class="titulo">Cadastro de Produto</div>
		
		<div class="corpo">
			<form action="login.do" name="login" method="POST">
				<div class="container">
					<span class="textlabel">Código do produto: </span>
					<span class="textinput">${Produto.id}</span>
				</div>
			
				<div class="container">
					<span class="textlabel">Nome do produto:</span>
					<span class="textinput"><input type="text" name="nome" value="${Produto.nome}" accesskey="n"/></span>
				</div>
					
				<div class="container">
					<span class="textlabel">Descrição:</span>
					<span class="textinput"><input type="text" name="descricao" value="${Produto.descricao}" accesskey="d"/></span>
				</div>
				
				<div class="container">
					<span class="textlabel">Preço de custo:</span>
					<span class="textinput"><input type="text" name="precoCusto" value="${Produto.precoCusto}" accesskey="c"/></span>
				</div>
				
				<div class="container">
					<span class="textlabel">Preço de venda:</span>
					<span class="textinput"><input type="text" name="precoVenda" value="${Produto.precoVenda}" accesskey="v"/></span>
				</div>
				
				<div class="container">
					<span class="textlabel">Quantidade em estoque: </span>
					<span class="textinput">${Produto.qtdEstoque}</span>
				</div>
			
				<div class="buttons">
					<input type="submit" value="Salvar" />
					<input type="reset" class="cancelar" value="Cancelar" />
				</div>
			</form>
		</div>
		
		<div class="footer">
			Grazielly Aquino do Nascimento - Luis Andrade Neto - Solange Carlos da Silva<br />
			Projeto de Refatoração - Programação de Sistemas Web - Prof. Bonato e Prof. Hamilton
		</div>
	
	</body>
</html>