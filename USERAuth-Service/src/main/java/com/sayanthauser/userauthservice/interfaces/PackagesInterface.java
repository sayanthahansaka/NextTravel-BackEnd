package com.sayanthauser.userauthservice.interfaces;

import com.sayanthauser.userauthservice.dto.PackagesDTO;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient("package-service")
public interface PackagesInterface {
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseUtil getAllPackages();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseUtil savePackage(@RequestBody PackagesDTO packageDTO);

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseUtil updatePackage(@RequestBody PackagesDTO packageDTO);

    @DeleteMapping(params = {"packageID"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseUtil deletePackage(@RequestParam int packageID);

    @GetMapping(path = {"/{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE}) // Corrected path variable definition
    ResponseUtil searchPackageByID(@PathVariable int id);
}
