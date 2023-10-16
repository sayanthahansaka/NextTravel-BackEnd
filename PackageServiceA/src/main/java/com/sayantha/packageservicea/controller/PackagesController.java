package com.sayantha.packageservicea.controller;

import com.sayantha.hs.exception.InvalidException;
import com.sayantha.packageservicea.dto.PackageDTO;
import com.sayantha.packageservicea.service.PackagesService;
import com.sayantha.packageservicea.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/package")
@CrossOrigin
public class PackagesController {

    @Autowired
    private PackagesService packageService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getAllPackages() {
        return new ResponseUtil(200, "Get", packageService.getAllPackage());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil savePackage(@RequestBody PackageDTO packageDTO) {
        if (packageDTO.getHotelCategory() == null || packageDTO.getHotelCategory().trim().isEmpty()) {
            throw new InvalidException("Invalid Hotel Category ..!");
        }
        return new ResponseUtil(201, "Save..!", packageService.savePackage(packageDTO)); // 201 Created for POST requests
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil updatePackage(@RequestBody PackageDTO packageDTO) {
        if (packageDTO.getHotelCategory() == null || packageDTO.getHotelCategory().trim().isEmpty()) {
            throw new InvalidException("Invalid...!");
        }
        return new ResponseUtil(200, "Update", packageService.updatePackage(packageDTO));
    }

    @DeleteMapping(params = {"packageID"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil deletePackage(@RequestParam int packageID) {
        packageService.deletePackageByID(packageID);
        return new ResponseUtil(200, "Deleted successfully", null);
    }

    @GetMapping(path = {"/{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE}) // Corrected path variable definition
    public ResponseUtil searchPackageByID(@PathVariable int id) {
        return new ResponseUtil(200, "Search", packageService.searchPackageByID(id));
    }
}
