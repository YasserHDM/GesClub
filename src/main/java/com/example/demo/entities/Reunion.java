package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reunion {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idReu;

    private Date dateReu;
    private int nrbMembr;
    private String pv;

    public String getIdReu() {
        return idReu;
    }

    public Date getDateReu() {
        return dateReu;
    }

    public int getNrbMembr() {
        return nrbMembr;
    }

    public String getPv() {
        return pv;
    }
}
