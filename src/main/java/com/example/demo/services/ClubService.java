package com.example.demo.services;


import com.example.demo.entities.Affiliation;
import com.example.demo.entities.Club;
import com.example.demo.repositories.AffiliationRepository;
import com.example.demo.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ClubService {

    @Autowired
    ClubRepository clubRepository;

    public List<Club> showActivite() {
        return clubRepository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Club createClub(@RequestBody Club club){
        String msg;
        Club test = new Club("1", "UIR17", "INFORMER",
                Timestamp.valueOf("2021-06-23"), true, "UIR", "UIRimage");
        clubRepository.save(test);
        Club c = clubRepository.save(club);
        if (c == null) {
            msg = "Error de Creation de club";
        }
        return c;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Club getClubById(@PathVariable("id") String id){
        return clubRepository.getById(id);
    }


}
