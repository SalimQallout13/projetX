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
        return new ResponseEntity<ReservationClub>(rcService.getReservationByID(reservationClubID), HttpStatus.FOUND);
    }

    @PostMapping("/reservationClub")
    public ResponseEntity<ReservationClub> addReservationClub(@Valid @RequestBody ReservationClub reservationClub) {
        Optional<User> userOptional = userRepository.findById(reservationClub.getUser().getUser_id());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            ReservationClub reservationClub1 = new ReservationClub();
            reservationClub1.setUser(user);

            return new ResponseEntity<ReservationClub>(rcService.addReservation(reservationClub1), HttpStatus.CREATED);
        }
        throw new RuntimeException("User not found for this id: " + reservationClub.getUser().getUser_id());
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
    public ResponseEntity<List<ReservationClub>> getReservationClubByUser(@RequestParam String name) {
        return new ResponseEntity<List<ReservationClub>>(rcService.getReservationClubByUser(name), HttpStatus.FOUND);
    }

    @GetMapping("/reservationClub/filterByClub")
    public ResponseEntity<List<ReservationClub>> getReservationClubByClub(@RequestParam String name) {
        return new ResponseEntity<List<ReservationClub>>(rcService.getReservationClubByClub(name), HttpStatus.FOUND);
    }

}
