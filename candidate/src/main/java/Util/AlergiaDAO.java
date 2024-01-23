package Util;

import Modelo.Alergia;

import javax.persistence.EntityManager;
import java.util.List;

public class AlergiaDAO {

    private EntityManager em;

    public AlergiaDAO(EntityManager em) {
        this.em = em;
    }

    public void incluir(Alergia ale) {
        this.em.persist(ale);
    }

    public Alergia buscar(int id) {
        return this.em.find(Alergia.class, id);
    }

    public void excluir(Alergia ale){
        ale = this.em.merge(ale);
        this.em.remove(ale);
    }

    public List<Alergia> buscaAlergias(){
        String jpql = "SELECT a FROM Alergia a";
        return em.createQuery(jpql, Alergia.class).getResultList();
    }
}