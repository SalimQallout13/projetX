package com.tdev.projectx.model;

import com.tdev.projectx.request.ReservationClubRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "reservation_club")
public class ReservationClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_club_id", nullable = false)
    private Long reservationClub_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @NotNull(message = "Date must not be empty")
    @Column(name = "date", updatable = false)
    private Date date;
}