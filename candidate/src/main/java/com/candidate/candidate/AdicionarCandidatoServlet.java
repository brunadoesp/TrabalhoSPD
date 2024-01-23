package com.candidate.candidate;

import java.io.*;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "adicionarCandidatoServlet", value = "/adicionar-candidato")
public class AdicionarCandidatoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/adicionar-candidato.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        char sexo = request.getParameter("sexo").charAt(0);
        Date dataNasc = Date.valueOf(request.getParameter("dataNasc"));
        String cargoPretendido = request.getParameter("cargoPretendido");
        String textoCurriculo = request.getParameter("textoCurriculo");

        Candidato candidato = new Candidato();
        candidato.setNome(nome);
        candidato.setSexo(sexo);
        candidato.setDataNasc(dataNasc);
        candidato.setCargoPretendido(cargoPretendido);
        candidato.setTextoCurriculo(textoCurriculo);

        CandidatoDAO candidatoDAO = new CandidatoDAO();
        candidatoDAO.adicionarCandidato(candidato);

        response.sendRedirect("listar-candidatos");
    }
}