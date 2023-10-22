package com.sayanthauser.userauthservice.dto;


import com.sayanthauser.userauthservice.dto.superdto.SuperDTO;
import jakarta.persistence.ElementCollection;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PackageDetailsDTO implements SuperDTO, Serializable {
    @NotNull(message = "Package ID cannot be null.")
    @Min(value = 1, message = "Package ID should be greater than 0.")
    private int packageId;

    @NotBlank(message = "Package Category cannot be blank.")
    @Size(min = 3, max = 50, message = "Package Category should be between 3 and 50 characters.")
    private String packageCategory;

    @NotBlank(message = "Hotel Category cannot be blank.")
    @Size(min = 3, max = 50, message = "Hotel Category should be between 3 and 50 characters.")
    private String hotelCategory;

    @NotNull(message = "Vehicle Category cannot be null.")
    @Min(value = 1, message = "Vehicle Category should be greater than 0.")
    private int vehicleCategory;
}
