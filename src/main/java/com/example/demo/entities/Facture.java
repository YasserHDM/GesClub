package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idFact;

    private String desti; // nom destinataire
    private Date dateFact;
    private double montant;
    private boolean status;

    public String getIdFact() {
        return idFact;
    }

    public String getDesti() {
        return desti;
    }

    public Date getDateFact() {
        return dateFact;
    }

    public double getMontant() {
        return montant;
    }

    public boolean isStatus() {
        return status;
    }
}
