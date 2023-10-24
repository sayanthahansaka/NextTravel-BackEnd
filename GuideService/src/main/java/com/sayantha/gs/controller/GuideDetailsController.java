package com.sayantha.gs.controller;

import com.sayantha.gs.entity.GuideDetails;
import com.sayantha.gs.service.GuideDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/guides")
public class GuideDetailsController {

    @Autowired
    private GuideDetailsService guideDetailsService;

    @GetMapping
    public ResponseEntity<List<GuideDetails>> getAllGuides() {
        return ResponseEntity.ok(guideDetailsService.findAllGuides());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuideDetails> getGuideById(@PathVariable int id) {
        return guideDetailsService.findGuideById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GuideDetails> createGuide(@RequestBody GuideDetails guideDetails) {
        return ResponseEntity.ok(guideDetailsService.saveGuide(guideDetails));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuideDetails> updateGuide(@PathVariable int id, @RequestBody GuideDetails guideDetails) {
        if (id != guideDetails.getGuideID()) {
            return ResponseEntity.badRequest().build(); // IDs don't match
        }
        return ResponseEntity.ok(guideDetailsService.updateGuide(guideDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuide(@PathVariable int id) {
        guideDetailsService.deleteGuideById(id);
        return ResponseEntity.noContent().build();
    }
}

