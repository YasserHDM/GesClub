package com.example.demo.services;


import com.example.demo.entities.Affiliation;
import com.example.demo.entities.Club;
import com.example.demo.repositories.AffiliationRepository;
import com.example.demo.repositories.ClubRepository;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.http.HttpEntity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.apache.http.entity.ContentType.*;

@Service
public class ClubService {

    public void uploadImage(String idClub, MultipartFile file) throws IOException {
        if (file.isEmpty()){
            throw new IllegalStateException("Cannot upload empty file");
        }

        if (!Arrays.asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_WEBP.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("file must be an image");
        }

        //Check the cub exist
        Club club = getClubs().stream().filter(clubfilter -> clubfilter.getIdClub().equals(idClub))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Club " + idClub + "doesn't exist"));


        //save the file in the ressource folder

    }


    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Order")  // 404
    static public class OrderNotFoundException extends RuntimeException {
        // ...
    }
    @Autowired
    ClubRepository clubRepository;

    public List<Club> getClubs() {
        return clubRepository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Club createClub(@RequestBody Club club){
        String msg;
        Club test = new Club("1", "UIR17", "INFORMER",
                null, true, "UIR", "UIRimage", null);
        Club c = clubRepository.save(test);
        if (c == null) {
            msg = "Error de Creation de club";
        }
        return c;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Club getClubById(@PathVariable("id") String id){
        if (id == null)  return null;
        else return clubRepository.getById(id);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Club getClubBynomClub(@PathVariable("name") String name){
        if (name == null)  return null;
        else return clubRepository.getClubBynomClub(name);
    }

}
