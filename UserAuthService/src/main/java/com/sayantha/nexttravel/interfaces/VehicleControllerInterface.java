package com.sayantha.nexttravel.interfaces;

import com.sayantha.nexttravel.dto.VehicleDTO;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "VEHICLE-SERVICE")
public interface VehicleControllerInterface {
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getAllVehicles();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicle(@RequestBody VehicleDTO vehicleDTO);

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil updateVehicle(@RequestBody VehicleDTO vehicleDTO);

    @DeleteMapping(params = {"vehicleID"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil deleteVehicle(@RequestParam int vehicleID);

    @GetMapping(path = {"/{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil searchVehicleByID(@PathVariable int id);

//    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Response update(@RequestBody VehicleDTO vehicleDTO);
//
//    @GetMapping(path = "/search", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Response search(@RequestParam("vehicleId") String vehicleId);
//
//    @DeleteMapping(path = "/delete", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Response delete(@RequestParam("vehicleId") String vehicleId);
//
//    @GetMapping(path = "/getPackage", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Optional<Vehicle> getVehicle(@RequestParam("vehicleId") String vehicleId);
//
//    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Response 
//
//    getAll();
}
