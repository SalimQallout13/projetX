package com.tdev.projectx.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long club_id;
    @NotBlank(message = "Name must not be empty")
    @Column(length = 30)
    private String name;
    private String img;
    @NotBlank(message = "Address must not be empty")
    @Column(length = 50)
    private String address;
    @NotBlank(message = "Hours must not be empty")
    private String hours;
    @NotNull(message = "Entry price must not be empty")
    private Float entryPrice;
    @NotBlank(message = "Description must not be empty")
    private String description;

    @OneToMany(mappedBy = "club")
    private List<ReservationClub> reservationClubs;

    @OneToMany(mappedBy = "club")
    private List<Menu> menu;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;
}
