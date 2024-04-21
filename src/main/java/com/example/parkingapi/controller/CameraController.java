package com.example.parkingapi.controller;

import com.example.parkingapi.dto.CameraDTO;
import com.example.parkingapi.service.CameraService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;

@RestController()
@RequestMapping(path = "/api/camera")
@RequiredArgsConstructor
public class CameraController {
    private final CameraService cameraService;

    @PostMapping()
    public ResponseEntity<?> getState(@RequestBody CameraDTO cameraDTO){
        cameraService.handleState(cameraDTO);
        return ResponseEntity.ok().body("213");
    }

    @PostMapping("/send-frame")
    public ResponseEntity<?> getFrame(@RequestParam("frame") MultipartFile frame) throws IOException {

        File file = new File(frame.getOriginalFilename());
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(frame.getBytes());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(
            value = "/frame.jpeg",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public ResponseEntity<?> getImageWithMediaType() throws IOException {
        File file = new File("frame.jpg");
        InputStream in = new FileInputStream(file);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(IOUtils.toByteArray(in));
    }


}
