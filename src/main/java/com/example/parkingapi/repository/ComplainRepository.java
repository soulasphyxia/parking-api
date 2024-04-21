package com.example.parkingapi.repository;

import com.example.parkingapi.model.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ComplainRepository extends JpaRepository<Complain, Long> {

}
