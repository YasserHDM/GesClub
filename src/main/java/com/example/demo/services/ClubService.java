package com.example.demo.services;


import com.example.demo.filestore.FileStore;
import com.example.demo.bucket.BucketName;
import com.example.demo.entities.Club;
import com.example.demo.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
public class ClubService {

    private final FileStore fileStore;

    @Autowired
    ClubRepository clubRepository;

    public ClubService(FileStore fileStore) {
        this.fileStore = fileStore;
    }


    public void uploadImage(String idClub, MultipartFile file) throws IOException {
        if (file.isEmpty()){
            throw new IllegalStateException("Cannot upload empty file");
        }

        if (!Arrays.asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_WEBP.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("file must be an image");
        }

        //create metadata for the file
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        System.out.println(getClubs().get(0).getIdClub());
        System.out.println(idClub);
        //Check the club exist
        Club club = getClubs().stream().filter(clubfilter -> clubfilter.getIdClub().equals(idClub))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Club " + idClub + "doesn't exist"));

        //save the file in the ressource folder
        String path = String.format("%s/%s", BucketName.CLUB_IMAGE.getBucketName(), club.getIdClub());
        String fileName = String.format("%s/%s", file.getName(), UUID.randomUUID());
        try {
            fileStore.save(path, fileName, Optional.of(metadata), file.getInputStream());
            club.setLogo(fileName);
        } catch(IOException e) {
            throw new IllegalStateException(e);
        }
    }


    public byte[] downloadImage(String idClub) {
        Club club = getClubById(idClub);
        String path = String.format("%s/%s", BucketName.CLUB_IMAGE.getBucketName(), club.getIdClub());
        return club.getLogo()
                .map(key -> fileStore.download(path, key))
                .orElse(new byte[0]);

    }


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
