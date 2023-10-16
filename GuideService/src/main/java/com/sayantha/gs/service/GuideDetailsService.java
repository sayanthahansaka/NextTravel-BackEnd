package com.sayantha.gs.service;

import com.sayantha.gs.entity.GuideDetails;

import java.util.List;
import java.util.Optional;


public interface GuideDetailsService {

    GuideDetails saveGuide(GuideDetails guideDetails);

    Optional<GuideDetails> findGuideById(int guideID);

    List<GuideDetails> findAllGuides();

    void deleteGuideById(int guideID);

    GuideDetails updateGuide(GuideDetails guideDetails);
}


