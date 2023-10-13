package com.sayantha.vehicle.vs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PackageDTO {
    @NotBlank(message = "Package ID cannot be blank")
    private int packageID;
    private String vehicleCategory;
    private String hotelCato;
}
