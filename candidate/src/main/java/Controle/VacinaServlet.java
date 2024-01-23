package Controle;

import java.io.*;

import Modelo.Vacina;
import Util.JPAUtil;
import Util.VacinaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.persistence.EntityManager;

@WebServlet(name = "vacinaServlet", value = "/adicionar-vacina")
public class VacinaServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        String dosesString = request.getParameter("doses");
        int doses = Integer.parseInt(dosesString);
        String intervaloString = request.getParameter("intervalo");
        int intervalo = Integer.parseInt(intervaloString);
        String periodicidadeString = request.getParameter("periodicidade");
        int periodicidade = Integer.parseInt(periodicidadeString);

        Vacina vacina = new Vacina();
        vacina.setTitulo(titulo);
        vacina.setDescricao(descricao);
        vacina.setDoses(doses);
        vacina.setIntervalo(intervalo);
        vacina.setPeriodicidade(periodicidade);

        EntityManager em = JPAUtil.getEntityManager();
        VacinaDAO vacinaDAO = new VacinaDAO(em);

        em.getTransaction().begin();
        vacinaDAO.incluir(vacina);
        em.getTransaction().commit();
        em.close();

        response.sendRedirect("index.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoAcao = request.getParameter("acao");
        if (tipoAcao.equals("excluir")) {
            excluirAlergia(request, response);
        }
        //request.getRequestDispatcher("/adicionar-alergia.jsp").forward(request, response);
    }

    protected void excluirAlergia(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        EntityManager em = JPAUtil.getEntityManager();
        VacinaDAO vacinaDAO= new VacinaDAO(em);
        Vacina v = vacinaDAO.buscar(id);
        em.getTransaction().begin();
        vacinaDAO.excluir(v);
        em.getTransaction().commit();
        em.close();
        response.sendRedirect("listar-vacinas.jsp");
    }
}