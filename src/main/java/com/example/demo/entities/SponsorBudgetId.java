package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SponsorBudgetId implements Serializable {
    @Column(name = "idSponsor")
    String idSpr;

    @Column(name = "idActivite")
    String idAct;


}
