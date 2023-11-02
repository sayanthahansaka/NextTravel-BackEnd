package com.sayantha.packageservicea.interfaces;

import com.sayantha.hs.dto.HotelDTO;
import com.sayantha.hs.exception.InvalidException;
import com.sayantha.hs.repo.HotelRepo;
import com.sayantha.hs.service.HotelService;
import com.sayantha.hs.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient("hotel-service")
public interface HotelInterface {

    @DeleteMapping(path = "/id/{hotelID}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseUtil deleteHotel(@PathVariable("hotelID") Integer id);

}
