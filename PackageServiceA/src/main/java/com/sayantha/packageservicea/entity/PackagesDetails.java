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
public class PackagesDetails {
    @Id
    private String package_id;

    private String packageCategory;


    @ElementCollection
    private List<String> vehical_Category;

    @ElementCollection//we cant use many to one
    private List<String> hotel_Category;

}
