package com.sayantha.payments.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseUtil {
    private int code;
    private String massage;
    private Object data;
}
