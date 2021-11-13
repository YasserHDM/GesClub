package com.example.demo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idClub;

    private String nomClub;
    private String descClub;
    private Date dateCre;
    private boolean status;
    private String logo;
    private String coverImg;

    @OneToOne
    @JoinColumn(name = "tresorerie_id")
    private Tresorerie tresorerie;

    @OneToMany(mappedBy = "club")
    private List<Activite> activites;

    @ManyToOne
    @JoinColumn(name="affiliation_id")
    private Affiliation affiliation;

    @OneToMany(mappedBy = "club")
    private List<Reunion> reunions;

    @OneToMany(mappedBy = "club")
    private List<Poste> postes;

    @ManyToOne
    @JoinColumn(name="categorie_id")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name="referent_id")
    private Referent referent;

    public String getIdClub() {
        return idClub;
    }

    public String getNomClub() {
        return nomClub;
    }

    public String getDescClub() {
        return descClub;
    }

    public Date getDateCre() {
        return dateCre;
    }

    public boolean isStatus() {
        return status;
    }

    public String getLogo() {
        return logo;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public Tresorerie getTresorerie() {
        return tresorerie;
    }

    public List<Activite> getActivites() { return activites; }
}
