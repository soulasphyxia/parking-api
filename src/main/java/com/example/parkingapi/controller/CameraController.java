package com.example.parkingapi.controller;

import com.example.parkingapi.dto.CameraDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/api/camera")

public class CameraController {
    @PostMapping()
    public ResponseEntity<?> getState(@RequestBody CameraDTO cameraDTO){
        System.out.println(cameraDTO);
        return ResponseEntity.ok().body(cameraDTO);
    }
}
