package com.sayantha.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class HotelDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelID;

    @Column(nullable = false)
    private String hotelName;
    private String hotelCategory;
    @Column(nullable = false)
    private String hotelLocationWithCoordinates;
    @Column(nullable = false)
    private String hotelContactEmail;
    private String hotelContactNumber;
    private Boolean isPetsAllowed;
    private String hotelFee;
    private String cancellationCriteria;
    private String remarks;


}

