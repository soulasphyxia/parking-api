package com.example.parkingapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingDTO{
    @JsonProperty("userId")
    private Long userId;
    private Integer level;
    private Integer position;
    private Boolean isBusy;
}
