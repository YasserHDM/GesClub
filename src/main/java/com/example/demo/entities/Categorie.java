package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idCate;

    private String nomCate;
    private String descCate;

    public String getIdCate() {
        return idCate;
    }

    public String getNomCate() {
        return nomCate;
    }

    public String getDescCate() {
        return descCate;
    }
}
