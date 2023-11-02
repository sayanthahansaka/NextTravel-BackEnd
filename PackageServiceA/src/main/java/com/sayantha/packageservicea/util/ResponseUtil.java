package com.sayantha.packageservicea.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ResponseUtil {
    private int code;
    private String massage;
    private Object data;
}
