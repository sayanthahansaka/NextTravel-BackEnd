package com.sayanthauser.userauthservice.dto;


import com.sayanthauser.userauthservice.dto.superdto.SuperDTO;
import com.sayanthauser.userauthservice.enums.GENDER;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class GuideDTO implements SuperDTO, Serializable {

    @NotNull(message = "Guide ID cannot be null.")
    @Min(value = 1, message = "Guide ID should be greater than 0.")
    private int guideID;

    @NotBlank(message = "Guide Name cannot be blank.")
    @Size(min = 3, max = 50, message = "Guide Name should be between 3 and 50 characters.")
    private String guideName;

    @NotBlank(message = "Guide Address cannot be blank.")
    private String guideAddress;

    @NotNull(message = "Guide Age cannot be null.")
    @Min(value = 18, message = "Guide should be at least 18 years old.")
    @Max(value = 100, message = "Guide age seems unrealistic.")
    private int guideAge;

    @Enumerated
    @NotNull(message = "Gender cannot be null.")
    private Gender guideGender;

    @NotNull(message = "Guide Contact cannot be null.")
    @Digits(integer = 10, fraction = 0, message = "Invalid contact number.")
    private int guideContact;

    @NotBlank(message = "NIC Image Location cannot be blank.")
    private String guideNICImageLocation;

    @NotBlank(message = "ID Image Location cannot be blank.")
    private String guideIDImageLocation;

    @Size(max = 500, message = "Guide Experience should not exceed 500 characters.")
    private String guideExperience;

    @NotNull(message = "Man Day Value cannot be null.")
    @PositiveOrZero(message = "Man Day Value should be positive.")
    private double manDayValue;

    @Size(max = 500, message = "Remark should not exceed 500 characters.")
    private String remark;

    // Enum for Gender
    public enum Gender {
        MALE, FEMALE, OTHER
    }
}
