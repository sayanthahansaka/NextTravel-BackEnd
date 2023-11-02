package com.sayantha.ps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.ElementCollection;
import javax.validation.constraints.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PackageDTO {
        private String packageDetailsID;

        private Integer packageID;

        private Integer packageCategory;

        private Integer hotelID;
        private Integer vehicleID;

        private Date startDuration;

        private Date endDuration;


        private String NameGuide;
        private int noOfDays;

        private String travelArea;

        private int noOfAdults;

        private int noOfChildren;

        private int totalHeadCount;

        private boolean isPetsAllowed;

        private boolean isGuideNeeded;

        private Integer guideID;

        private double TotalPackageValue;

        private Integer userID;

        private double packagePaidValue;

        private String remark;
}
