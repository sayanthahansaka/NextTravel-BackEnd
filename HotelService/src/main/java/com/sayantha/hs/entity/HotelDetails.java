package com.sayantha.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class HotelDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelID;
    private Integer packageID;
    @Column(nullable = false)
    private String hotelName;
    private String hotelCategory;
    private String hotelLocation;
    @Column(nullable = false)
    private String hotelLocationWithCoordinates;
    private String hotelImageLocation;
    @Column(nullable = false)
    private String hotelContactEmail;
    private String hotelContact1;
    private String hotelContact2;
    private double fullBoardWithACLuxuryRoomDouble;
    private Boolean isPetsAllowed;
    private double hotelFee;
    private String cancellationCriteria;
    private String remarks;


}

