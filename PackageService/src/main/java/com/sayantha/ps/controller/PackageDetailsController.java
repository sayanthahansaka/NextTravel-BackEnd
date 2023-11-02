package com.sayantha.ps.controller;

import com.sayantha.ps.dto.PackageDTO;
import com.sayantha.ps.exception.NotFoundException;
import com.sayantha.ps.repo.PackageRepo;
import com.sayantha.ps.service.PackageService;
import com.sayantha.ps.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/package")
@CrossOrigin
public class PackageDetailsController {

    @Autowired
    private PackageService packageService;

    @Autowired
    private PackageRepo packageRepo;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getAllPackages(){
        return new ResponseUtil(200, "Get", packageService.getAllPackage());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil savePackage(@RequestBody PackageDTO packageDTO){
        if (packageDTO.getTravelArea() == null || packageDTO.getTravelArea().trim().isEmpty()) {
            throw new NotFoundException("Invalid Travel Area..!");
        }
        return new ResponseUtil(200, "Save..!", packageService.savePackage(packageDTO));
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil updatePackage(@RequestBody PackageDTO packageDTO){
        if (packageDTO.getTravelArea() == null || packageDTO.getTravelArea().trim().isEmpty()) {
            throw new NotFoundException("Invalid Travel Area");
        }

        return new ResponseUtil(200, "Update", packageService.updatePackage(packageDTO));
    }

    @DeleteMapping(path = "/id/{package}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil deletePackage(@PathVariable("package") Integer id) {
        packageService.deletePackageByID(id);
        return new ResponseUtil(200, "Deleted successfully", null);
    }

    @GetMapping(path = "/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil searchPackageByID(@PathVariable Integer id){
        return new ResponseUtil(200, "Search", packageService.searchPackageByID(id));
    }
    @GetMapping(path = "/allID", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Integer> getAllID() {
        return packageService.getAllId();
    }

    @PostMapping(path = "/saveHotelID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","hotelID"})
    public ResponseEntity<ResponseUtil> saveHotelID(@RequestParam("packageID") String packageID, @RequestParam("hotelID") String hotelID){
        return null;
    }
    @PostMapping(path = "/saveVehicleID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","vehicleID"})
    public ResponseEntity<ResponseUtil> saveVehicleID(@RequestParam("packageID") String packageID, @RequestParam("vehicleID") String vehicleID){
        return null;
    }
    @DeleteMapping(path = "/deleteHotelID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","hotelID"})
    public ResponseEntity<ResponseUtil> deleteHotelID(@RequestParam("packageID") String packageID, @RequestParam("hotelID") String hotelID){
        return null;
    }

    @DeleteMapping(path = "/deleteVehicleID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","vehicleID"})
    public ResponseEntity<ResponseUtil> deleteVehicleID(@RequestParam("packageID") String packageID, @RequestParam("vehicleID") String vehicleID) {
        return null;
    }


    @PutMapping(path = "/updateHotelPackageId",produces = MediaType.APPLICATION_JSON_VALUE,params = {"oldPackageId","newPackageId","hotelId"})
    public ResponseEntity<ResponseUtil>updateHotelPackageId(@RequestParam("oldPackageId")String oldPackageId,@RequestParam("newPackageId")String newPackageId,@RequestParam("hotelId")String hotelId) {
        return null;
    }
    @GetMapping("/nextPackageID")
    public ResponseEntity<Integer> getNextHotelID() {
        Integer currentMaxID = packageRepo.findMaxID();
        Integer nextID = (currentMaxID == null) ? 1 : currentMaxID + 1;
        return ResponseEntity.ok(nextID);
    }


}
