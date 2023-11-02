package com.sayantha.packageservicea.interfaces;

import com.sayantha.packageservicea.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("package-service")
public interface PackageInterface {
    @PostMapping(path = "/addVehicleID", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, params = {"packageID", "vehicleID"})
    ResponseUtil saveVehicleID(@RequestParam ("packageID") Integer packageID, @RequestParam("vehicleID") Integer vehicleID);

    @DeleteMapping(path = "/deleteVehicleID", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, params = {"packageID", "vehicleID"})
    public ResponseUtil deleteVehicleID(@RequestParam ("packageID") Integer packageID, @RequestParam("vehicleID") Integer vehicleID);

    @PostMapping(path = "/updateVehicleID", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, params = {"oldPackageID", "newPackageID","oldVehicleID","newVehicleID"})
    ResponseUtil updateVehiclePackage(@RequestParam("oldPackageID") Integer oldPackageID, @RequestParam("newPackageID") Integer newPackageID, @RequestParam("oldVehicleID") Integer oldVehicleID, @RequestParam("newVehicleID") Integer newVehicleID);
}