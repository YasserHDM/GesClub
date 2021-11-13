package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Membre {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idMembre;

    private boolean status;
    private Date dateCon;
    private String pdpMembre;

    public String getIdMembre() {
        return idMembre;
    }

    public boolean isStatus() {
        return status;
    }

    public Date getDateCon() {
        return dateCon;
    }

    public String getPdpMembre() {
        return pdpMembre;
    }
}
