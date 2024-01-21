package util;


import modelo.Agenda;

import javax.persistence.EntityManager;

public class AgendaDAO {

    private EntityManager em;

    public AgendaDAO(EntityManager em){
        this.em = em;
    }

    public void incluir(Agenda age){
        this.em.persist(age);
    }

    public Agenda buscar (long id){
        return this.em.find(Agenda.class, id);
    }

    public void excluir(Agenda age){
        age = this.em.merge(age);
        this.em.remove(age);
    }
}
