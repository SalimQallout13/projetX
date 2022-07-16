package com.tdev.projectx.repo;

import com.tdev.projectx.model.ReservationClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationClubRepository extends JpaRepository<ReservationClub, Long> {}