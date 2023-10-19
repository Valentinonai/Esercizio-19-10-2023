package org.example.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PartecipazioneDAO {


    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Partecipazione p) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(p);
            t.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Partecipazione getById(long id) {
        return em.find(Partecipazione.class, id);
    }

    public void delete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Partecipazione found = em.find(Partecipazione.class, id);
            if (found != null) {
                em.remove(found);
                t.commit();
                System.out.println("Elemento eliminato");
            } else System.out.println("Elemento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Partecipazione> partecipazioneDaConfermarePerEvento(Evento e) {
        TypedQuery<Partecipazione> q = em.createQuery("SELECT p FROM Partecipazione p WHERE p.stato='DA_CONFERMARE' AND p.evento=:e ", Partecipazione.class);
        q.setParameter("e", e);
        return q.getResultList();
    }

}


