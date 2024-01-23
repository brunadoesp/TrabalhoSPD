package Util;


import Modelo.Agenda;

import javax.persistence.EntityManager;
import java.util.List;

public class AgendaDAO {

    private EntityManager em;

    public AgendaDAO(EntityManager em){
        this.em = em;
    }

    public void incluir(Agenda age){
        this.em.persist(age);
    }

    public Agenda buscar (int id){
        return this.em.find(Agenda.class, id);
    }

    public void excluir(Agenda age){
        age = this.em.merge(age);
        this.em.remove(age);
    }

    public List<Agenda> buscaAgendas(){
        String jpql = "SELECT a FROM Agenda a";
        return em.createQuery(jpql, Agenda.class).getResultList();
    }
}