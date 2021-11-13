package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Multimedia {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String idMult;

    private String url;

    public String getIdMult() {
        return idMult;
    }

    public String getUrl() {
        return url;
    }
}
