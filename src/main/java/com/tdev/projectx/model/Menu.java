package com.tdev.projectx.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menu_id;
    @NotBlank(message = "Name must not be empty")
    private String name;
    @NotBlank(message = "Whiskey must not be empty")
    private String whiskey;
    @NotBlank(message = "Vodka must not be empty")
    private String vodka;
    @NotBlank(message = "Champagne must not be empty")
    private String champagne;
    @NotBlank(message = "Consommation must not be empty")
    private String consommation;
    private String entrée;

    @OneToOne
    @JoinColumn(name = "club_id")
    private Club club_id;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

}
