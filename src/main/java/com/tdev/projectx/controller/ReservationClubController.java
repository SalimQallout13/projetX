package com.tdev.projectx.controller;

import com.tdev.projectx.model.ReservationClub;
import com.tdev.projectx.service.ReservationClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReservationClubController {
    @Autowired
    private ReservationClubService rcService;

    @GetMapping("/reservationClub/{reservationClubID}")
    public ResponseEntity<ReservationClub> getReservationClubByID(@PathVariable Long reservationClubID) {
        return new ResponseEntity<ReservationClub>(rcService.getReservationByID(reservationClubID), HttpStatus.FOUND);
    }

    @PostMapping("/reservationClub")
    public ResponseEntity<ReservationClub> addReservationClub(@Valid @RequestBody ReservationClub reservationClub) {
        return new ResponseEntity<ReservationClub>(rcService.addReservation(reservationClub), HttpStatus.CREATED);
    }

    @PutMapping("/reservationClub/{reservationClubID}")
    public ResponseEntity<ReservationClub> updateReservationClub(@PathVariable Long reservationClubID, @Valid @RequestBody ReservationClub reservationClub) {
        // System.out.println("Updating the club data for the id: " + id);
        reservationClub.setReservationClub_id(reservationClubID);
        return new ResponseEntity<ReservationClub>(rcService.updateReservation(reservationClub), HttpStatus.OK);
    }

    @DeleteMapping("/reservationClub")
    public ResponseEntity<HttpStatus> deleteReservationClub(@RequestParam Long id) {
        rcService.deleteClub(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/reservationClub/filterByUser")
    public ResponseEntity<List<ReservationClub>> getReservationClubByUser(@PathVariable Long user_id) {
        return new ResponseEntity<List<ReservationClub>>(rcService.getReservationClubByUser(user_id), HttpStatus.FOUND);
    }

    @GetMapping("/reservationClub/filterByClub")
    public ResponseEntity<List<ReservationClub>> getReservationClubByClub(@PathVariable Long club_id) {
        return new ResponseEntity<List<ReservationClub>>(rcService.getReservationClubByClub(club_id), HttpStatus.FOUND);
    }

}
