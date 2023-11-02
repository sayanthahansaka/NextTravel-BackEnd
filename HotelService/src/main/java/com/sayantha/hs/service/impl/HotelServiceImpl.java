package com.sayantha.hs.service.impl;

import com.google.common.reflect.TypeToken;
import com.sayantha.hs.dto.HotelDTO;
import com.sayantha.hs.entity.HotelDetails;
import com.sayantha.hs.exception.NotFoundException;

import com.sayantha.hs.repo.HotelRepo;
import com.sayantha.hs.service.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HotelDTO saveHotel(HotelDTO hotelDTO) {
        if (hotelRepo.existsById(hotelDTO.getHotelID()))
            throw new RuntimeException(hotelDTO.getHotelID() + "Hotel ID Already Exist..!");

        return modelMapper.map(hotelRepo.save(modelMapper.map(hotelDTO, HotelDetails.class)), HotelDTO.class);
    }

    @Override
    public HotelDTO updateHotel(HotelDTO hotelDTO) {
        if (!hotelRepo.existsById(hotelDTO.getHotelID()))
            throw new NotFoundException(hotelDTO.getHotelID() + "Hotel ID Doesn't Exist..!");

        return modelMapper.map(hotelRepo.save(modelMapper.map(hotelDTO, HotelDetails.class)), HotelDTO.class);
    }

    @Override
    public void deleteHotelByID(Integer id) {

        if (!hotelRepo.existsById(Integer.valueOf(id)))
            throw new NotFoundException(id + "Hotel Doesn't Exist..!");

        hotelRepo.deleteById(Integer.valueOf(id));
    }

    @Override
    public List<HotelDTO> getAllHotel() {
        return modelMapper.map(hotelRepo.findAll(), new TypeToken<List<HotelDTO>>(){}.getType());
    }

    @Override
    public HotelDTO searchHotelByID(Integer id) {

        if (!hotelRepo.existsById(id)) {
            throw new NotFoundException(id + " Hotel ID Doesn't Exist..!");
        }
        Optional<HotelDetails> hotelOptional = hotelRepo.findById(id);

        if (hotelOptional.isPresent()) {
            return modelMapper.map(hotelOptional.get(), HotelDTO.class);
        } else {
            throw new NotFoundException(id + " Hotel ID Doesn't Exist..!");
        }
    }

    @Override
    public NotFoundException findHotelsByPackagingID(Integer packageId) {
        List<HotelDetails> hotels = hotelRepo.findByPackageID(packageId);
        if (hotels.isEmpty()){
            return new  NotFoundException(packageId + " Hotel ID Doesn't Exist..!");
        }
        List<HotelDTO> hotelDtos=new ArrayList<>();
        hotels.forEach(he -> {
            hotelDtos.add(modelMapper.map(he,HotelDTO.class));
        });
        return new NotFoundException( " Hotels Successfully recived..!");
}

//    @Override
//    public HotelDTO searchHotelByName(String name) {
//
//
//        Optional<HotelDetails> hotelOptional = hotelRepo.findByName(name);
//
//        if (!hotelOptional.isPresent()) {
//            throw new NotFoundException(name + " Hotel Doesn't Exist..!");
//        }
//
//        return modelMapper.map(hotelOptional.get(), HotelDTO.class);
//    }


}
