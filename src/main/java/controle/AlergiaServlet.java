package controle;

import modelo.Alergia;
import util.AlergiaDAO;
import util.JPAUtil;

import javax.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AlergiaServlet")
public class AlergiaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obter o nome da alergia a partir do formulário
        String nomeAlergia = request.getParameter("nome");

        // Criar instância de Alergia com as informações fornecidas
        Alergia novaAlergia = new Alergia(nomeAlergia);

        // Persistir a nova alergia no banco de dados usando JPA
        EntityManager em = JPAUtil.getEntityManager();
        AlergiaDAO alergiaDAO = new AlergiaDAO(em);

        try {
            em.getTransaction().begin();
            alergiaDAO.incluir(novaAlergia);
            em.getTransaction().commit();

            // Redirecionar para a página de sucesso
            response.sendRedirect("sucesso.jsp");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            // Redirecionar para a página de erro
            response.sendRedirect("erro.jsp");
        } finally {
            // Fechar o EntityManager
            em.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Verificar o tipo de ação solicitada (buscar ou excluir)
        String acao = request.getParameter("acao");

        if (acao != null) {
            if (acao.equals("buscar")) {
                buscarAlergia(request, response);
            } else if (acao.equals("excluir")) {
                excluirAlergia(request, response);
            }
        } else {
            // Redirecionar para a página de erro
            response.sendRedirect("erro.jsp");
        }
    }

    private void buscarAlergia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obter o ID da alergia a ser buscada
        long idAlergia = Long.parseLong(request.getParameter("id"));

        // Buscar a alergia no banco de dados usando JPA
        EntityManager em = JPAUtil.getEntityManager();
        AlergiaDAO alergiaDAO = new AlergiaDAO(em);

        try {
            Alergia alergia = alergiaDAO.buscar(idAlergia);

            // Adicionar a alergia aos atributos da requisição
            request.setAttribute("alergia", alergia);

            // Encaminhar para a página de visualização da alergia
            request.getRequestDispatcher("visualizarAlergia.jsp").forward(request, response);
        } catch (Exception e) {
            // Redirecionar para a página de erro
            response.sendRedirect("erro.jsp");
        } finally {
            // Fechar o EntityManager
            em.close();
        }
    }

    private void excluirAlergia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obter o ID da alergia a ser excluída
        long idAlergia = Long.parseLong(request.getParameter("id"));

        // Excluir a alergia do banco de dados usando JPA
        EntityManager em = JPAUtil.getEntityManager();
        AlergiaDAO alergiaDAO = new AlergiaDAO(em);

        try {
            em.getTransaction().begin();
            Alergia alergia = alergiaDAO.buscar(idAlergia);

            if (alergia != null) {
                alergiaDAO.excluir(alergia);
                em.getTransaction().commit();

                // Redirecionar para a página de sucesso após a exclusão
                response.sendRedirect("sucesso.jsp");
            } else {
                // Redirecionar para a página de erro se a alergia não for encontrada
                response.sendRedirect("erro.jsp");
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            // Redirecionar para a página de erro
            response.sendRedirect("erro.jsp");
        } finally {
            // Fechar o EntityManager
            em.close();
        }
    }
}

