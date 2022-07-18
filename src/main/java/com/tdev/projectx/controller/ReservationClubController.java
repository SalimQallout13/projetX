package com.tdev.projectx.controller;

import com.tdev.projectx.model.Club;
import com.tdev.projectx.model.ReservationClub;
import com.tdev.projectx.model.User;
import com.tdev.projectx.repo.UserRepository;
import com.tdev.projectx.service.ReservationClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ReservationClubController {
    @Autowired
    private ReservationClubService rcService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/reservationClub/{reservationClubID}")
    public ResponseEntity<ReservationClub> getReservationClubByID(@PathVariable Long reservationClubID) {
        return new ResponseEntity<>(rcService.getReservationByID(reservationClubID), HttpStatus.FOUND);
    }

    @PostMapping("/reservationClub")
    public ResponseEntity<ReservationClub> addReservationClub(@Valid @RequestBody ReservationClub reservationClub) {
        return new ResponseEntity<>(rcService.addReservation(reservationClub), HttpStatus.CREATED);
    }

    @PutMapping("/reservationClub/{reservationClubID}")
    public ResponseEntity<ReservationClub> updateReservationClub(@PathVariable Long reservationClubID, @Valid @RequestBody ReservationClub reservationClub) {
        reservationClub.setReservationClub_id(reservationClubID);
        return new ResponseEntity<>(rcService.updateReservation(reservationClub), HttpStatus.OK);
    }

    @DeleteMapping("/reservationClub")
    public ResponseEntity<HttpStatus> deleteReservationClub(@RequestParam Long id) {
        rcService.deleteReservationClub(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/reservationClub/filterByUser")
    public ResponseEntity<List<ReservationClub>> getReservationClubByUser(@RequestParam String name) {
        return new ResponseEntity<>(rcService.getReservationClubByUser(name), HttpStatus.FOUND);
    }

    @GetMapping("/reservationClub/filterByClub")
    public ResponseEntity<List<ReservationClub>> getReservationClubByClub(@RequestParam String name) {
        return new ResponseEntity<>(rcService.getReservationClubByClub(name), HttpStatus.FOUND);
    }

}
