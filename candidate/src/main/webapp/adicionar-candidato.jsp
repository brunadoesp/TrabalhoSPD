<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <title>Adicionar Candidato</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cinzel&display=swap" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
    <link href="reset.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        .link-listar:hover {
            color: #474787;
        }

        .link-adicionar {
            text-decoration: none;
            pointer-events: none;
        }

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
            text-decoration: none;
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
        <h1 style="font-family: 'Cinzel', serif;"><a href="index.html">Carreira<span style="color: #474787">Express</span></a></h1>
        <div>
            <!-- Add your first link here -->
            <a href="adicionar-candidato.jsp" class="me-3 link-adicionar" style="text-decoration: none">Adcionar Candidato</a>
            <!-- Add your second link here -->
            <a href="listar-candidatos.jsp" class="link-listar">Listar Candidatos</a>
        </div>
    </div>
</div>

<div class="container mt-3">
    <h2>Adicionar Novo Candidato</h2>
    <form action="adicionar-candidato" method="post" class="form-group">
        <div class="mb-3">
            <label for="nome" class="form-label">Nome:</label>
            <input type="text" class="form-control" id="nome" name="nome" required placeholder="Digite seu nome completo">
        </div>

        <div class="mb-3 d-flex">
            <div class="me-3 flex-grow-1">
                <label for="sexo" class="form-label">Sexo:</label>
                <select class="form-select" id="sexo" name="sexo" required>
                    <option value="M">Masculino</option>
                    <option value="F">Feminino</option>
                    <option value="0" SELECTED>Prefiro não informar</option>
                </select>
            </div>

            <div class="flex-grow-1">
                <label for="dataNasc" class="form-label">Data de Nascimento:</label>
                <input type="date" class="form-control" id="dataNasc" name="dataNasc" required>
            </div>
        </div>

        <div class="mb-3">
            <label for="cargoPretendido" class="form-label">Cargo Pretendido:</label>
            <input type="text" class="form-control" id="cargoPretendido" name="cargoPretendido" required placeholder="Digite o cargo desejado">
        </div>

        <div class="mb-3">
            <label for="textoCurriculo" class="form-label">Texto do Currículo:</label>
            <textarea class="form-control" id="textoCurriculo" name="textoCurriculo" rows="4" required placeholder="Digite seu currículo"></textarea>
        </div>

        <button type="submit" class="btn btn-primary btn-purple">Adicionar Candidato</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
