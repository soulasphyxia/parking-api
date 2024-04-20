package com.example.parkingapi.controller;


import com.example.parkingapi.model.User;
import com.example.parkingapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService userService;


    @GetMapping()
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok().body(userService.allUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        User user = userService.userById(id).orElseThrow();
        return ResponseEntity.ok().body(user);
    }





}
