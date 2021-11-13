package com.example.demo.entities;

import javax.persistence.*;

@Entity
public class SponsorBudget {

    @EmbeddedId
    private SponsorBudgetId id;

    @ManyToOne
    @MapsId("idSpr")
    @JoinColumn(name = "idSponsor")
    Sponsor sponsor;

    @ManyToOne
    @MapsId("idAct")
    @JoinColumn(name = "idActivite")
    Activite activite;

    private double budget;
}
