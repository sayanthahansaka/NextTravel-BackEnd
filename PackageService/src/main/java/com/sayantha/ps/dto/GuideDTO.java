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
public class GuideDTO {

    @NotNull(message = "Guide ID cannot be null.")
    private int guideID;

    @NotBlank(message = "Guide name cannot be blank.")
    private String guideName;

}
