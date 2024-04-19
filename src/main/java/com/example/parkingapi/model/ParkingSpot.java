package com.example.parkingapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(schema = "public", name = "parking_spots")
public class ParkingSpot {
    @Id
    @Column(name = "spot_id")
    private Long spotId;

    @Column(name = "level")
    private Integer level;

    @Column(name = "position")
    private Integer position;

    @Column(name = "busy")
    private Boolean isBusy;

    @Column(name = "user_id")
    private Long userId;

}
