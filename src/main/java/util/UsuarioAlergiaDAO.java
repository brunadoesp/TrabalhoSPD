package util;

import modelo.UsuarioAlergia;

import javax.persistence.EntityManager;

public class UsuarioAlergiaDAO {

    private EntityManager em;

    public UsuarioAlergiaDAO(EntityManager em) {
        this.em = em;
    }

    public void incluir(UsuarioAlergia usuarioAlergia) {
        this.em.persist(usuarioAlergia);
    }

    public UsuarioAlergia buscar(long id) {
        return this.em.find(UsuarioAlergia.class, id);
    }

    public void excluir(UsuarioAlergia usuAle){
        usuAle = this.em.merge(usuAle);
        this.em.remove(usuAle);
    }
}
