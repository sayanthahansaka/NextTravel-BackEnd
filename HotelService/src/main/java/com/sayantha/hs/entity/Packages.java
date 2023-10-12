package com.sayantha.hs.entity;

import com.sayantha.hs.model.PackageCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Packages  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageID;
    private String vehicleCate;
    private String hotelCato;
    @Enumerated
    private PackageCategory packageCategory;
    @ManyToOne
    private HotelDetails hotelDetails;
}
