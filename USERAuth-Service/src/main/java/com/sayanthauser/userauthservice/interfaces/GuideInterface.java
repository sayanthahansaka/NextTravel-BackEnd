package com.sayanthauser.userauthservice.interfaces;


import com.sayanthauser.userauthservice.dto.GuideDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("guide-service")
public interface GuideInterface {
    @GetMapping
    public ResponseEntity<List<GuideDTO>> getAllGuides();

    @GetMapping("/{id}")
    public ResponseEntity<GuideDTO> getGuideById(@PathVariable int id);
    @PostMapping("/add")
    public ResponseEntity<GuideDTO> createGuide(@RequestBody GuideDTO guideDTO);

    @PutMapping("/{id}")
    public ResponseEntity<GuideDTO> updateGuide(@PathVariable int id, @RequestBody GuideDTO guideDTO);
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuide(@PathVariable int id);
}
