package com.tdev.projectx.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @NotBlank(message = "Name should not be null")
    private String name;
    @NotBlank(message = "Email should not be null")
    @Email(message = "Please enter a valid email address")
    private String email;
    @NotBlank(message = "Password should not be null")
    private String password;

    @OneToMany
    @JoinTable(name = "reservation_club",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id"))
    private List<Club> clubs = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
