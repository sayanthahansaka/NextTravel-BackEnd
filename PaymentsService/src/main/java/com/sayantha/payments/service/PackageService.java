package com.sayantha.payments.service;

import com.sayantha.ps.dto.PackageDTO;

import java.util.List;

public interface PackageService {
    PackageDTO savePackage(PackageDTO packageDTO);
    PackageDTO updatePackage(PackageDTO packageDTO);

    void deletePackageByID(int id);

    List<PackageDTO> getAllPackage();

   PackageDTO searchPackageByID(int id);
}
