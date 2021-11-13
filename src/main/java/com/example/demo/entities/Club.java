package com.example.demo.entities;

import org.apache.tomcat.jni.Address;

import javax.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "tresorerie_id")
    private Tresorerie tresorerie;

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

    public Tresorerie getTresorerie() {
        return tresorerie;
    }
}
