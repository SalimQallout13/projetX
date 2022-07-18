package com.tdev.projectx.service;

import com.tdev.projectx.model.Club;
import com.tdev.projectx.model.ReservationClub;
import com.tdev.projectx.model.User;

import java.util.Date;
import java.util.List;

public interface ReservationClubService {

    ReservationClub getReservationByID(Long reservationClubID);

    ReservationClub addReservation(ReservationClub reservationClub);

    ReservationClub updateReservation(ReservationClub reservationClub);

    void deleteReservationClub(Long reservationClubID);

    List<ReservationClub> getReservationClubByUser(String name);

    List<ReservationClub> getReservationClubByClub(String name);

}