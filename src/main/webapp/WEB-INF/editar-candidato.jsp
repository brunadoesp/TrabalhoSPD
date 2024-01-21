<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.candidate.candidate.Candidato" %>
<%@ page import="java.util.List" %>
<!-- Importe outros pacotes conforme necessário -->

<!-- ... Cabeçalho, estilos e scripts ... -->

<body>
<div class="container mt-4">
    <h2 class="text-center mb-4">Editar Candidato</h2>
    <form action="editar-candidato" method="post" class="row g-3">
        <%-- Campos do formulário preenchidos com informações do candidato --%>
        <div class="col-md-6">
            <label for="nome" class="form-label">Nome</label>
            <input type="text" name="nome" id="nome" class="form-control" value="<%= candidato.getNome() %>" required>
        </div>
        <!-- Adicione os outros campos do formulário preenchidos com informações do candidato -->

        <div class="col-md-12 text-center">
            <button type="submit" class="btn btn-primary">Salvar Alterações</button>
        </div>
    </form>
</div>
</body>
</html>
