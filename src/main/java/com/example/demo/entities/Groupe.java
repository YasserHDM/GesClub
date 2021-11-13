package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Groupe {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idGrp;

    private String nomGrp;
    private int valGrp;
    private String descGrp;
    private boolean status;

    public String getIdGrp() {
        return idGrp;
    }

    public String getNomGrp() {
        return nomGrp;
    }

    public int getValGrp() {
        return valGrp;
    }

    public String getDescGrp() {
        return descGrp;
    }

    public boolean isStatus() {
        return status;
    }
}
