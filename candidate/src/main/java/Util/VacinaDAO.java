package Util;

import Modelo.Vacina;

import javax.persistence.EntityManager;
import java.util.List;

public class VacinaDAO {

    private EntityManager em;

    public VacinaDAO(EntityManager em){
        this.em = em;
    }

    public void incluir(Vacina vac){
        this.em.persist(vac);
    }

    public Vacina buscar (int id){
        return this.em.find(Vacina.class, id);
    }

    public void excluir(Vacina vac){
        vac = this.em.merge(vac);
        this.em.remove(vac);
    }

    public List<Vacina> buscarVacinas(){
        String jpql = "SELECT v FROM Vacina v";
        return em.createQuery(jpql, Vacina.class).getResultList();
    }
}