package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sponsor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idSpr;

    private String nomSpr;
    private String typeSpr;
    private String logoSpr;

    public String getIdSpr() {
        return idSpr;
    }

    public String getNomSpr() {
        return nomSpr;
    }

    public String getTypeSpr() {
        return typeSpr;
    }

    public String getLogoSpr() {
        return logoSpr;
    }
}
