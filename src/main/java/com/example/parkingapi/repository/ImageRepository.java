package com.example.parkingapi.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Repository
public class ImageRepository {
    public void save(MultipartFile file) throws IOException {
        URL url = this.getClass().getResource("/images");
        file.transferTo(new File(String.valueOf(url)));
    }

    public InputStream get(String filename){
        return getClass().getResourceAsStream("/images/"+filename);
    }

}
