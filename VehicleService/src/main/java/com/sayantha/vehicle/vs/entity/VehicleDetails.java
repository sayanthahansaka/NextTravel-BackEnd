package com.sayantha.vehicle.vs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class VehicleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicleID;

    @Column(nullable = false)
    private String vehicleBrand;

    private String vehicleCategory;
    private String fuelType;
    private boolean isHybrid;
    private String fuelUsage;

    @Column(nullable = false)
    private String seatCapacity;

    private String vehicleType;
    private String transmissionType;
    private String driversName;
    private String vehicleImage;

    @Column(nullable = false)
    private String driversContactNumber;
    private String driverLicenseImage;
    private String remarks;
    private Integer packageID;


}
