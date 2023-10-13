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
public class UserDTO {

    @NotNull(message = "User ID cannot be null.")
    private int userID;

    @NotBlank(message = "Username cannot be blank.")
    private String username;
}
