package com.sayantha.ps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HotelDTO {

    @NotNull(message = "Hotel ID cannot be null.")
    private int hotelID;

    @NotBlank(message = "Hotel name cannot be blank.")
    private String hotelName;

}
