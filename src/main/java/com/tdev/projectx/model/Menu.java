package com.tdev.projectx.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menu_id;
    @NotBlank(message = "Name must not be empty")
    @Column(length = 30)
    private String name;
    @NotBlank(message = "Whiskey must not be empty")
    @Column(length = 30)
    private String whiskey;
    @NotBlank(message = "Vodka must not be empty")
    @Column(length = 30)
    private String vodka;
    @NotBlank(message = "Champagne must not be empty")
    @Column(length = 30)
    private String champagne;
    @NotBlank(message = "Consommation must not be empty")
    @Column(length = 30)
    private String consommation;
    @Column(length = 30)
    private String entree;

    @ManyToOne()
    @JoinColumn(name = "club_id")
    private Club club;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

}
