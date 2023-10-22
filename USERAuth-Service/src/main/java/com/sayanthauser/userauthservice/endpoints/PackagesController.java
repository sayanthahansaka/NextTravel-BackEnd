package com.sayanthauser.userauthservice.endpoints;

import com.sayanthauser.userauthservice.dto.PackagesDTO;
import com.sayanthauser.userauthservice.interfaces.PackagesInterface;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/package")
public class PackagesController {

    @Autowired
    private PackagesInterface packagesInterface;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getAllPackages() {
        return packagesInterface.getAllPackages();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil savePackage(@RequestBody PackagesDTO packageDTO) {
        return packagesInterface.savePackage(packageDTO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil updatePackage(@RequestBody PackagesDTO packageDTO) {
        return packagesInterface.updatePackage(packageDTO);
    }

    @DeleteMapping(params = {"packageID"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil deletePackage(@RequestParam int packageID) {
        return packagesInterface.deletePackage(packageID);
    }

    @GetMapping(path = {"/{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil searchPackageByID(@PathVariable int id) {
        return packagesInterface.searchPackageByID(id);
    }
}
