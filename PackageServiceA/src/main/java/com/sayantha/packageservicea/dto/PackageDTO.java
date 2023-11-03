package com.sayantha.packageservicea.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PackageDTO implements Serializable,Super_dto {

    private String package_id;

    private String packageCategory;

    private  String vehical_Category;


    private String hotel_Category;

}
