package com.sayantha.hs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HotelDTO {
    private int hotelID;
    private String hotelName;
    private String hotelCategory;
    private String hotelLocationWithCoordinates;
    private String hotelContactEmail;
    private String hotelContactNumber;
    private Boolean isPetsAllowed;
    private String hotelFee;
    private String cancellationCriteria;
    private String remarks;

}
