package com.sayanthauser.userauthservice.interfaces;


import com.sayanthauser.userauthservice.dto.HotelDTO;
import com.sayanthauser.userauthservice.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient("HOTEL-SERVICE")

public interface HotelInterface {
    @PostMapping(path = "/saveHotel",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Response> saveHotel(@RequestBody HotelDTO hotelDTO);
    @PutMapping(path = "/updateHotel",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>updateHotel(@RequestBody HotelDTO hotelDTO);
    @GetMapping(path = "/searchHotel",params = "hotelID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>searchHotel(@RequestParam("hotelID")String hotelID );
    @DeleteMapping(path = "/deleteHotel",params = "hotelID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>deleteHotel(@RequestParam("hotelID")String hotelID );
    @GetMapping(path = "/getAllHotels",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getAllHotels();
    @GetMapping(path = "/getHotelByHotelName",params = "hotelName",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getHotelByName(@RequestParam("hotelName")String hotelName);
}
