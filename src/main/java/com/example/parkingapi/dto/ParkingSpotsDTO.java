package com.example.parkingapi.dto;


import com.example.parkingapi.model.ParkingSpot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotsDTO {
    private Integer level;
    private List<ParkingSpot> spots;
}
