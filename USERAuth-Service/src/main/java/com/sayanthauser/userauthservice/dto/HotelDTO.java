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
public class HotelDTO implements SuperDTO, Serializable {

    @NotNull(message = "Hotel ID cannot be null.")
    @Min(value = 1, message = "Hotel ID must be greater than 0.")
    private int hotelID;

    @NotNull(message = "Hotel Name cannot be null.")
    @NotBlank(message = "Hotel Name cannot be blank.")
    @Size(min = 3, max = 50, message = "Hotel Name must be between 3 and 50 characters.")
    private String hotelName;

    @NotNull(message = "Hotel Category cannot be null.")
    @NotBlank(message = "Hotel Category cannot be blank.")
    @Size(min = 3, max = 50, message = "Hotel Category must be between 3 and 50 characters.")
    private String hotelCategory;

    @NotNull(message = "Hotel Coordinates cannot be null.")
    @NotBlank(message = "Hotel Coordinates cannot be blank.")
    @Pattern(regexp = "^[-+]?[0-9]*\\.?[0-9]+,\\s*[-+]?[0-9]*\\.?[0-9]+$", message = "Invalid coordinates format.")
    private String hotelLocationWithCoordinates;

    @NotNull(message = "Email cannot be null.")
    @Email(message = "Email should be valid.")
    private String hotelContactEmail;

    @NotNull(message = "Phone cannot be null.")
    @NotBlank(message = "Phone cannot be blank.")
    @Size(min = 10, max = 10, message = "Phone must be 10 characters.")
    private String hotelContactNumber;

    @NotNull(message = "Pets Allowed status cannot be null.")
    private Boolean isPetsAllowed;

    @NotNull(message = "Hotel Fee cannot be null.")
    @NotBlank(message = "Hotel Fee cannot be blank.")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "Invalid fee format. Should be a numeric value with up to two decimal places.")
    private String hotelFee;

    @NotNull(message = "Cancellation Criteria cannot be null.")
    @NotBlank(message = "Cancellation Criteria cannot be blank.")
    private String cancellationCriteria;

    private String remarks;
}
