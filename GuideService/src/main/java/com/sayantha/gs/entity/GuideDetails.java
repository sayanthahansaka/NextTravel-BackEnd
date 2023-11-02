package com.sayantha.gs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class GuideDetails {
    @Id
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
