<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.candidate.candidate.Candidato" %>

<html>
<head>
    <title>Listar Candidatos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cinzel&display=swap" rel="stylesheet">
    <link href="reset.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
            margin: 0;
            background-color: #ECECEC;
        }

        .container-fluid {
            padding: 0;
        }

        .header {
            background-color: #ECECEC;
            padding: 10px;
        }

        .header h1, .header a {
            color: #AAABB8;
        }

        .content {
            margin: 20px 40px; /* Increased margin */
        }

        .link-adicionar:hover {
            color: #474787;
        }

        .link-listar {
            text-decoration: none;
            pointer-events: none;
        }

        .acoes {
            display: flex;
            gap: 10px;
        }

        .pencil {
            background-color: #474787;
            border-radius: 5px;
        }

        .pencil:hover {
            background-color: #2C2C54;
            transition: 500ms;
        }

        .pencil img {
            height: 30px;
            width: 30px;
        }

        .trash {
            background-color: #e50000;
            border-radius: 5px;
            padding-top: 2px;
            padding-bottom: 2px;
        }

        .trash:hover {
            background-color: #ad0101;
            transition: 500ms;
        }

        .trash img {
            height: 30px;
            width: 30px;
        }

        .btn-purple {
            background-color: #474787;
            border: none;
        }

        .btn-purple:hover {
            background-color: #2C2C54;
            transition: 500ms;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <!-- Add header here with background color -->
    <div class="d-flex justify-content-between align-items-center header">
        <h1 style="font-family: 'Cinzel', serif;"><a href="index.html" style="text-decoration: none">Carreira<span style="color: #474787">Express</span></a></h1>
        <div>
            <!-- Add your first link here -->
            <a href="adicionar-candidato.jsp" class="me-3 link-adicionar" style="text-decoration: none">Adicionar Candidato</a>
            <!-- Add your second link here -->
            <a href="listar-candidatos.jsp" class="link-listar">Listar Candidatos</a>
        </div>
    </div>
</div>

<div class="content">
    <h2 class="mt-3">Lista de Candidatos</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Código</th>
            <th scope="col">Nome</th>
            <th scope="col">Sexo</th>
            <th scope="col">Data de Nascimento</th>
            <th scope="col">Cargo Pretendido</th>
            <th scope="col">Texto do Currículo</th>
            <th scope="col">Ações</th>
        </tr>
        </thead>
        <tbody>
        <% for (Candidato candidato : (List<Candidato>)request.getAttribute("candidatos")) { %>
        <tr>
            <td><%= candidato.getCodigo() %></td>
            <td><%= candidato.getNome() %></td>
            <td><%= candidato.getSexo() %></td>
            <td><%= candidato.getDataNasc() %></td>
            <td><%= candidato.getCargoPretendido() %></td>
            <td><%= candidato.getTextoCurriculo() %></td>
            <td>
                <div class="acoes">
                    <div class="pencil">
                        <a href="editar-candidato.jsp?codigo=<%= candidato.getCodigo() %>"><img src="pencil.png"></a>
                    </div>
                    <div class="trash">
                        <a href="excluir-candidato?codigo=<%= candidato.getCodigo() %>"><img src="trash.png"></a>
                    </div>
                </div>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <br>
    <a href="index.html" class="btn btn-primary btn-purple">Voltar para o Menu</a>
</div>
</body>
</html>
