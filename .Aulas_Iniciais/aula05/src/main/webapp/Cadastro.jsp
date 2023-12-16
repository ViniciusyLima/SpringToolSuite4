<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CADASTRO</title>
</head>
<link rel= stylesheet type= text/css href=Style.css>
<body>
<h2>Cadastro</h2>
	<div  class="texto">
	<form action="lista.jsp">
	<label>Nome:</label>
	<input type="text" name="nome" id="nome">
	<br>
	<label>Rua</label>
	<input type="text" name="rua" id="rua">
	<br>
	<label>Bairro</label>
	<input type="text" name="bairro" id="bairro">
	<br>
	<label>Estado</label>
	<input type="text" name="estado" id="estado">
	<br>
	<label>CEP</label>
	<input type="text" name="cep" id="cep">
	<br>
	<input type="submit" value="Enviar">
	<br>
	<input type="reset" value="Limpar">
	</form>
	</div>
</body>
</html>