package com.example.parkingapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(schema = "public", name = "complains")

public class Complain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complain_id")
    private Long complainId;

    @Column(name="text")
    private String text;

    @Column(name = "timestamp")
    private Instant timestamp;

    @Column(name = "solved")
    private Boolean solved = false;
}
