package com.example.parkingapi.service;

import com.example.parkingapi.model.Complain;
import com.example.parkingapi.repository.ComplainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComplainService {
    private final ComplainRepository complainRepository;

    public List<Complain> getAll(){
        return complainRepository.findAll().stream().filter(x -> !x.getSolved()).toList();
    }

    public Complain add(Complain complain) {
        complain.setTimestamp(Instant.now());
        complainRepository.save(complain);
        return complain;
    }

    public Complain solve(Long id){
        Optional<Complain> optionalComplain = complainRepository.findById(id);
        if(optionalComplain.isPresent()){
            Complain  complain = optionalComplain.get();
            complain.setSolved(true);
            complainRepository.save(complain);
        }
        return null;
    }
}
