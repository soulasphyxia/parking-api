package com.example.parkingapi.service;


import com.example.parkingapi.dto.CameraDTO;
import com.example.parkingapi.dto.ParkingStateDTO;
import com.example.parkingapi.model.ParkingSpot;
import com.example.parkingapi.repository.ParkingSpotsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class CameraService {
    private final ParkingSpotsRepository spotsRepository;
    public void handleState(CameraDTO cameraDTO){
        int levels = cameraDTO.getState().size();
        for(int i = 0; i < levels; i++) {
            List<ParkingSpot> levelSpots = spotsRepository.getParkingSpotsByLevelOrderByPosition(i + 1);
            List<Integer> cameraSpots = cameraDTO.getState().get(i).getState();
            List<Integer> bdstate = levelSpots
                    .stream()
                    .mapToInt(x -> x.getIsBusy() == Boolean.FALSE ? 0 : 1)
                    .boxed()
                    .toList();
            for(int j = 0; j < cameraSpots.size(); j++){
                ParkingSpot spot = spotsRepository.getParkingSpotByLevelAndPosition(i + 1, j + 1).get();
                int camera = cameraSpots.get(j);
                if(camera != bdstate.get(j)){
                    spot.setIsBusy(camera != 0);
                    spotsRepository.save(spot);
                }
            }
        }
    }

    public void handleFrame(byte[] image){

    }


}
