package com.example.parkingapi.repository;

import com.example.parkingapi.model.ParkingSpot;
import com.example.parkingapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingSpotsRepository extends JpaRepository<ParkingSpot, Long> {
    Optional<ParkingSpot> getParkingSpotByLevelAndPosition(int level, int position);

    List<ParkingSpot> getParkingSpotsByLevel(int level);
    List<ParkingSpot> getParkingSpotsByPosition(int position);

    Optional<ParkingSpot> getParkingSpotsByUser(User user);

    ParkingSpot findFirstByOrderByLevelDesc();
}
