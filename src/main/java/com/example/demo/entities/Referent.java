package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Referent {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idRef;

    private String nomRef;
    private String prenRef;
    private boolean status;

    public String getIdRef() {
        return idRef;
    }

    public String getNomRef() {
        return nomRef;
    }

    public String getPrenRef() {
        return prenRef;
    }

    public boolean isStatus() {
        return status;
    }
}
