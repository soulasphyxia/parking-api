package com.example.parkingapi.repository;

import com.example.parkingapi.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpotsRepository extends JpaRepository<Long, ParkingSpot> {
}
