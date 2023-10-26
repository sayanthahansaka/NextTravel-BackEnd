package com.sayantha.vehicle.vs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.*;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString


public class VehicleDTO{
    private Integer vehicleID;

    @NotBlank(message = "Vehicle brand cannot be blank")
    private String vehicleBrand;

    private String vehicleCategory;
    private String fuelType;
    private boolean isHybrid;

    @NotBlank(message = "Fuel usage cannot be blank")
    private String fuelUsage;

    @NotNull(message = "Seat capacity cannot be null")
    @Pattern(regexp = "^[0-9]+$", message = "Seat capacity must be a number")
    private String seatCapacity;

    private String vehicleType;
    private String transmissionType;
    private String driversName;
    private String vehicleImage;

    @NotBlank(message = "Driver's contact number cannot be blank")
    @Pattern(regexp = "^\\+[0-9]{1,3}\\.[0-9]{4,14}(?:x.+)?$", message = "Driver's contact number is not in a valid format")
    private String driversContactNumber;

    private String driverLicenseImage;
    private String remarks;

    private Integer packageID;

}

