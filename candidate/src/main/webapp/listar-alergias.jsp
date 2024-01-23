<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="Modelo.Alergia" %>
<%@ page import="Util.AlergiaDAO" %>
<%@ page import="Util.JPAUtil" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Alergias</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
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
            <a href="adicionar-alergia.jsp" class="me-3 link-adicionar" style="text-decoration: none">Adicionar Alergia</a>
            <!-- Add your second link here -->
            <a href="listar-alergias.jsp" class="link-listar">Listar Alergias</a>
        </div>
    </div>
</div>

<div class="content">
    <h2 class="mt-3">Lista de Alergias</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Código</th>
            <th scope="col">Nome</th>
            <th scope="col">Ações</th>
        </tr>
        </thead>
        <tbody>
        <%
            EntityManager em = JPAUtil.getEntityManager();
            AlergiaDAO alergiaDAO = new AlergiaDAO(em);
            List<Alergia> alergias = alergiaDAO.buscaAlergias();
            for (Alergia alergia : alergias) {
        %>
        <tr>
            <td><%= alergia.getId() %></td>
            <td><%= alergia.getNome() %></td>
            <td>
                <div class="acoes">
                    <div class="pencil">
                        <a href="editar-alergia.jsp?id=<%= alergia.getId() %>"><img src="pencil.png"></a>
                    </div>
                    <div class="trash">
                        <a href="adicionar-alergia?acao=excluir&id=<%= alergia.getId() %>"><img src="trash.png"></a>
                    </div>
                </div>
            </td>
        </tr>
        <%
            }
            em.close();
        %>
        </tbody>
    </table>
    <br>
    <a href="index.html" class="btn btn-primary btn-purple">Voltar para o Menu</a>
</div>
</body>
</html>
