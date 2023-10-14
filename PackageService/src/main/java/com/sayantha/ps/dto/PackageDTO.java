package com.sayantha.ps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.ElementCollection;
import javax.validation.constraints.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PackageDTO {
        @NotNull(message = "Package ID cannot be null.")
        private int packageID;

        @NotBlank(message = "Package category cannot be blank.")
        private String packageCategory;

        @NotBlank(message = "Travel duration cannot be blank.")
        private String travelDuration;

        @NotBlank(message = "Travel area cannot be blank.")
        private String travelArea;

        @NotBlank(message = "Remark cannot be blank.")
        private String remark;

        @Min(value = 0, message = "Number of adults cannot be negative.")
        private int noOfAdults;

        @Min(value = 0, message = "Number of children cannot be negative.")
        private int noOfChildren;

        @Min(value = 0, message = "Total head count cannot be negative.")
        private int totalHeadCount;

        private boolean isPetsAllowed;
        private boolean isGuideNeeded;

        @Min(value = 0, message = "Package value cannot be negative.")
        private double packageValue;

        @Min(value = 0, message = "Package paid value cannot be negative.")
        private double packagePaidValue;

        @NotNull(message = "Hotel ID cannot be null.")
        private int hotelID;

        @NotNull(message = "Vehicle ID cannot be null.")
        private int vehicleID;

        @NotNull(message = "User ID cannot be null.")
        private int userID;

        @NotNull(message = "Guide ID cannot be null.")
        @ElementCollection
        private int guideID;


}
