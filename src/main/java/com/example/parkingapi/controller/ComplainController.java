package com.example.parkingapi.controller;


import com.example.parkingapi.model.Complain;
import com.example.parkingapi.service.ComplainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/complains")
@RequiredArgsConstructor
public class ComplainController {
    private final ComplainService complainService;
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(complainService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Complain complain){
        return ResponseEntity.ok().body(complainService.add(complain));
    }

    @PatchMapping("/solved/{id}")
    public ResponseEntity<?> solve(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(complainService.solve(id));
    }

}
