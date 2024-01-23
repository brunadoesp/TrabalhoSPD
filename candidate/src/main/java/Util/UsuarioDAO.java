package Util;

import Modelo.Alergia;
import Modelo.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDAO {

    private EntityManager em;

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }

    public void incluir(Usuario usu) {
        this.em.persist(usu);
    }

    public Usuario buscar(int id) {
        return this.em.find(Usuario.class, id);
    }

    public void excluir(Usuario usu){
        usu = this.em.merge(usu);
        this.em.remove(usu);
    }

    public List<Usuario> buscaUsuarios(){
        String jpql = "SELECT u FROM Usuario u";
        return em.createQuery(jpql, Usuario.class).getResultList();
    }
}