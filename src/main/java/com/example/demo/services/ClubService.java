package com.example.demo.services;


import com.example.demo.entities.Affiliation;
import com.example.demo.entities.Club;
import com.example.demo.repositories.AffiliationRepository;
import com.example.demo.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    @Autowired
    ClubRepository clubRepository;

    public List<Club> showActivite() {
        return clubRepository.findAll();
    }

}
