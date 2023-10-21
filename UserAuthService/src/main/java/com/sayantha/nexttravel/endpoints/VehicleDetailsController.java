package com.sayantha.nexttravel.endpoints;

import com.sayantha.hs.exception.InvalidException;
import com.sayantha.nexttravel.dto.VehicleDTO;
import com.sayantha.nexttravel.interfaces.VehicleControllerInterface;
import com.sayantha.nexttravel.response.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vehicle")
@CrossOrigin
public class VehicleDetailsController {

    @Autowired
    private VehicleControllerInterface vehicleControllerInterface;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getAllVehicles(){
        return new ResponseUtil(200, "Get", vehicleControllerInterface.getAllVehicles());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicle(@RequestBody VehicleDTO vehicleDTO){
        if (vehicleDTO.getVehicleBrand() == null) {
            throw new InvalidException("Invalid Brand Name..!");
        }
        return new ResponseUtil(200, "Save", vehicleControllerInterface.saveVehicle(vehicleDTO));
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil updateVehicle(@RequestBody VehicleDTO vehicleDTO){
        if (vehicleDTO.getVehicleBrand() == null) {
            throw new InvalidException("Invalid Brand Name");
        }
        return new ResponseUtil(200, "update", vehicleControllerInterface.updateVehicle(vehicleDTO));
    }

    @DeleteMapping(params = {"vehicleID"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil deleteVehicle(@RequestParam int vehicleID) {
        vehicleControllerInterface.deleteVehicle(vehicleID);
        return new ResponseUtil(200, "Deleted successfully", null);
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil searchVehicleByID(@PathVariable int id){
        return new ResponseUtil(200, "Search", vehicleControllerInterface.searchVehicleByID(id));
    }
}
