package com.sayantha.ps.dto;

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
public class VehicleDTO {

    @NotNull(message = "Vehicle ID cannot be null.")
    private int vehicleID;

    @NotBlank(message = "Vehicle brand cannot be blank.")
    private String vehicleBrand;
}

