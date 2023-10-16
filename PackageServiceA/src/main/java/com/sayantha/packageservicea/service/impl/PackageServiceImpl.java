package com.sayantha.packageservicea.service.impl;

import com.sayantha.packageservicea.dto.PackageDTO;
import com.sayantha.packageservicea.entity.Packages;
import com.sayantha.packageservicea.exception.NotFoundException;
import com.sayantha.packageservicea.repo.PackageRepo;
import com.sayantha.packageservicea.service.PackagesService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PackageServiceImpl implements PackagesService {

    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PackageDTO savePackage(PackageDTO packageDTO) {
        if (packageRepo.existsById(packageDTO.getPackageId()))
            throw new RuntimeException(packageDTO.getPackageId() + " Package ID Already Exist..!");

        return modelMapper.map(packageRepo.save(modelMapper.map(packageDTO, Packages.class)), PackageDTO.class);
    }

    @Override
    public PackageDTO updatePackage(PackageDTO packageDTO) {
        if (!packageRepo.existsById(packageDTO.getPackageId()))
            throw new NotFoundException(packageDTO.getPackageId() + " Package ID Doesn't Exist..!");

        return modelMapper.map(packageRepo.save(modelMapper.map(packageDTO, Packages.class)), PackageDTO.class);
    }

    @Override
    public void deletePackageByID(int id) {
        if (!packageRepo.existsById(id))
            throw new NotFoundException(id + " Package Doesn't Exist..!");

        packageRepo.deleteById(id);
    }

    @Override
    public List<PackageDTO> getAllPackage() {
        return modelMapper.map(packageRepo.findAll(), new TypeToken<List<PackageDTO>>(){}.getType());
    }

    @Override
    public PackageDTO searchPackageByID(int id) {
        return packageRepo.findById(id)
                .map(pack -> modelMapper.map(pack, PackageDTO.class))
                .orElseThrow(() -> new NotFoundException(id + " Package ID Doesn't Exist..!"));
    }
}

