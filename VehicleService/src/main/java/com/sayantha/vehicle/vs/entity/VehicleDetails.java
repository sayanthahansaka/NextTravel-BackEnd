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
    private int vehicleID;

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

    @Column(nullable = false)
    private String driversContactNumber;

    private String driverLicenseImageRef;
    private String remarks;
    private String packageID;


}
