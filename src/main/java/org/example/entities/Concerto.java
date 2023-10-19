package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NamedQuery(name = "get_conceerti_in_streaming", query = "SELECT c FROM Concerto c WHERE c.in_streaming=true")
public class Concerto extends Evento {


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genere genere;
    @Column(nullable = false)
    private boolean in_streaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Genere genere, boolean in_streaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.genere = genere;
        this.in_streaming = in_streaming;
    }


    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isIn_streaming() {
        return in_streaming;
    }

    public void setIn_streaming(boolean in_streaming) {
        this.in_streaming = in_streaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "id=" + getId() +
                ", genere=" + genere +
                ", in_streaming=" + in_streaming +
                '}';
    }
}
