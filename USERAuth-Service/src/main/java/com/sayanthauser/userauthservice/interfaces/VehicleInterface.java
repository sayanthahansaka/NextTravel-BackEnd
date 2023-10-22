package com.sayanthauser.userauthservice.interfaces;

import com.sayanthauser.userauthservice.dto.VehicleDTO;
import com.sayanthauser.userauthservice.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient("vehicle-service")
public interface VehicleInterface {
    @PostMapping(path = "/sv", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveVehicle(@RequestBody VehicleDTO vehicleDTO);

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateVehicle(@RequestBody VehicleDTO vehicleDTO);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAllVehicles();

    @DeleteMapping(params = "vehicleID", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteVehicle(@RequestParam int vehicleID);

    @GetMapping(path = "/searchVehicleById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> searchVehicleByID(@PathVariable int id);


    @GetMapping(path = "/getVehicleByBrand", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response> getVehicleByBrand(@RequestParam("vehicleBrand") String vehicleBrand);

}
