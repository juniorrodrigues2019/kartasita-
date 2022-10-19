<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Import da taglib -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar categoria</title>
</head>
<body>
	<div class="container">			
			<form:form action="${s:mvcUrl('CC#update').build()}" method="POST"
						modelAttribute="categoria" enctype="multipart/form-data">	
			<form:input type="hidden" path="id" value='${categoriaView.id}'/>			
			<div class="form-group">
				<label>descricao</label>
				<form:input path="descricao" value='${categoriaView.descricao}'/>
			</div>
			<div class="form-group">
				<label>ativo</label>
				<form:input path="ativo" value='${categoriaView.ativo}'/>
			</div>
			
			<button type="submit">Atualizar</button>
		</form:form>
	</div>
</body>
</html>