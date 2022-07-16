package com.tdev.projectx.controller;

import com.tdev.projectx.model.Club;
import com.tdev.projectx.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClubController {

    @Autowired
    private ClubService uService;

    @GetMapping("/clubs")
    public List<Club> getClubs() {
        return uService.getClubs();
    }

    @GetMapping("/club/{clubID}")
    public Club getClub(@PathVariable Long clubID) {
        return uService.getClubByID(clubID);
    }

    @PostMapping("/club")
    public Club addClub(@RequestBody Club club) {
        return uService.addClub(club);
    }

    @PutMapping("/club/{clubID}")
    public Club updateClub(@PathVariable Long clubID, @RequestBody Club club) {
        // System.out.println("Updating the club data for the id: " + id);
        club.setClubid(clubID);
        return uService.updateClub(club);
    }


    @DeleteMapping("/club")
    public String deleteClub(@RequestParam Long clubID) {
        uService.deleteClub(clubID);
        return "This club with id: " + clubID + " has been successfully deleted";
    }
}
