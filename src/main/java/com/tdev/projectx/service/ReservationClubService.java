package com.tdev.projectx.service;

import com.tdev.projectx.model.ReservationClub;

import java.util.List;

public interface ReservationClubService {

    ReservationClub getReservationByID(Long reservationClubID);

    ReservationClub addReservation(ReservationClub reservationClub);

    ReservationClub updateReservation(ReservationClub reservationClub);

    void deleteClub(Long reservationClubID);

    List<ReservationClub> getReservationClubByUser(Long user_id);

    List<ReservationClub> getReservationClubByClub(Long club_id);
}