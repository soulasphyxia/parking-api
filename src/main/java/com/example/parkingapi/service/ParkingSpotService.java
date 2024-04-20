package com.example.parkingapi.service;


import com.example.parkingapi.dto.ParkingDTO;
import com.example.parkingapi.model.ParkingSpot;
import com.example.parkingapi.model.User;
import com.example.parkingapi.repository.ParkingSpotsRepository;
import com.example.parkingapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParkingSpotService {
    private final ParkingSpotsRepository spotsRepository;
    private final UserRepository userRepository;

    public List<ParkingSpot> getAllSpots() {
        List<ParkingSpot> all = spotsRepository.findAll();
        all.sort(Comparator.comparingInt(ParkingSpot::getLevel).thenComparingInt(ParkingSpot::getPosition));
        return all;
    }


    public Optional<ParkingSpot> getSpot(int level, int position){
        return spotsRepository.getParkingSpotByLevelAndPosition(level,position);
    }

    public List<ParkingSpot> getSpotsByLevel(int level){
        return spotsRepository.getParkingSpotsByLevelOrderByPosition(level);
    }

    public List<ParkingSpot> getSpotsByPos(int position){
        List<ParkingSpot> spots = spotsRepository.getParkingSpotsByPosition(position);
        spots.sort(Comparator.comparingInt(ParkingSpot::getPosition));
        return spots;
    }

    public String addSpot(int level, int position){
        ParkingSpot spot = new ParkingSpot();
        spot.setLevel(level);
        spot.setPosition(position);
        spot.setIsBusy(false);
        if(spotsRepository.getParkingSpotByLevelAndPosition(level, position).isPresent()){
            return "Это парковочное место уже добавлено.";
        }else{
            spotsRepository.save(spot);
            return "Парковочное место успешно добавлено.";
        }
    }

    public String deleteSpot(Integer level, Integer position) {
        Optional<ParkingSpot> spotOptional = spotsRepository.getParkingSpotByLevelAndPosition(level,position);
        if(spotOptional.isPresent()){
            spotsRepository.delete(spotOptional.get());
            return "Парковочное место успешно удалено.";
        }else{
            return "Такого парковочного места не существует.";
        }
    }
    /*
    * Место занято - пришло освободить -> освобождаем
    * Место занято - пришло занять -> занято
    * Место свободно - пришло освободить -> место не занято
    * Место свобоно - пришло занять -> место успешно занято
    *
    *
    * */
    public String setBusy(ParkingDTO parkingDTO){
        Optional<ParkingSpot> optionalSpot = spotsRepository.getParkingSpotByLevelAndPosition(parkingDTO.getLevel(), parkingDTO.getPosition());
        if(optionalSpot.isPresent()){
            ParkingSpot spot = optionalSpot.get();
            if(spot.getIsBusy() == parkingDTO.getIsBusy()){
                if(spot.getIsBusy()){
                    if(spot.getUser() == null){
                        spot.setUser(userRepository.findById(parkingDTO.getUserId()).get());
                        spotsRepository.save(spot);
                        return "Место перезаписано администратором";
                    }
                    return "Это место уже занято.";
                }else{
                    return "Это место не занято";
                }
            }else{
                // true => parking.dto == false
                if(spot.getIsBusy()){
                    //освобождение
                    spot.setIsBusy(parkingDTO.getIsBusy());
                    spotsRepository.save(spot);
                    return "Место успешно освобождено";
                }else{
                    User user = userRepository.findById(parkingDTO.getUserId()).get();
                    if(spotsRepository.getParkingSpotsByUser(user).isEmpty()){
                        spot.setIsBusy(parkingDTO.getIsBusy());
                        spot.setUser(user);
                        spotsRepository.save(spot);
                        return "Вы успешно заняли место.";
                    }else{
                        return "Вы уже заняли парковочное место";
                    }
                }

            }
        }else {
            return "Парковочного места не существует.";
        }

    }


    public int getLevels(){
        return spotsRepository.findFirstByOrderByLevelDesc().getLevel();
    }



}
