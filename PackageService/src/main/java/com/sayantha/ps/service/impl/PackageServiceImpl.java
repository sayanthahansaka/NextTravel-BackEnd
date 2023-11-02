package com.sayantha.ps.service.impl;

import com.fasterxml.uuid.Generators;
import com.sayantha.ps.dto.*;
import com.sayantha.ps.entity.PackageDetails;
import com.sayantha.ps.exception.NotFoundException;
import com.sayantha.ps.repo.PackageRepo;
import com.sayantha.ps.service.PackageService;
import com.sayantha.ps.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseUtil response;
    private Integer userId;

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
    public List<PackageDTO> getAllPackage() {
        return modelMapper.map(packageRepo.findAll(), new TypeToken<List<PackageDTO>>() {
        }.getType());
    }

    public PackageDTO deletePackageByID(Integer id) {

        if (!packageRepo.existsById(id)) {
            throw new NotFoundException(id + " Package ID Doesn't Exist..!");
        }
        Optional<PackageDetails> packageDetailsOptional = packageRepo.findById(id);

        if (packageDetailsOptional.isPresent()) {
            return modelMapper.map(packageDetailsOptional.get(), PackageDTO.class);
        } else {
            throw new NotFoundException(id + " Hotel ID Doesn't Exist..!");
        }
    }
    @Override
    public PackageDTO searchPackageByID(Integer id) {
        if (!packageRepo.existsById(id)) {
            throw new NotFoundException(id + " Package ID Doesn't Exist..!");
        }
        Optional<PackageDetails> packageDetailsOptional = packageRepo.findById(id);

        if (packageDetailsOptional.isPresent()) {
            return modelMapper.map(packageDetailsOptional.get(), PackageDTO.class);
        } else {
            throw new com.sayantha.hs.exception.NotFoundException(id + " Package ID Doesn't Exist..!");
        }
    }

    @Override
    public List<Integer> getAllId() {
        List<Integer> allIds = packageRepo.getAllId();
        System.out.println(allIds);
        return allIds;
    }
//
//    public Integer generateNextAppointmentId(){
//        List<Integer> lastIds = packageRepo.getLastId();
//        System.out.println(lastIds);
//
//        Integer lastId = lastIds.get(0);
//        System.out.println(lastId);
//
//        if (lastId != null){
//            return generateNextAppointmentId();
//        }
//        return 1;
//    }


    @Override
    public ResponseEntity<ResponseUtil> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setCode(statusCode);
        response.setMassage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<ResponseUtil>(response, HttpStatus.valueOf(statusCode));

    }

    public List<Integer>getAllID(){
        List<Integer> allIDs= packageRepo.getAllID();
        System.out.println(allIDs);
        return allIDs;
    }


    @Override
    public ResponseEntity<ResponseUtil> getPackageDetailsByUser(Integer userId) {
        this.userId = userId;
        List<PackageDetails> packs = packageRepo.findByuserID(String.valueOf(userId));
        if(packs.isEmpty()){
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "PackageDetails Not Found!",null);

        }
        List<PackageDTO>packageDetailsDTOList = new ArrayList<>();
        packs.forEach((p)->{
            packageDetailsDTOList.add(modelMapper.map(p,PackageDTO.class));

        });

        return createAndSendResponse(HttpStatus.FOUND.value(), "PackageDetails Retrieved Successfully!",packageDetailsDTOList);

    }

    @Override
    public ResponseEntity<ResponseUtil> deletePackageDetailsByUser(Integer userId) {
        List<PackageDetails> packs = packageRepo.findByuserID(String.valueOf(userId));
        if(packs.isEmpty()){
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "No PackageDetails found to delete!",null);

        }
        packs.forEach((p)->{
            packageRepo.deleteById(p.getPackageDetailsID());

        });
        return createAndSendResponse(HttpStatus.OK.value(), "PackageDetails Deleted Successfully!",null);

    }

    @Override
    public Integer generateId() {
        String randomString = "NEXT" + Generators.randomBasedGenerator().generate().toString();
        try {
            return Integer.parseInt(randomString);
        } catch (NumberFormatException e) {
            // Handle the case where the conversion to Integer fails
            e.printStackTrace(); // Or log the error
            return null; // Or return an appropriate default value
        }
    }




}
