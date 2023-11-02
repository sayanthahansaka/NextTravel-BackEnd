package com.sayantha.packageservicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PackageServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(PackageServiceAApplication.class, args);
    }

}
