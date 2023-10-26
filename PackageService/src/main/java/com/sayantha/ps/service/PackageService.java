package com.sayantha.ps.service;

import com.sayantha.ps.dto.PackageDTO;

import java.util.List;

public interface PackageService {
    PackageDTO savePackage(PackageDTO packageDTO);
    PackageDTO updatePackage(PackageDTO packageDTO);

    PackageDTO deletePackageByID(Integer id);

    List<PackageDTO> getAllPackage();

   PackageDTO searchPackageByID(Integer id);





}
