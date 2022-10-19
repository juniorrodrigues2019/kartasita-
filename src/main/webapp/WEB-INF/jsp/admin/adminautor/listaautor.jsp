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
					<th>nome</th>
					<th>Ativo</th>
                    <th>acao</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sacolaautor}" var="autor">
					<tr>
						<td>${autor.nome}</td>
						<td>${autor.ativo}</td>
						<td>
						</td>
						<td>
                            <a href="${s:mvcUrl('CA#editar').arg(0, autor.id).build()}">Editar</a>
							<a href="${s:mvcUrl('CA#excluir').arg(0, autor.id).build()}">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>