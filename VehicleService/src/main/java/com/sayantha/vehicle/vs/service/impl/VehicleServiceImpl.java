package com.sayantha.vehicle.vs.service.impl;

import com.sayantha.vehicle.vs.entity.VehicleDetails;
import com.sayantha.vehicle.vs.exception.NotFoundException;
import com.sayantha.vehicle.vs.repo.VehicleRepo;
import com.sayantha.vehicle.vs.dto.VehicleDTO;
import com.sayantha.vehicle.vs.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVehicleID()))
            throw new RuntimeException(vehicleDTO.getVehicleID() + "Vehicle ID Already Exist..!");

        return modelMapper.map(vehicleRepo.save(modelMapper.map(vehicleDTO, VehicleDetails.class)), VehicleDTO.class);
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {
        if (!vehicleRepo.existsById(vehicleDTO.getVehicleID()))
            throw new NotFoundException(vehicleDTO.getVehicleID() + "Vehicle ID Doesn't Exist..!");

        return modelMapper.map(vehicleRepo.save(modelMapper.map(vehicleDTO, VehicleDetails.class)), VehicleDTO.class);
    }


    @Override
    public void deleteVehicleByID(Integer id) {

        if (!vehicleRepo.existsById(Integer.valueOf(id)))
            throw new NotFoundException(id + "Vehicle Doesn't Exist..!");

        vehicleRepo.deleteById(Integer.valueOf(id));
    }

    @Override
    public List<VehicleDTO> getAllVehicle() {
        return modelMapper.map(vehicleRepo.findAll(), new TypeToken<List<VehicleDTO>>(){}.getType());
    }

    @Override
    public VehicleDTO searchVehicleByID(Integer id) {
        if (!vehicleRepo.existsById(id))
            throw new NotFoundException(id + "Vehicle ID Doesn't Exist..!");
        Optional<VehicleDetails> vehicleOptional = vehicleRepo.findById(id);
        if (vehicleOptional.isPresent()) {
            return modelMapper.map(vehicleOptional.get(), VehicleDTO.class);
        } else {
            throw new NotFoundException(id + " Hotel ID Doesn't Exist..!");
        }
    }


    @Override
    public List<Integer> getAllId() {
        List<Integer> allIds = vehicleRepo.getAllId();
        System.out.println(allIds);
        return allIds;
    }
}
