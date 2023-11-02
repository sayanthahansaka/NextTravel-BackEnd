package com.sayantha.packageservicea.interfaces;

import com.sayantha.packageservicea.util.ResponseUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("vehicle-service")
public interface VehicleInterface {

    @GetMapping(path = "/id/{id}",params = "packageID", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseUtil searchVehicleByID(@RequestParam("packageID") Integer packageID);
}
