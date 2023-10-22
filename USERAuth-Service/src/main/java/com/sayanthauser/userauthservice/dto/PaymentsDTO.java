package com.sayanthauser.userauthservice.dto;


import com.sayanthauser.userauthservice.dto.superdto.SuperDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaymentsDTO implements SuperDTO, Serializable {

    @NotNull(message = "Payment ID cannot be null.")
    @Min(value = 1, message = "Payment ID should be greater than 0.")
    private int paymentId;

    @NotNull(message = "Date cannot be null.")
    private Date date;

    @NotNull(message = "Amount cannot be null.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than 0.")
    private double amount;

    @NotNull(message = "User ID cannot be null.")
    @Min(value = 1, message = "User ID should be greater than 0.")
    private int userId;

    @NotNull(message = "Package Details ID cannot be null.")
    @Min(value = 1, message = "Package Details ID should be greater than 0.")
    private int packageDetailsId;
}
