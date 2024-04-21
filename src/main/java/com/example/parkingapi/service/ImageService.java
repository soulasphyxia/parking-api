package com.example.parkingapi.service;

import com.example.parkingapi.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public void save(MultipartFile file) throws IOException {
        imageRepository.save(file);
    }

    public InputStream getFile(String filename){
        return imageRepository.get(filename);
    }

}
