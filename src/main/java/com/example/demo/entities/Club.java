package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idClub;

    private String nomClub;
    private String descClub;
    private Date dateCre;
    private boolean status;
    private String logo;
    private String coverImg;

    public String getIdClub() {
        return idClub;
    }

    public String getNomClub() {
        return nomClub;
    }

    public String getDescClub() {
        return descClub;
    }

    public Date getDateCre() {
        return dateCre;
    }

    public boolean isStatus() {
        return status;
    }

    public String getLogo() {
        return logo;
    }

    public String getCoverImg() {
        return coverImg;
    }
}
