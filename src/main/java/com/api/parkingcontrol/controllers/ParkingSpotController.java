package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.Dtos.ParkingSpotDTO;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

/*
    Tem por função controlar as requisições HTTP, fornecer e retornar informações ao usuário quando o usuário pedir
 */


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    final ParkingSpotServiceImpl parkingSpotServiceImpl;

    public ParkingSpotController(ParkingSpotServiceImpl parkingSpotServiceImpl) {
        this.parkingSpotServiceImpl = parkingSpotServiceImpl;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingSpotModel saveParkingSpot(@RequestBody @Valid ParkingSpotDTO request) {
        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(request, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return parkingSpotServiceImpl.saveParkingSpot(parkingSpotModel);
    }

    @GetMapping
    public List<ParkingSpotModel> findAll() {
        return parkingSpotServiceImpl.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteParkingSpotById(@PathVariable UUID id) {
        parkingSpotServiceImpl.deleteParkingSpotById(id);
    }

}
