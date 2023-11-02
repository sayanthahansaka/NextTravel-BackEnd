package com.sayantha.packageservicea.service;

import com.sayantha.packageservicea.dto.PackageDTO;
import com.sayantha.packageservicea.util.ResponseUtil;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface PackagesService {
    PackageDTO savePackage(PackageDTO packageDTO);
    PackageDTO updatePackage(PackageDTO packageDTO);

    void deletePackageByID(Integer id);

    List<PackageDTO> getAllPackage();

   PackageDTO searchPackageByID(Integer id);

    ResponseEntity<ResponseUtil> addHotel(Integer packageID, Integer hotelID) ;

    ResponseEntity<ResponseUtil> deleteHotel(Integer packageID, Integer hotelID);
    ResponseEntity<ResponseUtil> addVehicle(Integer packageID, Integer vehicleID);
    ResponseEntity<ResponseUtil> deleteVehicle(Integer packageID, Integer vehicleID);
    List<String> getVehiclesList(Integer packageID);

    List<Integer> getAllID();

    ResponseEntity<ResponseUtil> updateHotelPackageID(Integer oldPackageId, Integer newPackageId, Integer hotelId);
    ResponseEntity<ResponseUtil> updateVehiclePackageID(Integer oldPackageId, Integer newPackageId, Integer vehicleId);
    List<String> getHotelsList(Integer packageID);

    ResponseEntity<ResponseUtil> getPackageByCategory(Integer category);
    ResponseEntity<ResponseUtil> createAndSendResponse(int statusCode, String msg, Object data);
    List<String> getPackageCategoryList();
}
