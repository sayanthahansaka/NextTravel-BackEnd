package com.sayantha.hs.dto;

import com.sayantha.hs.entity.HotelDetails;
import com.sayantha.hs.model.PackageCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackagesDTO {
    private int packageID;
    private String vehicleCate;
    private String hotelCato;
    private PackageCategory packageCategory;
    private HotelDetails hotelDetails;

}
