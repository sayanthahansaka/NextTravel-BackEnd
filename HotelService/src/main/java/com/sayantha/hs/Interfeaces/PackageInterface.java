package com.sayantha.hs.Interfeaces;

import com.sayantha.hs.util.ResponseUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient("packages-service")
public interface PackageInterface {
    @PostMapping(path = "api/v1/pakg/saveHotelID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","hotelID"})
    public ResponseEntity<ResponseUtil> saveHotelID(@RequestParam("packageID") String packageID, @RequestParam("hotelID") String hotelID);


    @PostMapping(path = "api/v1/pakg/saveVehicleID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","vehicleID"})
    public ResponseEntity<ResponseUtil> saveVehicleID(@RequestParam("packageID") String packageID, @RequestParam("vehicleID") String vehicleID);

    @DeleteMapping(path = "api/v1/pakg/deleteHotelID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","hotelID"})
    public ResponseEntity<ResponseUtil> deleteHotelID(@RequestParam("packageID") String packageID, @RequestParam("hotelID") String hotelID);

    @DeleteMapping(path = "api/v1/pakg/deleteVehicleID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","vehicleID"})
    public ResponseEntity<ResponseUtil> deleteVehicleID(@RequestParam("packageID") String packageID, @RequestParam("vehicleID") String vehicleID);

    @PutMapping(path = "api/v1/pakg/updateHotelPackageId",produces = MediaType.APPLICATION_JSON_VALUE,params = {"oldPackageId","newPackageId","hotelId"})
    public ResponseEntity<ResponseUtil>updateHotelPackageId(@RequestParam("oldPackageId")String oldPackageId,@RequestParam("newPackageId")String newPackageId,@RequestParam("hotelId")String hotelId);



    @PutMapping(path = "api/v1/pakg/updateVehiclePackageId", produces = MediaType.APPLICATION_JSON_VALUE, params = {"oldPackageId", "newPackageId", "vehicleId"})
    public ResponseEntity<ResponseUtil> updateVehiclePackageId(@RequestParam("oldPackageId") String oldPackageId, @RequestParam("newPackageId") String newPackageId, @RequestParam("vehicleId") String vehicleId);

}