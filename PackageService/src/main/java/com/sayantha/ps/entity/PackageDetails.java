package com.sayantha.ps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PackageDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer packageDetailsID;

    private Integer packageID;

    private String packageCategory;

    private Integer hotelID;

    private Integer vehicleID;

    private Date startDuration;

    private Date endDuration;

    private int noOfDays;

    private String travelArea;

    private int noOfAdults;

    private int noOfChildren;

    private int totalHeadCount;

    private boolean isPetsAllowed;

    private boolean isGuideNeeded;

    private Integer guideID;

    private String NameGuide;

    private double TotalPackageValue;

    private String userID;

    private double packagePaidValue;

    private String remark;

}
