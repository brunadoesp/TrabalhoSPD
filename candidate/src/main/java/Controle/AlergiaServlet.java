package Controle;

import Modelo.Alergia;
import Util.AlergiaDAO;
import Util.JPAUtil;

import javax.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "alergiaServlet", value = "/adicionar-alergia")
public class AlergiaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obter o nome da alergia a partir do formulário
        String nomeAlergia = request.getParameter("nomeAlergia");

        // Criar instância de Alergia com as informações fornecidas
        Alergia novaAlergia = new Alergia();
        novaAlergia.setNome(nomeAlergia);

        // Persistir a nova alergia no banco de dados usando JPA
        EntityManager em = JPAUtil.getEntityManager();
        AlergiaDAO alergiaDAO = new AlergiaDAO(em);


        em.getTransaction().begin();
        alergiaDAO.incluir(novaAlergia);
        em.getTransaction().commit();
        em.close();
        // Redirecionar para a página de sucesso
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
        AlergiaDAO alergiaDAO = new AlergiaDAO(em);
        Alergia a = alergiaDAO.buscar(id);
        em.getTransaction().begin();
        alergiaDAO.excluir(a);
        em.getTransaction().commit();
        em.close();
        response.sendRedirect("listar-alergias.jsp");
    }
}