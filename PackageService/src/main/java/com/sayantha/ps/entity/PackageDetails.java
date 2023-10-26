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
    private Integer packageID;
    private Integer hotelID;
    private Integer vehicleID;
    private Integer userID;
    private Integer guideID;
    private String packageCategory;
    private String travelDuration;
    private String travelArea;
    private int noOfAdults;
    private int noOfChildren;
    private int totalHeadCount;
    private boolean isPetsAllowed;
    private boolean isGuideNeeded;
    private double packageValue;
    private double packagePaidValue;
    private String remark;

}
