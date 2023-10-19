package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.time.LocalDate;

@Entity
@NamedQuery(name = "get_partite_vinte_in_casa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadra_di_casa=p.squadra_vincente")
@NamedQuery(name = "get_partite_vinte_in_trasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadra_ospite=p.squadra_vincente")
@NamedQuery(name = "get_partite_pareggiate", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadra_vincente=null")
public class PartitaDiCalcio extends Evento {

    @Column(nullable = false)
    private String squadra_di_casa;
    @Column(nullable = false)
    private String squadra_ospite;
    private String squadra_vincente;
    @Column(nullable = false)
    private int numero_gol_squadra_di_casa;
    @Column(nullable = false)
    private int numero_gol_squadra_ospite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, String squadra_di_casa, String squadra_ospite, String squadra_vincente, int numero_gol_squadra_di_casa, int numero_gol_squadra_ospite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.squadra_di_casa = squadra_di_casa;
        this.squadra_ospite = squadra_ospite;
        this.squadra_vincente = squadra_vincente;
        this.numero_gol_squadra_di_casa = numero_gol_squadra_di_casa;
        this.numero_gol_squadra_ospite = numero_gol_squadra_ospite;
    }


    public String getSquadra_di_casa() {
        return squadra_di_casa;
    }

    public void setSquadra_di_casa(String squadra_di_casa) {
        this.squadra_di_casa = squadra_di_casa;
    }

    public String getSquadra_ospite() {
        return squadra_ospite;
    }

    public void setSquadra_ospite(String squadra_ospite) {
        this.squadra_ospite = squadra_ospite;
    }

    public String getSquadra_vincente() {
        return squadra_vincente;
    }

    public void setSquadra_vincente(String squadra_vincente) {
        this.squadra_vincente = squadra_vincente;
    }

    public int getNumero_gol_squadra_di_casa() {
        return numero_gol_squadra_di_casa;
    }

    public void setNumero_gol_squadra_di_casa(int numero_gol_squadra_di_casa) {
        this.numero_gol_squadra_di_casa = numero_gol_squadra_di_casa;
    }

    public int getNumero_gol_squadra_ospite() {
        return numero_gol_squadra_ospite;
    }

    public void setNumero_gol_squadra_ospite(int numero_gol_squadra_ospite) {
        this.numero_gol_squadra_ospite = numero_gol_squadra_ospite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +

                ", squadra_di_casa='" + squadra_di_casa + '\'' +
                ", squadra_ospite='" + squadra_ospite + '\'' +
                ", squadra_vincente='" + squadra_vincente + '\'' +
                ", numero_gol_squadra_di_casa=" + numero_gol_squadra_di_casa +
                ", numero_gol_squadra_ospite=" + numero_gol_squadra_ospite +
                '}';
    }
}
