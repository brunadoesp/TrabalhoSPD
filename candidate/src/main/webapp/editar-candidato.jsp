<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.candidate.candidate.Candidato" %>
<%@ page import="com.candidate.candidate.CandidatoDAO" %>

<%
    String codigoParam = request.getParameter("codigo");
    int codigo = Integer.parseInt(codigoParam);

    CandidatoDAO candidatoDAO = new CandidatoDAO();
    Candidato candidato = candidatoDAO.getCandidato(codigo);

    request.setAttribute("codigo", candidato.getCodigo());
    request.setAttribute("nome", candidato.getNome());
    request.setAttribute("sexo", String.valueOf(candidato.getSexo()));
    request.setAttribute("dataNasc", candidato.getDataNasc());
    request.setAttribute("cargoPretendido", candidato.getCargoPretendido());
    request.setAttribute("textoCurriculo", candidato.getTextoCurriculo());
%>

<html lang="pt-br">
<head>
    <title>Editar Candidato</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cinzel&display=swap" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
    <link href="reset.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        .container-fluid {
            padding: 0;
        }

        .header {
            background-color: #ECECEC;
            padding: 10px;
        }

        .header h1, .header a {
            color: #AAABB8;
            text-decoration: none;
        }

        .link-adicionar {
            text-decoration: none;
        }

        .link-adicionar:hover {
            color: #474787;
        }

        .link-listar {
            text-decoration: none;
        }

        .link-listar:hover {
            color: #474787;
        }

        body {
            margin: 0;
            background-color: #ECECEC;
        }

        .container {
            margin-top: 3rem;
        }

        .form-label {
            font-weight: bold;
        }

        .btn-secondary {
            margin-left: 1rem;
        }

        .btn-purple {
            background-color: #474787;
            border: none;
        }

        .btn-purple:hover {
            background-color: #2C2C54;
        }

        .btn-cancelar {
            background-color: #e50000;
            border: none;
        }

        .btn-cancelar:hover {
            background-color: #ad0101;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <!-- Add header here with background color -->
    <div class="d-flex justify-content-between align-items-center header">
        <h1 style="font-family: 'Cinzel', serif;"><a href="index.html">Carreira<span style="color: #474787">Express</span></a></h1>
        <div>
            <!-- Add your first link here -->
            <a href="adicionar-candidato.jsp" class="me-3 link-adicionar">Adicionar Candidato</a>
            <!-- Add your second link here -->
            <a href="listar-candidatos.jsp" class="link-listar">Listar Candidatos</a>
        </div>
    </div>
</div>
<div class="container">
    <h2>Editar Candidato</h2>
    <form action="atualizar-candidato" method="post" class="form-group">
        <input type="hidden" name="codigo" value="<%= request.getAttribute("codigo") %>">
        <div class="mb-3">
            <label for="nome" class="form-label">Nome:</label>
            <input type="text" class="form-control" id="nome" name="nome" required placeholder="Digite seu nome completo" value="<%= request.getAttribute("nome") %>">
        </div>

        <div class="mb-3 d-flex">
            <div class="me-3 flex-grow-1">
                <label for="sexo" class="form-label">Sexo:</label>
                <select class="form-select" id="sexo" name="sexo" required>
                    <option value="M" <%= "M".equals(request.getAttribute("sexo")) ? "selected" : "" %>>Masculino</option>
                    <option value="F" <%= "F".equals(request.getAttribute("sexo")) ? "selected" : "" %>>Feminino</option>
                    <option value="0" <%= "0".equals(request.getAttribute("sexo")) ? "selected" : "" %>>Prefiro não informar</option>
                </select>
            </div>

            <div class="flex-grow-1">
                <label for="dataNasc" class="form-label">Data de Nascimento:</label>
                <input type="date" class="form-control" id="dataNasc" name="dataNasc" required value="<%= request.getAttribute("dataNasc") %>">
            </div>
        </div>

        <div class="mb-3">
            <label for="cargoPretendido" class="form-label">Cargo Pretendido:</label>
            <input type="text" class="form-control" id="cargoPretendido" name="cargoPretendido" required placeholder="Digite o cargo desejado" value="<%= request.getAttribute("cargoPretendido") %>">
        </div>

        <div class="mb-3">
            <label for="textoCurriculo" class="form-label">Texto do Currículo:</label>
            <textarea class="form-control" id="textoCurriculo" name="textoCurriculo" rows="4" required placeholder="Digite seu currículo"><%= request.getAttribute("textoCurriculo") %></textarea>
        </div>

        <button type="submit" class="btn btn-primary btn-purple">Salvar Edição</button>
        <a href="listar-candidatos" class="btn btn-secondary btn-cancelar">Cancelar</a>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
