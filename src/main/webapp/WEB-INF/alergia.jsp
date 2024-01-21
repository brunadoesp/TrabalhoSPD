<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Alergias</title>
</head>
<body>

<h2>Cadastro de Alergias</h2>

<%-- Formulário para cadastro de alergias --%>
<form action="CadastrarAlergiaServlet" method="post">
    <label for="nome">Nome da Alergia:</label>
    <input type="text" id="nome" name="nome" required>
    <br>
    <input type="submit" value="Cadastrar">
</form>

</body>
</html>

