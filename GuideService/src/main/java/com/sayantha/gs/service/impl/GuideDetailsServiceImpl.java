package com.sayantha.gs.service.impl;

import com.google.common.reflect.TypeToken;
import com.sayantha.gs.dto.GuideDTO;
import com.sayantha.gs.entity.GuideDetails;
import com.sayantha.gs.exception.NotFoundException;
import com.sayantha.gs.service.GuideDetailsService;
import com.sayantha.gs.repo.GuideRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuideDetailsServiceImpl implements GuideDetailsService {

    @Autowired
    private GuideRepository guideDetailsRepository;

    @Autowired
    ModelMapper mapper;


    @Override
    public GuideDTO saveGuide(GuideDTO guideDTO) {
        if (guideDetailsRepository.existsById(guideDTO.getGuideID()))
        throw new RuntimeException(guideDTO.getGuideID() + "Guide ID Already Exist..!");
        return mapper.map(guideDetailsRepository.save(mapper.map(guideDTO, GuideDetails.class)), GuideDTO.class);
    }

    @Override
    public GuideDTO updateGuide(GuideDTO guideDTO) {
        if (!guideDetailsRepository.existsById(guideDTO.getGuideID()))
            throw new NotFoundException(guideDTO.getGuideID() + "Hotel ID Doesn't Exist..!");
        return mapper.map(guideDetailsRepository.save(mapper.map(guideDTO, GuideDetails.class)), GuideDTO.class);
    }

    @Override
    public GuideDTO searchGuideByID(Integer id) {
        if (!guideDetailsRepository.existsById(id)){
            throw new NotFoundException(id+"Guide ID Doesn't Exist..!");
        }
        Optional<GuideDetails> byId = guideDetailsRepository.findById(id);

        if (byId.isPresent()){
            return mapper.map(byId.get(), GuideDTO.class);
        }else {
            throw new NotFoundException(id+ "Guide ID Doesn't Exist..!");
        }
    }
    @Override
    public List<GuideDTO> findAllGuides() {
        return mapper.map(guideDetailsRepository.findAll(), new TypeToken<List<GuideDTO>>(){}.getType());

    }

    @Override
    public void deleteGuideById(Integer id) {
        if (!guideDetailsRepository.existsById(Integer.valueOf(id)));
        throw new NotFoundException(id + "Guide Doesn't Exist..!");
    }
}
