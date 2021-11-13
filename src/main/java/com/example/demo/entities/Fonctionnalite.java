package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fonctionnalite {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idFonct;

    private String nomFonct;
    private String descFonct;

    public String getIdFonct() {
        return idFonct;
    }

    public String getNomFonct() {
        return nomFonct;
    }

    public String getDescFonct() {
        return descFonct;
    }
}
