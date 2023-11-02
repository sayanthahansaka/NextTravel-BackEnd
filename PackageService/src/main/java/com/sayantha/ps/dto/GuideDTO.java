package com.sayantha.ps.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuideDTO {
    private Integer guideID;
    private String guideName;
    private String guideAddress;
    private int guideAge;
    private String guideGender;
    private String guideContact;
    private String guideNICImageLocation;
    private String guideIDImageLocation;
    private String guideExperience;
    private double manDayValue;
    private String remarks;
}
