package com.example.parkingapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parking_history")
public class ParkingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "timestamp")
    Instant timestamp;
    @Column(name = "state")
    Integer state;
    @Column(name = "position")
    Integer position;
    @Column(name="level")
    Integer level;
}
