package com.sayanthauser.userauthservice.endpoints;

import com.sayanthauser.userauthservice.dto.GuideDTO;
import com.sayanthauser.userauthservice.interfaces.GuideInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/guide")
@CrossOrigin
public class GuideController {

    @Autowired
    private GuideInterface guideService;

    @GetMapping
    public ResponseEntity<List<GuideDTO>> getAllGuides() {
        return ResponseEntity.ok(guideService.getAllGuides().getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuideDTO> getGuideById(@PathVariable int id) {
        return ResponseEntity.ok(guideService.getGuideById(id).getBody());
    }

    @PostMapping("/add")
    public ResponseEntity<GuideDTO> createGuide(@RequestBody @Valid GuideDTO guideDTO) {
        GuideDTO savedGuide = guideService.createGuide(guideDTO).getBody();
        return ResponseEntity.ok(savedGuide);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuideDTO> updateGuide(@PathVariable int id, @RequestBody @Valid GuideDTO guideDTO) {
        GuideDTO updatedGuide = guideService.updateGuide(id, guideDTO).getBody();
        return ResponseEntity.ok(updatedGuide);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuide(@PathVariable int id) {
        guideService.deleteGuide(id);
        return ResponseEntity.noContent().build();
    }
}
