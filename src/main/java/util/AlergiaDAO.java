package util;

import modelo.Alergia;

import javax.persistence.EntityManager;

public class AlergiaDAO {

    private EntityManager em;

    public AlergiaDAO(EntityManager em) {
        this.em = em;
    }

    public void incluir(Alergia ale) {
        this.em.persist(ale);
    }

    public Alergia buscar(long id) {
        return this.em.find(Alergia.class, id);
    }

    public void excluir(Alergia ale){
        ale = this.em.merge(ale);
        this.em.remove(ale);
    }
}