package org.example.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {


    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Persona p) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(p);
            t.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Persona getById(long id) {
        return em.find(Persona.class, id);
    }

    public void delete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Persona found = em.find(Persona.class, id);
            if (found != null) {
                em.remove(found);
                t.commit();
                System.out.println("Elemento eliminato");
            } else System.out.println("Elemento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}


