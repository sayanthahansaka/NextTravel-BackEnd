package com.sayantha.packageservicea.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PackageDTO {

    private int packageId;
    private String packageCategory;
    private String hotelCategory;
    private int vehicleCategory;

}
