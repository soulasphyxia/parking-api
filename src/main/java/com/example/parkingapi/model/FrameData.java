package com.example.parkingapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrameData {
    private byte[] bytes;
    private String name;
    private String contentType;
    private Resource resource;
}
