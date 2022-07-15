package com.tdev.projectx.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Embeddable
@Table(name = "reservation_club")
public class ReservationClub {

    @ManyToOne
    @JoinColumn(name = "userID", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "clubID", insertable = false, updatable = false)
    private Club club;

    @Column(name = "date", updatable = false)
    private LocalDate date;

}