package com.example.parkingapi.repository;

import com.example.parkingapi.model.ParkingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<ParkingHistory, Long> {
}
