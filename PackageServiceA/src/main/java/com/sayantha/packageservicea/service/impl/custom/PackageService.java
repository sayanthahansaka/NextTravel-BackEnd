package com.sayantha.packageservicea.service.impl.custom;


import com.sayantha.packageservicea.dto.PackageDTO;
import com.sayantha.packageservicea.service.impl.SuperService;
import com.sayantha.packageservicea.util.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PackageService extends SuperService<PackageDTO,String> {
//    List<Integer> getAllID();
    public ResponseEntity<Response> addHotel(String packageID, String hotelID) ;

    public ResponseEntity<Response> deleteHotel(String packageID, String hotelID);
    public ResponseEntity<Response> addVehicle(String packageID, String vehicleID);
    public ResponseEntity<Response> deleteVehicle(String packageID, String vehicleID);
    public List<String> getVehiclesList(String packageID);
    public ResponseEntity<Response> updateHotelPackageID(String oldPackageId, String newPackageId, String hotelId);
    public ResponseEntity<Response> updateVehiclePackageID(String oldPackageId, String newPackageId, String vehicleId);
    public List<String> getHotelsList(String packageID);

    ResponseEntity<Response> getPackageByCategory(String category);

    List<String> getPackageCategoryList();
}
