package com.tdev.projectx.controller;

import com.tdev.projectx.model.Club;
import com.tdev.projectx.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClubController {

    @Autowired
    private ClubService uService;

    @GetMapping("/clubs")
    public ResponseEntity<List<Club>> getClubs() {
        return new ResponseEntity<>(uService.getClubs(), HttpStatus.OK);
    }

    @GetMapping("/club/{clubID}")
    public ResponseEntity<Club> getClub(@PathVariable Long clubID) {
        return new ResponseEntity<>(uService.getClubByID(clubID), HttpStatus.FOUND);
    }

    @PostMapping("/club")
    public ResponseEntity<Club> addClub(@Valid @RequestBody Club club) {
        return new ResponseEntity<>(uService.addClub(club), HttpStatus.CREATED);
    }

    @PutMapping("/club/{clubID}")
    public ResponseEntity<Club> updateClub(@PathVariable Long clubID, @Valid @RequestBody Club club) {
        club.setClub_id(clubID);
        return new ResponseEntity<>(uService.updateClub(club), HttpStatus.OK);
    }


    @DeleteMapping("/club")
    public ResponseEntity<HttpStatus> deleteClub(@RequestParam Long clubID) {
        uService.deleteClub(clubID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/clubs/filterByName")
    public ResponseEntity<List<Club>> getClubByName(@RequestParam String name) {
        return new ResponseEntity<>(uService.getClubByName(name), HttpStatus.FOUND);
    }
}
