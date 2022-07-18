package com.tdev.projectx.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @NotBlank(message = "Name should not be null")
    @Column(length = 30)
    private String name;
    @NotBlank(message = "Email should not be null")
    @Email(message = "Please enter a valid email address")
    @Column(length = 30)
    private String email;
    @NotBlank(message = "Password should not be null")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<ReservationClub> reservationClubs;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;
}
