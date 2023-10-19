package org.example.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventoDAO {

    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Evento evento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Evento getById(long id) {
        return em.find(Evento.class, id);
    }

    public void delete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Evento found = em.find(Evento.class, id);
            if (found != null) {
                em.remove(found);
                t.commit();
                System.out.println("Elemento eliminato");
            } else System.out.println("Elemento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void refresh(long id) {
        Evento found = em.find(Evento.class, id);

        found.setTitolo("Evento Prova");
        System.out.println(found);
        em.refresh(found);
        System.out.println(found);

    }


    public List<Concerto> getConcertiInStreaming() {
        List<Concerto> list = em.createNamedQuery("get_conceerti_in_streaming", Concerto.class).getResultList();
        return list;
    }

    public List<Concerto> getConcertiPerGenere(Genere g) {
        TypedQuery<Concerto> list = em.createQuery("SELECT c FROM Concerto c WHERE c.genere=:g", Concerto.class);
        list.setParameter("g", g);
        return list.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        return em.createNamedQuery("get_partite_vinte_in_casa", PartitaDiCalcio.class).getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        return em.createNamedQuery("get_partite_vinte_in_trasferta", PartitaDiCalcio.class).getResultList();
    }

    public List<PartitaDiCalcio> getPartitePareggiate() {
        return em.createNamedQuery("get_partite_pareggiate", PartitaDiCalcio.class).getResultList();
    }

    public List<GaraDiAtletica> getGarePerVincitore(Persona p) {

        System.out.println(p.getId());
        TypedQuery<GaraDiAtletica> lg = em.createNamedQuery("gara_per_nome", GaraDiAtletica.class);
        lg.setParameter("vincitore", p);
        return lg.getResultList();

    }

    public List<GaraDiAtletica> garaPerPartecipante(Persona p) {

        Query q = em.createNativeQuery("select* from gara_persona join gara_di_atletica on gara_di_atletica.id=gara_persona.gara_di_atletica join persone on persone.id=gara_persona.persone where persone=:p", GaraDiAtletica.class);
        q.setParameter("p", p.getId());
        return q.getResultList();
//        System.out.println(p.getId());
//        TypedQuery<GaraDiAtletica> q = em.createQuery("SELECT c FROM GaraDiAtletica c WHERE c.atleti.contains(:p)", GaraDiAtletica.class);
//
//        q.setParameter("p", p);

    }


}
