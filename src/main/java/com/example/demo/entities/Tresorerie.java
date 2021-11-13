package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Tresorerie {
    @Id
    private String idTres;

    private Double budget;
    private Date annAca;

    public String getIdTres() {
        return idTres;
    }

    public Double getBudget() {
        return budget;
    }

    public Date getAnnAca() {
        return annAca;
    }
}
