package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Poste {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idPst;

    private String nomPst;
    private String descPst;
    private boolean status;
    private Date datePub;
    private int countUp;
    private int countDn;

    public String getIdPst() {
        return idPst;
    }

    public String getNomPst() {
        return nomPst;
    }

    public String getDescPst() {
        return descPst;
    }

    public boolean isStatus() {
        return status;
    }

    public Date getDatePub() {
        return datePub;
    }

    public int getCountUp() {
        return countUp;
    }

    public int getCountDn() {
        return countDn;
    }
}
