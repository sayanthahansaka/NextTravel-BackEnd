package com.sayantha.vehicle.vs.service;

import com.sayantha.vehicle.vs.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    VehicleDTO saveVehicle(VehicleDTO hotelDTO);
    VehicleDTO updateVehicle(VehicleDTO hotelDTO);

    void deleteVehicleByID(int id);

    List<VehicleDTO> getAllVehicle();

    VehicleDTO searchVehicleByID(int id);
}
