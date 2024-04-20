package com.example.parkingapi.controller;

import com.example.parkingapi.dto.CameraDTO;
import com.example.parkingapi.model.FrameData;
import com.example.parkingapi.service.CameraService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController()
@RequestMapping(path = "/api/camera")
@RequiredArgsConstructor
public class CameraController {
    private final CameraService cameraService;

    private FrameData lastFrame = null;

    @PostMapping()
    public ResponseEntity<?> getState(@RequestBody CameraDTO cameraDTO){
        cameraService.handleState(cameraDTO);
        return ResponseEntity.ok().body("213");
    }

    @PostMapping("/send-frame")
    public ResponseEntity<?> getFrame(@RequestParam("frame") MultipartFile frame) throws IOException {
        System.out.println(frame);
        lastFrame = new FrameData(frame.getBytes(), frame.getName(), frame.getContentType(),frame.getResource());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/frame")
    public ResponseEntity<?> getFrameData(){
        if(lastFrame != null){
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(lastFrame.getContentType()))
                    .body(lastFrame.getResource());
        }
        return ResponseEntity.ok().build();
    }


}
