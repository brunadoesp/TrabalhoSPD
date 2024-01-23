package com.candidate.candidate;
import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "deleteCandidatoServlet", value = "/excluir-candidato")
public class DeleteCandidatoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        candidatoDAO.excluirCandidato(codigo);

        response.sendRedirect("listar-candidatos");
    }
}

