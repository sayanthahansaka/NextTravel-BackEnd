package com.sayantha.vehicle.vs.controller;


import com.sayantha.vehicle.vs.dto.VehicleDTO;
import com.sayantha.vehicle.vs.exception.NotFoundException;
import com.sayantha.vehicle.vs.repo.VehicleRepo;
import com.sayantha.vehicle.vs.service.VehicleService;
import com.sayantha.vehicle.vs.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vehicle")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*")
public class VehicleDetailsController {


    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleRepo vehicleRepo;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getAllVehicles(){
        return new ResponseUtil(200, "Get", vehicleService.getAllVehicle());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/sv", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        if (vehicleDTO.getVehicleBrand() == null) {
            throw new NotFoundException("Invalid Brand Name..!");
        }
        return new ResponseUtil(200, "Save..!", vehicleService.saveVehicle(vehicleDTO));
    }

    @PutMapping(path = "/update",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil updateVehicle(@RequestBody VehicleDTO vehicleDTO){
        if (vehicleDTO.getVehicleBrand() == null) {
            throw new NotFoundException("Invalid Brand Name");
        }

        return new ResponseUtil(200, "update", vehicleService.updateVehicle(vehicleDTO));
    }

    @DeleteMapping(path = "/id/{vehicleID}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil deleteVehicle(@PathVariable int vehicleID) {
        vehicleService.deleteVehicleByID(vehicleID);
        return new ResponseUtil(200, "Deleted successfully", null);
    }


    @GetMapping(path = "/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil searchVehicleByID(@PathVariable int id){
        return new ResponseUtil(200, "Search", vehicleService.searchVehicleByID(id));
    }
    @GetMapping("/nextVehicleID")
    public ResponseEntity<Integer> getNextHotelID() {
        Integer currentMaxID = vehicleRepo.findMaxID();
        Integer nextID = (currentMaxID == null) ? 1 : currentMaxID + 1;
        return ResponseEntity.ok(nextID);
    }
}
