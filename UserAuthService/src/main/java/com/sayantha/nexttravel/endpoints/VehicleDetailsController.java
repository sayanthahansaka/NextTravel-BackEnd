package com.sayantha.nexttravel.endpoints;


import com.sayantha.hs.exception.InvalidException;
import com.sayantha.hs.util.ResponseUtil;
import com.sayantha.nexttravel.dto.VehicleDTO;
import com.sayantha.nexttravel.interfaces.VehicleControllerInterface;
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
    public com.sayantha.nexttravel.response.ResponseUtil getAllVehicles(){
        return new com.sayantha.nexttravel.response.ResponseUtil(200, "Get", vehicleControllerInterface.getAllVehicles());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public com.sayantha.nexttravel.response.ResponseUtil saveVehicle(@RequestBody VehicleDTO vehicleDTO){
        if (vehicleDTO.getVehicleBrand() == null) {
            throw new InvalidException("Invalid Brand Name..!");
        }
        return new com.sayantha.nexttravel.response.ResponseUtil(200, "Save..!", vehicleControllerInterface.saveVehicle(vehicleDTO));
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public com.sayantha.nexttravel.response.ResponseUtil updateVehicle(@RequestBody VehicleDTO vehicleDTO){
        if (vehicleDTO.getVehicleBrand() == null) {
            throw new InvalidException("Invalid Brand Name");
        }

        return new com.sayantha.nexttravel.response.ResponseUtil(200, "update", vehicleControllerInterface.updateVehicle(vehicleDTO));
    }

    @DeleteMapping(params = {"vehicleID"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public com.sayantha.nexttravel.response.ResponseUtil deleteVehicle(@RequestParam int vehicleID) {
        vehicleControllerInterface.deleteVehicle(vehicleID);
        return new com.sayantha.nexttravel.response.ResponseUtil(200, "Deleted successfully", null);
    }

    @GetMapping(path = {"/{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil searchVehicleByID(@PathVariable int id){
        return new com.sayantha.hs.util.ResponseUtil(200, "Search", vehicleControllerInterface.searchVehicleByID(id));
    }
}
