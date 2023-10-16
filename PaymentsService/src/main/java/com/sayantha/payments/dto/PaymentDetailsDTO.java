package com.sayantha.payments.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailsDTO {

        private int paymentId;

        private Date date;

        private double amount;

        private int userId;

        private int packageDetailsId;

}
