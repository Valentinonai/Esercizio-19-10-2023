package org.example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    private long id;

    private String nome;
    private String citta;

    @OneToMany(mappedBy = "location")
    private List<Evento> lista_eventi;

    public Location() {
    }

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Evento> getLista_eventi() {
        return lista_eventi;
    }

    public void setLista_eventi(List<Evento> lista_eventi) {
        this.lista_eventi = lista_eventi;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                ", lista_eventi=" + lista_eventi +
                '}';
    }
}
