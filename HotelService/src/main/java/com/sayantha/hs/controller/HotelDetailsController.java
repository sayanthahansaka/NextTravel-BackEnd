package com.sayantha.hs.controller;

import com.sayantha.hs.dto.HotelDTO;
import com.sayantha.hs.exception.InvalidException;
import com.sayantha.hs.exception.NotFoundException;
import com.sayantha.hs.repo.HotelRepo;
import com.sayantha.hs.service.HotelService;
import com.sayantha.hs.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/hotel")
@CrossOrigin(origins = "http://127.0.0.1:5501", allowedHeaders = "*")

public class HotelDetailsController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRepo hotelRepo;

    @GetMapping("/hotelsget")
    public ResponseUtil getAllHotel() {
        return new ResponseUtil(200, "Success", hotelService.getAllHotel());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/save",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveHotel(@RequestBody HotelDTO hotelDTO){
//        if (hotelDTO.getHotelName() == null || !hotelDTO.getHotelName().matches("[A-za-z]+")) {
//            throw new InvalidException("Invalid Name..!");
//        } else if (hotelDTO.getHotelContactEmail() == null){
//            throw new InvalidException("Invalid Email..!");
//        }
        return new ResponseUtil(200, "Save..!", hotelService.saveHotel(hotelDTO));
    }

    @PutMapping(path = "/update",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
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

    @DeleteMapping(path = "/id/{hotelID}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil deleteHotel(@PathVariable("hotelID") Integer id) {
        hotelService.deleteHotelByID(id);
        return new ResponseUtil(200, "Deleted successfully", null);
    }

    @GetMapping(path = "/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil searchHotelByID(@PathVariable Integer id){
        return new ResponseUtil(200, "Search", hotelService.searchHotelByID(id));
    }

    @GetMapping("/nextHotelID")
    public ResponseEntity<Integer> getNextHotelID() {
        Integer currentMaxID = hotelRepo.findMaxID();
        Integer nextID = (currentMaxID == null) ? 1 : currentMaxID + 1;
        return ResponseEntity.ok(nextID);
    }

    @GetMapping(path = "/getHotelPckageID", params = "packageID", produces = MediaType.APPLICATION_JSON_VALUE)
    public NotFoundException getHotelByPackageID(@RequestParam("packageID") Integer packageID){
        return hotelService.findHotelsByPackagingID(packageID);
    }
    @GetMapping(path = "/allID", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Integer> getAllID() {
        return hotelService.getAllId();
    }
}
