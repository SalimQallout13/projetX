package com.tdev.projectx.service.Impl;

import com.tdev.projectx.model.Club;
import com.tdev.projectx.model.ReservationClub;
import com.tdev.projectx.model.User;
import com.tdev.projectx.repo.ReservationClubRepository;
import com.tdev.projectx.service.ReservationClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class ReservationClubServiceImpl implements ReservationClubService {

    @Autowired
    private ReservationClubRepository reservationClubRepository;


    @Override
    public ReservationClub getReservationByID(Long reservationClubID) {
        Optional<ReservationClub> reservationClub = reservationClubRepository.findById(reservationClubID);
        if (reservationClub.isPresent()) {
            return reservationClub.get();
        }
        throw new RuntimeException("Club reservation not found for this id: " + reservationClubID);
    }

    @Override
    public ReservationClub addReservation(ReservationClub reservationClub) {
        return reservationClubRepository.save(reservationClub);
    }

    @Override
    public ReservationClub updateReservation(ReservationClub reservationClub) {
        return reservationClubRepository.save(reservationClub);
    }

    @Override
    public void deleteClub(Long reservationClubID) {
        reservationClubRepository.deleteById(reservationClubID);
    }

    @Override
    public List<ReservationClub> getReservationClubByUser(String name) {
        return reservationClubRepository.findByUserName(name);
    }

    @Override
    public List<ReservationClub> getReservationClubByClub(String name) {
        return reservationClubRepository.findByClubName(name);
    }
}
