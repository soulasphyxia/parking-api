package com.example.parkingapi.service;

import com.example.parkingapi.model.User;
import com.example.parkingapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public Optional<User> userById(Long id) {
        return userRepository.findById(id);
    }
}
