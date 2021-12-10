package com.example.demo.repositories;


import com.example.demo.entities.Affiliation;
import com.example.demo.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, String> {


    Club getClubBynomClub(String id);
}
