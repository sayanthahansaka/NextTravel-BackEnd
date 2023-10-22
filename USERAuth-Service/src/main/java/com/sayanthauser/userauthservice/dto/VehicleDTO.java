package com.sayanthauser.userauthservice.dto;



import com.sayanthauser.userauthservice.dto.superdto.SuperDTO;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class VehicleDTO implements SuperDTO, Serializable {

    @NotBlank(message = "Vehicle brand cannot be blank.")
    private String vehicleBrand;

    @NotBlank(message = "Vehicle category cannot be blank.")
    private String vehicleCategory;

    @NotBlank(message = "Fuel type cannot be blank.")
    private String fuelType;

    private boolean isHybrid;

    @Pattern(regexp = "\\d+(\\.\\d{1,2})?", message = "Invalid format for fuel usage.")
    private String fuelUsage;

    @Pattern(regexp = "\\d+", message = "Seat capacity should be a number.")
    private String seatCapacity;

    @NotBlank(message = "Vehicle type cannot be blank.")
    private String vehicleType;

    @NotBlank(message = "Transmission type cannot be blank.")
    private String transmissionType;

    @NotBlank(message = "Driver's name cannot be blank.")
    private String driversName;

    @Pattern(regexp = "\\d{10}", message = "Driver's contact number should have 10 digits.")
    private String driversContactNumber;

    @NotBlank(message = "Driver license image reference cannot be blank.")
    private String driverLicenseImageRef;

    private String remarks;

    @NotBlank(message = "Package ID cannot be blank.")
    private String packageID;
}
