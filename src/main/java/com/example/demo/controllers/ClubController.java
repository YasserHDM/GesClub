package com.example.demo.controllers;

import com.example.demo.entities.Affiliation;
import com.example.demo.entities.Club;
import com.example.demo.services.AffiliationService;
import com.example.demo.services.ClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "api/club")
public class ClubController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClubController.class);

    @Autowired
    ClubService clubService;

    @GetMapping
    public List<Club> showActivities(){
        return clubService.showActivite();
    }

}
