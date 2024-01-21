package util;

import modelo.Usuario;

import javax.persistence.EntityManager;

public class UsuarioDAO {

    private EntityManager em;

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }

    public void incluir(Usuario usu) {
        this.em.persist(usu);
    }

    public Usuario buscar(long id) {
        return this.em.find(Usuario.class, id);
    }

    public void excluir(Usuario usu){
        usu = this.em.merge(usu);
        this.em.remove(usu);
    }
}