package com.sayantha.gs.service;

import com.sayantha.gs.dto.GuideDTO;


import java.util.List;



public interface GuideDetailsService {

    GuideDTO saveGuide(GuideDTO guideDTO);

    GuideDTO updateGuide(GuideDTO guideDTO);

    GuideDTO searchGuideByID(Integer id);

    List<GuideDTO> findAllGuides();

    void deleteGuideById(Integer guideID);
}


