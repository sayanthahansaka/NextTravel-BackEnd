package com.sayantha.packageservicea.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Packages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer packageId;
    private String packageCategory;
    @ElementCollection
    private List<String> hotelCategory;
    @ElementCollection
    private List<String> vehicleCategory;

}
