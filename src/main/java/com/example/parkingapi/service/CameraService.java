package com.example.parkingapi.service;


import com.example.parkingapi.repository.ParkingSpotsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CameraService {
    private final ParkingSpotsRepository spotsRepository;



}
