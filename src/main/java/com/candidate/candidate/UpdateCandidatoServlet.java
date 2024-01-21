package com.candidate.candidate;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.sql.Date;

@WebServlet(name = "updateCandidatoServlet", value = "/atualizar-candidato")
public class UpdateCandidatoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        Candidato candidato = candidatoDAO.getCandidato(codigo);

        if (candidato != null) {
            request.setAttribute("candidato", candidato);
            request.getRequestDispatcher("/atualizar-candidato.jsp").forward(request, response);
        } else {
            response.sendRedirect("listar-candidatos");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obtenha os parâmetros do formulário e atualize o candidato no banco de dados
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        char sexo = request.getParameter("sexo").charAt(0);
        Date dataNasc = Date.valueOf(request.getParameter("dataNasc"));
        String cargoPretendido = request.getParameter("cargoPretendido");
        String textoCurriculo = request.getParameter("textoCurriculo");

        Candidato candidato = new Candidato();
        candidato.setCodigo(codigo);
        candidato.setNome(nome);
        candidato.setSexo(sexo);
        candidato.setDataNasc(dataNasc);
        candidato.setCargoPretendido(cargoPretendido);
        candidato.setTextoCurriculo(textoCurriculo);

        CandidatoDAO candidatoDAO = new CandidatoDAO();
        candidatoDAO.atualizarCandidato(candidato);

        response.sendRedirect("listar-candidatos");
    }
}
