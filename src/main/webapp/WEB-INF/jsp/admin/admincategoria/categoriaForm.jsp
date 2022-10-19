<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Import da taglib -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/stylo.css"> 
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>cadastro de pessoa</title>

</head>
<body>

<nav>

	<ul>
	
		<li><a href="#">Início</a></li>
		<li><a href="#">Sobre</a></li>
		<li><a href="#">Serviços</a></li>
		<li><a href="#">contatos</a></li>
			
	</ul>

</nav>

	<input type="checkbox" id="check">
	<label for="check" class="checkbtn"></label>
	<i class="fas fa-bars"></i>

	<div class="container">
	<form:form action="${s:mvcUrl('CC#create').build()}" method="POST"
			modelAttribute="categoria" enctype="multipart/form-data">
			
			 <h3>Cadastre-se!</h3>
			
			<div class="form-group">
				<label>descrição</label>
				<form:input path="descricao" placeholder="Digite a descrição do livro" />
				<form:errors path="descricao"/>
			</div>
			
			<div class="form-group">
				<label>ativo</label>
				<form:input path="ativo" placeholder="Digite ativo" />
				<form:errors path="ativo"/>
			</div>
			
			
			
				
			
			
			
			<button type="submit">Cadastrar!</button>
	  </div>
			
			
			
		</form:form>
	</div>
</body>
</html>