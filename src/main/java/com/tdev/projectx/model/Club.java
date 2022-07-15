package com.tdev.projectx.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubID;
    private String name;
    private String img;
    private String address;
    private String hours;
    private float entryPrice;
    private String description;

    @ManyToMany
    @JoinTable(name = "reservation_club",
            joinColumns = @JoinColumn( name = "clubID"),
            inverseJoinColumns = @JoinColumn( name = "userID")
    )
    private List<User> users = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

}
