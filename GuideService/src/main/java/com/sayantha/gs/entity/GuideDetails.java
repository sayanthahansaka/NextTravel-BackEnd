package com.sayantha.gs.entity;

import com.sayantha.gs.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GuideDetails {
    private int guideID;
    private String guideName;
    private String guideAddress;
    private int guideAge;
    @Enumerated
    private Gender guideGender;
    private int guideContact;
    private String guideNICImageLocation;
    private String guideIDImageLocation;
    private String guideExperience;
    private double manDayValue;
    private String remarks;
}
