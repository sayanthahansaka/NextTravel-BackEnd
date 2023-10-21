package com.sayantha.nexttravel.interfaces;

import com.sayantha.nexttravel.config.FeignConfig;
import com.sayantha.nexttravel.dto.VehicleDTO;
import com.sayantha.nexttravel.response.ResponseUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@FeignClient(name = "VEHICLE-SERVICE", configuration = FeignConfig.class)
public interface VehicleControllerInterface {


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseUtil getAllVehicles();

    @PostMapping(path = "/api/v1/vehicle/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseUtil saveVehicle(@RequestBody VehicleDTO vehicleDTO);

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseUtil updateVehicle(@RequestBody VehicleDTO vehicleDTO);

    @DeleteMapping(params = {"vehicleID"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseUtil deleteVehicle(@RequestParam int vehicleID);

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseUtil searchVehicleByID(@PathVariable int id);
}
