package com.tdev.projectx.controller;

import com.tdev.projectx.model.ReservationClub;
import com.tdev.projectx.repo.UserRepository;
import com.tdev.projectx.service.ReservationClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationClubController {
    @Autowired
    private ReservationClubService rcService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/reservationClub/{reservationClubID}")
    public ReservationClub getReservationClubByID(@PathVariable Long reservationClubID) {
        return rcService.getReservationByID(reservationClubID);
    }
    @PostMapping("/reservationClub")
    public ReservationClub addReservationClub(@RequestBody ReservationClub reservationClub) {
        return rcService.addReservation(reservationClub);
    }

    @PutMapping("/reservationClub/{reservationClubID}")
    public ReservationClub updateReservationClub(@PathVariable Long reservationClubID, @RequestBody ReservationClub reservationClub) {
        // System.out.println("Updating the club data for the id: " + id);
        reservationClub.setReservationClub_id(reservationClubID);
        return rcService.updateReservation(reservationClub);
    }


    @DeleteMapping("/reservationClub")
    public String deleteReservationClub(@RequestParam Long id) {
        rcService.deleteClub(id);
        return "This club's reservation with id: " + id + " has been successfully deleted";
    }
}
