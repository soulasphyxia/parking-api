package com.example.parkingapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpot {
    private Long spotId;
    private Integer level;
    private Integer position;
    private Boolean isBusy;
    private Long userId;

}
