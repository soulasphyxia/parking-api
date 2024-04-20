package com.example.parkingapi.controller;

import com.example.parkingapi.dto.ParkingDTO;
import com.example.parkingapi.service.ParkingSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/spots")
@CrossOrigin
@RequiredArgsConstructor
public class ParkingSpotController {
    private final ParkingSpotService spotService;


    @GetMapping()
    public ResponseEntity<?> getSpots(@RequestParam(required = false) Integer level,
                                      @RequestParam(required = false) Integer position){

        if(level == null && position == null){
            return ResponseEntity.ok().body(spotService.getAllSpots());
        }
        if(level != null && position == null){
            return ResponseEntity.ok().body(spotService.getSpotsByLevel(level));
        }
        if(level == null){
            return ResponseEntity.ok().body(spotService.getSpotsByPos(position));
        }
        return ResponseEntity.ok().body(spotService.getSpot(level,position));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSpot(@RequestParam Integer level,
                                     @RequestParam Integer position){
        return ResponseEntity.ok().body(spotService.addSpot(level,position));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSpot(@RequestParam Integer level,
                                        @RequestParam Integer position){
        return ResponseEntity.ok().body(spotService.deleteSpot(level,position));
    }

    @PatchMapping("/set")
    public ResponseEntity<?> setBusy(@RequestBody ParkingDTO parkingSpot){
        return ResponseEntity.ok().body(Map.of("message",spotService.setBusy(parkingSpot)));
    }

    @GetMapping("/levels")
    public ResponseEntity<?> getLevels(){
        return ResponseEntity.ok().body(Map.of("max_level",spotService.getLevels()));
    }

}
