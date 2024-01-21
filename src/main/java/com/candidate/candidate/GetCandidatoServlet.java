package com.candidate.candidate;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet(name = "getCandidatoServlet", value = "/obter-candidato")
public class GetCandidatoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        Candidato candidato = candidatoDAO.getCandidato(codigo);

        if (candidato != null) {
            request.setAttribute("candidato", candidato);
            request.getRequestDispatcher("/editar-candidato.jsp").forward(request, response);
        } else {
            response.sendRedirect("listar-candidatos");
        }
    }
}
