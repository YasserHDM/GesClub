package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Affiliation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idAff;

    private String nomAff;
    private String DescAff;

    public String getIdAff() {
        return idAff;
    }

    public String getNomAff() {
        return nomAff;
    }

    public String getDescAff() {
        return DescAff;
    }
}
