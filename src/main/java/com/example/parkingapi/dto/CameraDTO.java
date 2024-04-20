package com.example.parkingapi.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CameraDTO {
    @JsonProperty("parking_state")
    private List<ParkingStateDTO> state;
    @JsonProperty("time")
    private String datetime;
}
