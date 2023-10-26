package com.sayantha.ps.controller;

import com.sayantha.ps.dto.PackageDTO;
import com.sayantha.ps.exception.NotFoundException;
import com.sayantha.ps.service.PackageService;
import com.sayantha.ps.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/package")
@CrossOrigin
public class PackageDetailsController {

    @Autowired
    private PackageService packageService;

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

}
