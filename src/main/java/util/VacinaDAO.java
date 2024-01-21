package util;

import modelo.Vacina;

import javax.persistence.EntityManager;

public class VacinaDAO {

    private EntityManager em;

    public VacinaDAO(EntityManager em){
        this.em = em;
    }

    public void incluir(Vacina vac){
        this.em.persist(vac);
    }

    public Vacina buscar (long id){
        return this.em.find(Vacina.class, id);
    }

    public void excluir(Vacina vac){
        vac = this.em.merge(vac);
        this.em.remove(vac);
    }
}
