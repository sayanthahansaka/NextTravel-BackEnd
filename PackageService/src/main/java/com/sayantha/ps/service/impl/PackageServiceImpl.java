package com.sayantha.ps.service.impl;

import com.sayantha.ps.dto.*;
import com.sayantha.ps.entity.PackageDetails;
import com.sayantha.ps.exception.NotFoundException;
import com.sayantha.ps.repo.PackageRepo;
import com.sayantha.ps.service.PackageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@Transactional
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PackageDTO savePackage(PackageDTO packageDTO) {
        if (packageRepo.existsById(packageDTO.getPackageID()))
            throw new RuntimeException(packageDTO.getPackageID() + "Package ID Already Exist..!");

        return modelMapper.map(packageRepo.save(modelMapper.map(packageDTO, PackageDetails.class)), PackageDTO.class);
    }

    @Override
    public PackageDTO updatePackage(PackageDTO packageDTO) {
        if (!packageRepo.existsById(packageDTO.getVehicleID()))
            throw new NotFoundException(packageDTO.getVehicleID() + "Package ID Doesn't Exist..!");

        return modelMapper.map(packageRepo.save(modelMapper.map(packageDTO, PackageDetails.class)), PackageDTO.class);
    }


    @Override
    public void deletePackageByID(int id) {

        if (!packageRepo.existsById(Integer.valueOf(id)))
            throw new NotFoundException(id + "Package Doesn't Exist..!");

        packageRepo.deleteById(Integer.valueOf(id));
    }

    @Override
    public List<PackageDTO> getAllPackage() {
        return modelMapper.map(packageRepo.findAll(), new TypeToken<List<PackageDTO>>(){}.getType());
    }

    @Override
    public PackageDTO searchPackageByID(int id) {

        if (!packageRepo.existsById(Integer.valueOf(id)))
            throw new NotFoundException(id + "Package ID Doesn't Exist..!");


        return modelMapper.map(packageRepo.findById(Integer.valueOf(id)).get(),PackageDTO.class);
    }

    public HotelDTO getHotelDetails(int hotelID) {
        String hotelServiceUrl = "http://localhost:8081/api/v1/hotel/hoteladd/id" + hotelID;

        return restTemplate.getForObject(hotelServiceUrl, HotelDTO.class);
    }

    public GuideDTO getGuideDetails(int guideID){
        String guideServiceUrl = "htthiasc" + guideID;

        return restTemplate.getForObject(guideServiceUrl, GuideDTO.class);
    }

    public UserDTO getUserDetails(int userID){
        String userServiceUrl = "http://localhost:8080/api/v1/user/get" +userID;

        return restTemplate.getForObject(userServiceUrl, UserDTO.class);
    }

    public VehicleDTO getVehicleDetails(int vehicleID){
        String vehicleServiceUrl = "http://localhost:8082/api/v1/vehicle/{id}" + vehicleID;

        return restTemplate.getForObject(vehicleServiceUrl, VehicleDTO.class);
    }

}
