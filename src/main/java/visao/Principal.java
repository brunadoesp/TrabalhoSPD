package visao;

import javax.persistence.EntityManager;
import util.AlergiaDAO;
import util.UsuarioAlergiaDAO;
import util.UsuarioDAO;
import util.JPAUtil;

import modelo.Alergia;
import modelo.Usuario;
import modelo.UsuarioAlergia;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Principal {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            persistirDados(em);
        } finally {
            em.close();
        }
    }

    private static void persistirDados(EntityManager em) {
        AlergiaDAO alergiaDAO = new AlergiaDAO(em);
        UsuarioDAO usuarioDAO = new UsuarioDAO(em);
        UsuarioAlergiaDAO usuarioAlergiaDAO = new UsuarioAlergiaDAO(em);

        // Criando algumas alergias
        Alergia alergia1 = new Alergia("Pólen");
        Alergia alergia2 = new Alergia("Penicilina");

        alergiaDAO.incluir(alergia1);
        alergiaDAO.incluir(alergia2);

        // Criando usuário
        Usuario usuario = new Usuario(
                "João da Silva",
                LocalDate.of(1980, 5, 15),
                'M',  // Agora representado por um caractere
                "Rua Principal, 123",
                123,
                "Centro",
                "Cidade A",
                "GO"
        );

        // Criando associações entre usuário e alergias
        Set<UsuarioAlergia> usuarioAlergias = new HashSet<>();
        usuarioAlergias.add(new UsuarioAlergia(usuario, alergia1));
        usuarioAlergias.add(new UsuarioAlergia(usuario, alergia2));

        usuario.setUsuarioAlergias(usuarioAlergias);

        // Persistindo usuário e associações
        em.getTransaction().begin();

        try {
            usuarioDAO.incluir(usuario);

            // Persiste as associações
            for (UsuarioAlergia usuarioAlergia : usuarioAlergias) {
                usuarioAlergiaDAO.incluir(usuarioAlergia);
            }

            em.getTransaction().commit();

            System.out.println("Usuário e associações persistidos com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao persistir dados: " + e.getMessage());
        }
    }
}