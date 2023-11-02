package com.sayantha.ps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HotelDTO implements Serializable {

    private Integer hotelID;

    private Integer packageID;

    @NotBlank(message = "Hotel name is required")
    private String hotelName;

    private String hotelCategory;

    private String hotelLocation;

    @NotBlank(message = "Hotel location with coordinates is required")
    private String hotelLocationWithCoordinates;

    private String hotelImageLocation;

    @Email(message = "Email format is incorrect")
    @NotBlank(message = "Contact email is required")
    private String hotelContactEmail;

    @Pattern(regexp = "\\d{10}", message = "Contact number should be of 10 digits")
    private String hotelContact1;

    @Pattern(regexp = "\\d{10}", message = "Alternate contact number should be of 10 digits")
    private String hotelContact2;

    @PositiveOrZero(message = "Value must be positive or zero")
    private double fullBoardWithACLuxuryRoomDouble;

    private Boolean isPetsAllowed;

    @PositiveOrZero(message = "Value must be positive or zero")
    private double hotelFee;

    private String cancellationCriteria;

    private String remarks;


}
