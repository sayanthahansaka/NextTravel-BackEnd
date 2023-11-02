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
        private Integer packageDetailsID;

        @NotNull
        private Integer packageID;

        @NotBlank
        private String packageCategory;

        @NotNull
        private Integer hotelID;

        @NotNull
        private Integer vehicleID;

        @NotNull
        @FutureOrPresent
        private Date startDuration;

        @NotNull
        @Future
        private Date endDuration;

        @Min(1)
        private int noOfDays;

        @NotBlank
        private String travelArea;

        @Min(0)
        private int noOfAdults;

        @Min(0)
        private int noOfChildren;

        @Min(1)
        private int totalHeadCount;

        private boolean isPetsAllowed;

        private boolean isGuideNeeded;

        private Integer guideID;

        private String nameGuide;

        @DecimalMin("0.0")
        private double totalPackageValue;

        @NotBlank
        private String userID;

        @DecimalMin("0.0")
        private double packagePaidValue;

        private String remark;
}
