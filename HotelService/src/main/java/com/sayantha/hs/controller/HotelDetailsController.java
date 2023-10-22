package com.sayantha.hs.controller;

import com.sayantha.hs.dto.HotelDTO;
import com.sayantha.hs.exception.InvalidException;
import com.sayantha.hs.service.HotelService;
import com.sayantha.hs.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("")
@CrossOrigin
public class HotelDetailsController {
    @Autowired
    private HotelService hotelService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getAllHotel(){
        return new ResponseUtil(200, "Get", hotelService.getAllHotel());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/save",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveHotel(@RequestBody HotelDTO hotelDTO){
        if (hotelDTO.getHotelName() == null || !hotelDTO.getHotelName().matches("[A-za-z]+")) {
            throw new InvalidException("Invalid Name..!");
        } else if (hotelDTO.getHotelContactEmail() == null){
            throw new InvalidException("Invalid Email..!");
        }
        return new ResponseUtil(200, "Save..!", hotelService.saveHotel(hotelDTO));
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil updateHotel(@RequestBody HotelDTO hotelDTO){
        if (!String.valueOf(hotelDTO.getHotelID()).matches("^[1-9][0-9]*$")) {
            throw new InvalidException("Invalid hotel ID");
        }
        else if (hotelDTO.getHotelName() == null ||
                !hotelDTO.getHotelName().trim().matches("^[A-Za-z ]+$")) {
            throw new InvalidException("Invalid hotel name");
        }
        else if (hotelDTO.getHotelCategory() == null ||
                hotelDTO.getHotelCategory().trim().isEmpty()) {
            throw new InvalidException("Invalid hotel category");
        }
        else if (hotelDTO.getHotelContactEmail() == null ||
                !hotelDTO.getHotelContactEmail().trim().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$")) {
            throw new InvalidException("Invalid email");
        }

        return new ResponseUtil(200, "update", hotelService.updateHotel(hotelDTO));
    }

    @DeleteMapping(params = {"hotelID"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil deleteHotel(@RequestParam String id) {

        if (!id.matches("^[1-9][0-9]*$")) {
            throw new InvalidException("Invalid hotel ID");
        }

        hotelService.deleteHotelByID(id);
        return new ResponseUtil(200, "Deleted successfully", null);
    }

    @GetMapping(path = {"/id"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil searchHotelByID(@PathVariable String id){
        return new ResponseUtil(200, "Search", hotelService.searchHotelByID(id));
    }

}
