package com.sayantha.gs.controller;

import com.sayantha.gs.dto.GuideDTO;
import com.sayantha.gs.exception.NotFoundException;
import com.sayantha.gs.service.GuideDetailsService;
import com.sayantha.gs.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/guides")
@CrossOrigin
public class GuideDetailsController {

    @Autowired
    private GuideDetailsService guideDetailsService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getAllGuides() {
        return new ResponseUtil(200, "Success", guideDetailsService.findAllGuides());
    }

    @GetMapping(path = "/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getGuideById(@PathVariable Integer id) {
        return new ResponseUtil(200, "Search", guideDetailsService.searchGuideByID(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil createGuide(@RequestBody GuideDTO guideDTO) {
        return new ResponseUtil(200, "Save..!", guideDetailsService.saveGuide(guideDTO));
    }


    @PutMapping(path = "/update",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil updateGuide(@RequestBody GuideDTO guideDTO) {
       if (guideDTO.getGuideName() == null){
           throw new NotFoundException("Invalid Guide");
       }
       return new ResponseUtil(200, "update", guideDetailsService.updateGuide(guideDTO));
    }

    @DeleteMapping(path = "/id/{guide}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil deleteGuide(@PathVariable("hotelID") Integer id) {
       guideDetailsService.deleteGuideById(id);
       return new ResponseUtil(200,"Deleted successfully", null);
    }
    @GetMapping(path = "/allID", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Integer> getAllID() {
        return guideDetailsService.getAllId();
    }
}