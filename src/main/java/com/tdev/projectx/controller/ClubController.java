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
        return new ResponseEntity<List<Club>>(uService.getClubs(), HttpStatus.OK);
    }

    @GetMapping("/club/{clubID}")
    public ResponseEntity<Club> getClub(@PathVariable Long clubID) {
        return new ResponseEntity<Club>(uService.getClubByID(clubID), HttpStatus.FOUND);
    }

    @PostMapping("/club")
    public ResponseEntity<Club> addClub(@Valid @RequestBody Club club) {
        return new ResponseEntity<Club>(uService.addClub(club), HttpStatus.CREATED);
    }

    @PutMapping("/club/{clubID}")
    public ResponseEntity<Club> updateClub(@PathVariable Long clubID, @Valid @RequestBody Club club) {
        // System.out.println("Updating the club data for the id: " + id);
        club.setClub_id(clubID);
        return new ResponseEntity<Club>(uService.updateClub(club), HttpStatus.OK);
    }


    @DeleteMapping("/club")
    public ResponseEntity<HttpStatus> deleteClub(@RequestParam Long clubID) {
        uService.deleteClub(clubID);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
