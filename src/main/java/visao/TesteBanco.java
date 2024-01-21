package visao;

import modelo.*;
import util.AlergiaDAO;
import util.JPAUtil;
import util.UsuarioDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TesteBanco {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        // Criação de instâncias do modelo
        Alergia alergia1 = new Alergia("Alergia1");
        Alergia alergia2 = new Alergia("Alergia2");

        List<Alergia> alergias = new ArrayList<>();
        alergias.add(alergia1);
        alergias.add(alergia2);

        Usuario usuario = new Usuario(
                "Nome do Usuário",
                LocalDate.of(1990, 1, 1),
                'F',
                "Rua Teste",
                123,
                "Setor Teste",
                "Cidade Teste",
                "UF",
                alergias
        );

        AlergiaDAO adao = new AlergiaDAO(em);

        UsuarioDAO udao= new UsuarioDAO(em);

        em.getTransaction().begin();
        adao.incluir(alergia1);
        adao.incluir(alergia2);
        udao.incluir(usuario);
        em.getTransaction().commit();

        // Configuração do EntityManager
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("vacinacao");
        //EntityManager em = emf.createEntityManager();

        // Início da transação
        //em.getTransaction().begin();

        //try {
            // Persiste o usuário e suas alergias
        //    em.persist(usuario);

            // Commit da transação
        //    em.getTransaction().commit();

        //    System.out.println("Usuário criado com sucesso!");
        //} catch (Exception e) {
            // Se ocorrer um erro, faz rollback da transação
       //     em.getTransaction().rollback();
        //    e.printStackTrace();
        //} finally {
            // Fecha o EntityManager
        //    em.close();
        //    emf.close();
        //}
    }
}