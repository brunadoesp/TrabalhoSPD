<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <title>Adicionar Vacina</title>
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
    </div>
</div>

<div class="container mt-3">
    <h2>Adicionar Vacina</h2>
    <form action="adicionar-vacina" method="post" class="form-group">
        <div class="mb-3">
            <label for="titulo" class="form-label">Nome:</label>
            <input type="text" class="form-control" id="titulo" name="titulo" required placeholder="Digite o nome da vacina">
        </div>

        <div class="mb-3">
            <label for="descricao" class="form-label">Descricao:</label>
            <textarea class="form-control" id="descricao" name="descricao" required placeholder="Digite a descrição da vacina"></textarea>
        </div>

        <div class="mb-3">
            <label for="doses" class="form-label">Doses:</label>
            <input type="number" class="form-control" id="doses" name="doses" required placeholder="Digite a quantidade de doses">
        </div>

        <div class="mb-3 d-flex">
            <div class="mb-3">
                <label for="intervalo" class="form-label">Intervalo:</label>
                <input type="number" class="form-control" id="intervalo" name="intervalo" required placeholder="Digite o intervalo entre as vacinas">
            </div>

            <div class="mb-3 d-flex">
                <div class="me-3 flex-grow-1">
                    <label for="periodicidade" class="form-label">Periodicidade:</label>
                    <select class="form-select" id="periodicidade" name="periodicidade" required>
                        <option value="1">Dia</option>
                        <option value="2">Semanas</option>
                        <option value="3">Meses</option>
                        <option value="4">Anos</option>
                    </select>
                </div>
            </div>
        </div>

        <button type="submit" class="btn btn-primary btn-purple">Adicionar Vacina</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
