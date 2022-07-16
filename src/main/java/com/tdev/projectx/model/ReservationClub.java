package com.tdev.projectx.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "reservation_club")
public class ReservationClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_club_id", nullable = false)
    private Long reservationClubID;

    @ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "clubid", insertable = false, updatable = false)
    private Club club;

    @Column(name = "date", updatable = false)
    private LocalDate date;

}