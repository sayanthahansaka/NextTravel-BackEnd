package com.sayanthauser.userauthservice.endpoints;

import com.sayanthauser.userauthservice.dto.VehicleDTO;
import com.sayanthauser.userauthservice.interfaces.VehicleInterface;
import com.sayanthauser.userauthservice.response.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {

    private final VehicleInterface vehicleInterface;

    @Autowired
    public VehicleController(VehicleInterface vehicleInterface) {
        this.vehicleInterface = vehicleInterface;
    }

    @PostMapping(path = "/sv", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveVehicle(@RequestBody @Valid VehicleDTO vehicleDTO) {
        return vehicleInterface.saveVehicle(vehicleDTO);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateVehicle(@RequestBody @Valid VehicleDTO vehicleDTO) {
        return vehicleInterface.updateVehicle(vehicleDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAllVehicles() {
        return vehicleInterface.getAllVehicles();
    }

    @DeleteMapping(params = "vehicleID", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteVehicle(@RequestParam int vehicleID) {
        return vehicleInterface.deleteVehicle(vehicleID);
    }

    @GetMapping(path = "/searchVehicleById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> searchVehicleByID(@PathVariable int id) {
        return vehicleInterface.searchVehicleByID(id);
    }

    @GetMapping(path = "/getVehicleByBrand", params = "vehicleBrand", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getVehicleByBrand(@RequestParam("vehicleBrand") String vehicleBrand) {
        return vehicleInterface.getVehicleByBrand(vehicleBrand);
    }
}