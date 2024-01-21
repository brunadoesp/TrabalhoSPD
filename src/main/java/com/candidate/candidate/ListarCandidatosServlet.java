package com.candidate.candidate;

import java.io.*;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "listarCandidatosServlet", value = "/listar-candidatos")
public class ListarCandidatosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        List<Candidato> candidatos = candidatoDAO.listarCandidatos();

        request.setAttribute("candidatos", candidatos);

        request.getRequestDispatcher("/listar-candidatos.jsp").forward(request, response);
    }
}

