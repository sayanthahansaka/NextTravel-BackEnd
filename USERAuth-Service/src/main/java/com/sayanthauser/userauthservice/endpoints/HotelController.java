package com.sayanthauser.userauthservice.endpoints;

import com.sayanthauser.userauthservice.dto.HotelDTO;
import com.sayanthauser.userauthservice.interfaces.HotelInterface;
import com.sayanthauser.userauthservice.response.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/hotels")
@RestController
@CrossOrigin

public class HotelController {
    @Autowired
    private HotelInterface hotelInterface;
    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveHotel(@RequestBody @Valid  HotelDTO hotelDTO){
        System.out.println("hotelDTO"+hotelDTO.toString());
        return hotelInterface.saveHotel(hotelDTO);

    }
    @PutMapping(path = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>updateHotel(@RequestBody HotelDTO hotelDTO){
        return hotelInterface.updateHotel(hotelDTO);

    }
    @GetMapping(path = "/search",params = "hotelID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>searchHotel(@RequestParam("hotelID")String hotelID ){
        return hotelInterface.searchHotel(hotelID);

    }
    @DeleteMapping(path = "/delete",params = "hotelID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>deleteHotel(@RequestParam("hotelID")String hotelID ){
        return hotelInterface.deleteHotel(hotelID);

    }
    @GetMapping(path = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>searchHotel(){
        return hotelInterface.getAllHotels();

    }
    @GetMapping(path = "/getHotelByName",params = "hotelName",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getHotelByNName(@RequestParam("hotelName") String hotelName){
        return hotelInterface.getHotelByName(hotelName);

    }



}
