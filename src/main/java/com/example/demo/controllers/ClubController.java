package com.example.demo.controllers;

import com.example.demo.entities.Affiliation;
import com.example.demo.entities.Club;
import com.example.demo.services.AffiliationService;
import com.example.demo.services.ClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(path = "/api")
@CrossOrigin("*")  // just for testing in localhost || need to change for API deployment
public class ClubController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClubController.class);

    @Autowired
    ClubService clubService;


    @RequestMapping(path = "/club")
    @GetMapping
    public List<Club> getClubs(){
        return clubService.getClubs();
    }

    @RequestMapping(path = "/createClub")
    @PostMapping
    public Club createClub() {return clubService.createClub(null);}

    @RequestMapping(path = "/findClubId/{id}")
    @GetMapping
    public Club findClubById(@PathVariable("id") String id) {return clubService.getClubById(id);}

    @RequestMapping(path = "/findClubName/{name}")
    @GetMapping
    public Club findClubByName(@PathVariable("name") String name) {return clubService.getClubBynomClub(name);}

    @PostMapping(
            path = "{idClub}/image/upload",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void uploadImage(@PathVariable("idClub") String idClub,
                            @RequestParam("file") MultipartFile file) throws IOException {
        clubService.uploadImage(idClub, file);
    }
}
