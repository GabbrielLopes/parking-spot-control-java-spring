package com.api.parkingcontrol.services.interfaces;

import com.api.parkingcontrol.models.ParkingSpotModel;

import java.util.List;
import java.util.UUID;

public interface ParkingSpotService {


    ParkingSpotModel saveParkingSpot(ParkingSpotModel parkingSpotModel);

    List<ParkingSpotModel> findAll();

    void deleteParkingSpotById(UUID id);
}
