package com.sayantha.vehicle.vs.controller;

import com.sayantha.hs.exception.InvalidException;
import com.sayantha.hs.util.ResponseUtil;
import com.sayantha.vehicle.vs.dto.VehicleDTO;
import com.sayantha.vehicle.vs.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:8080")
public class VehicleDetailsController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getAllVehicles(){
        return new ResponseUtil(200, "Get", vehicleService.getAllVehicle());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        if (vehicleDTO.getVehicleBrand() == null) {
            throw new InvalidException("Invalid Brand Name..!");
        }
        return new ResponseUtil(200, "Save..!", vehicleService.saveVehicle(vehicleDTO));
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil updateVehicle(@RequestBody VehicleDTO vehicleDTO){
        if (vehicleDTO.getVehicleBrand() == null) {
            throw new InvalidException("Invalid Brand Name");
        }

        return new ResponseUtil(200, "update", vehicleService.updateVehicle(vehicleDTO));
    }

    @DeleteMapping(params = {"vehicleID"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil deleteVehicle(@RequestParam int vehicleID) {
        vehicleService.deleteVehicleByID(vehicleID);
        return new ResponseUtil(200, "Deleted successfully", null);
    }

    @GetMapping(path ="/searchVehicleById", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil searchVehicleByID(@PathVariable int id){
        return new ResponseUtil(200, "Search", vehicleService.searchVehicleByID(id));
    }
}
