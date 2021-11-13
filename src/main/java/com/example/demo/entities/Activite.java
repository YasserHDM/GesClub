package com.example.demo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Activite {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idAct;

    private String nomAct;
    private Date debut;
    private Date fin;
    private boolean status;
    private String lieu;

    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;

    @OneToMany(mappedBy = "activite")
    private List<Facture> factures;

    public String getIdAct() { return idAct; }

    public String getNomAct() {
        return nomAct;
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }

    public boolean isStatus() {
        return status;
    }

    public String getLieu() {
        return lieu;
    }

    public Club getClub() {
        return club;
    }
}
