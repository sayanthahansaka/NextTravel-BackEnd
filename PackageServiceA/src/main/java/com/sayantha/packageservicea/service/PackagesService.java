package com.sayantha.packageservicea.service;

import com.sayantha.packageservicea.dto.PackageDTO;


import java.util.List;

public interface PackagesService {
    PackageDTO savePackage(PackageDTO packageDTO);
    PackageDTO updatePackage(PackageDTO packageDTO);

    void deletePackageByID(int id);

    List<PackageDTO> getAllPackage();

   PackageDTO searchPackageByID(int id);
}
