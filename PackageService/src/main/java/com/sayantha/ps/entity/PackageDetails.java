package com.sayantha.ps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PackageDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageID;

    private String packageCategory;
    private String travelDuration;
    private String travelArea;
    private String remark;
    private int noOfAdults;
    private int noOfChildren;
    private int totalHeadCount;
    private boolean isPetsAllowed;
    private boolean isGuideNeeded;
    private double packageValue;
    private double packagePaidValue;
    private int hotelID;
    private int vehicleID;
    private int userID;
    private int guideID;
}
