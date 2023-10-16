package com.sayantha.gs.service.impl;

import com.sayantha.gs.entity.GuideDetails;
import com.sayantha.gs.service.GuideDetailsService;
import com.sayantha.gs.repo.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuideDetailsServiceImpl implements GuideDetailsService {

    @Autowired
    private GuideRepository guideDetailsRepository;

    @Override
    public GuideDetails saveGuide(GuideDetails guideDetails) {
        return guideDetailsRepository.save(guideDetails);
    }

    @Override
    public Optional<GuideDetails> findGuideById(int guideID) {
        return guideDetailsRepository.findById(guideID);
    }

    @Override
    public List<GuideDetails> findAllGuides() {
        return guideDetailsRepository.findAll();
    }

    @Override
    public void deleteGuideById(int guideID) {
        guideDetailsRepository.deleteById(guideID);
    }

    @Override
    public GuideDetails updateGuide(GuideDetails guideDetails) {
        if (guideDetailsRepository.existsById(guideDetails.getGuideID())) {
            return guideDetailsRepository.save(guideDetails);
        } else {
            throw new RuntimeException("Guide with ID " + guideDetails.getGuideID() + " not found.");
        }
    }
}
