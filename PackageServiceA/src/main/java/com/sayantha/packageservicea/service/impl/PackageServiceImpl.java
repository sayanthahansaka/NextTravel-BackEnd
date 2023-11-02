package com.sayantha.packageservicea.service.impl;

import com.sayantha.packageservicea.dto.PackageDTO;
import com.sayantha.packageservicea.entity.Packages;
import com.sayantha.packageservicea.exception.NotFoundException;
import com.sayantha.packageservicea.repo.PackageRepo;
import com.sayantha.packageservicea.service.PackagesService;
import com.sayantha.packageservicea.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class PackageServiceImpl implements PackagesService {

    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ResponseUtil response;

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
    public void deletePackageByID(Integer id) {
        if (!packageRepo.existsById(id))
            throw new NotFoundException(id + " Package Doesn't Exist..!");

        packageRepo.deleteById(id);
    }

    @Override
    public List<PackageDTO> getAllPackage() {
        return modelMapper.map(packageRepo.findAll(), new TypeToken<List<PackageDTO>>(){}.getType());
    }

    @Override
    public PackageDTO searchPackageByID(Integer id) {
        return packageRepo.findById(id)
                .map(pack -> modelMapper.map(pack, PackageDTO.class))
                .orElseThrow(() -> new NotFoundException(id + " Package ID Doesn't Exist..!"));
    }


    @Override
    public ResponseEntity<ResponseUtil> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setCode(statusCode);
        response.setMassage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<>(response, HttpStatus.valueOf(statusCode));

    }

    @Override
    public ResponseEntity<ResponseUtil> addHotel(Integer packageID, Integer hotelID) {
        Optional<Packages> pack = packageRepo.findById(packageID);
        if (pack.isPresent()) {
            pack.get().getHotelCategory().add(String.valueOf(hotelID));
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel added successfully!", null);

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package does not exist!", null);
    }
    @Override
    public ResponseEntity<ResponseUtil> deleteHotel(Integer packageID, Integer hotelID) {
        Optional<Packages> pack = packageRepo.findById(packageID);
        if (pack.isPresent()) {
            pack.get().getHotelCategory().remove(hotelID);
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel deleted successfully!", null);

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package does not exist!", null);
    }
    @Override
    public ResponseEntity<ResponseUtil> addVehicle(Integer packageID, Integer vehicleID) {
        Optional<Packages> pack = packageRepo.findById(packageID);
        if (pack.isPresent()) {
            pack.get().getVehicleCategory().add(String.valueOf(vehicleID));
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle added successfully!", null);

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package does not exist!", null);
    }
    @Override
    public ResponseEntity<ResponseUtil> deleteVehicle(Integer packageID, Integer vehicleID) {
        Optional<Packages> pack = packageRepo.findById(packageID);
        if (pack.isPresent()) {
            pack.get().getVehicleCategory().remove(vehicleID);
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle deleted successfully!", null);

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package does not exist!", null);
    }

    @Override
    public List<String> getHotelsList(Integer packageID) {
        Optional<Packages> pack = packageRepo.findById(packageID);
        if (pack.isPresent()) {
            System.out.println("ServiceIMPL HIDS : "+pack.get().getVehicleCategory());
            return pack.get().getVehicleCategory();
        }
        throw new RuntimeException("Package does not exist!");
    }

    @Override
    public ResponseEntity<ResponseUtil> getPackageByCategory(Integer category) {
        Optional<Packages> pack = packageRepo.findByPackageCategory(String.valueOf(category));
        if (pack.isPresent()) {
            return createAndSendResponse(HttpStatus.OK.value(), "Package retrieved successfully!", modelMapper.map(pack.get(), PackageDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package does not exist!", null);
    }


    @Override
    public List<String> getPackageCategoryList() {
        List<Packages> packages = packageRepo.findAll();
        List<String> categories = packages.stream()
                .map(Packages::getPackageCategory)
                .distinct()
                .collect(Collectors.toList());
        return categories;
    }

    @Override
    public List<String> getVehiclesList(Integer packageID) {
        Optional<Packages> pack = packageRepo.findById(packageID);
        if (pack.isPresent()) {
            System.out.println("ServiceIMPL VIDS : "+pack.get().getVehicleCategory());
            return pack.get().getVehicleCategory();

        }
        throw new RuntimeException("Package does not exist!");
    }


    @Override
    public List<Integer> getAllID() {
        List<Integer> allIDs= packageRepo.getAllID();
        System.out.println(allIDs);
        return allIDs;
    }


    @Override
    public ResponseEntity<ResponseUtil> updateHotelPackageID(Integer oldPackageId, Integer newPackageId, Integer hotelId) {
        Optional<Packages> oldPackage = packageRepo.findById(oldPackageId);
        if(oldPackage.isPresent()){
            oldPackage.get().getHotelCategory().remove(hotelId);
            Optional<Packages> newPackage = packageRepo.findById(newPackageId);
            if(newPackage.isPresent()){
                newPackage.get().getHotelCategory().add(String.valueOf(hotelId));
                return createAndSendResponse(HttpStatus.OK.value(),"Hotel and Package updated successfully!",null);

            }
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"New Package does not exist!",null);


        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"Old Package does not exist!",null);


    }

    @Override
    public ResponseEntity<ResponseUtil> updateVehiclePackageID(Integer oldPackageId, Integer newPackageId, Integer vehicleId) {
        Optional<Packages> oldPackage = packageRepo.findById(oldPackageId);
        if(oldPackage.isPresent()){
            oldPackage.get().getVehicleCategory().remove(vehicleId);
            Optional<Packages> newPackage = packageRepo.findById(newPackageId);
            if(newPackage.isPresent()){
                newPackage.get().getVehicleCategory().add(String.valueOf(vehicleId));
                return createAndSendResponse(HttpStatus.OK.value(),"Vehicle and Package updated successfully!",null);

            }
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"New Package does not exist!",null);
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"Old Package does not exist!",null);
    }
}
//-------------------------------------------------------