package com.example.demo.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
public class Activite {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idAct;

    private String nomAct;
    private Date debut;
    private Date fin;
    private boolean status;
    private String lieu;

    public String getIdAct() {
        return idAct;
    }

    public String getNomAct() {
        return nomAct;
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }

    public boolean isStatus() {
        return status;
    }

    public String getLieu() {
        return lieu;
    }
}
