package com.sayantha.ps.service;

import com.sayantha.ps.dto.PackageDTO;
import com.sayantha.ps.util.ResponseUtil;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PackageService {
    PackageDTO savePackage(PackageDTO packageDTO);
    PackageDTO updatePackage(PackageDTO packageDTO);

    PackageDTO deletePackageByID(Integer id);

    List<PackageDTO> getAllPackage();

   PackageDTO searchPackageByID(Integer id);

    List<Integer>getAllId();

    ResponseEntity<ResponseUtil> createAndSendResponse(int statusCode, String msg, Object data);

    ResponseEntity<ResponseUtil> getPackageDetailsByUser(Integer userId);

    Integer generateId();

    ResponseEntity<ResponseUtil> deletePackageDetailsByUser(Integer userId);





}
