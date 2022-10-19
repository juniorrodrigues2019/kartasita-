<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Import da taglib -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar de pessoa</title>
</head>
<body>
	${mensagem}
	<div class="container">
		<table id="table-1">
			<thead>
				<tr>
					<th>Descricao</th>
					<th>Ativo</th>
                    <th>acao</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sacolacategoria}" var="categoria">
					<tr>
						<td>${categoria.descricao}</td>
						<td>${categoria.ativo}</td>
						<td>
						</td>
						<td>
                            <a href="${s:mvcUrl('CC#editar').arg(0, categoria.id).build()}">Editar</a>
							<a href="${s:mvcUrl('CC#excluir').arg(0, categoria.id).build()}">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>