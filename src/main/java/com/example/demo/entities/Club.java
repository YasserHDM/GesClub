package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "club")
public class Club {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
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

    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private List<Activite> activites;

    @ManyToOne
    @JoinColumn(name="affiliation_id")
    private Affiliation affiliation;

    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private List<Reunion> reunions;

    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private List<Poste> postes;

    @ManyToOne
    @JoinColumn(name="categorie_id")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name="referent_id")
    private Referent referent;

    @JsonIgnore
    @ManyToMany(mappedBy = "clubs")
    private List<Membre> membres;

    public Club() {

    }


    public Club(String idClub, String nomClub, String descClub, Date dateCre, boolean status, String logo, String coverImg, List<Activite> activites) {
        this.idClub = idClub;
        this.nomClub = nomClub;
        this.descClub = descClub;
        this.dateCre = dateCre;
        this.status = status;
        this.logo = logo;
        this.coverImg = coverImg;
        this.activites = activites;
    }

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

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public List<Reunion> getReunions() {
        return reunions;
    }

    public List<Poste> getPostes() {
        return postes;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Referent getReferent() {
        return referent;
    }

    public List<Membre> getMembres() {
        return membres;
    }
}
