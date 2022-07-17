package com.tdev.projectx.repo;

import com.tdev.projectx.model.Club;
import com.tdev.projectx.model.ReservationClub;
import com.tdev.projectx.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationClubRepository extends JpaRepository<ReservationClub, Long> {
    List<ReservationClub> findByUserName(String name);
    List<ReservationClub> findByClubName(String club);
}