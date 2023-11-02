package com.sayantha.vehicle.vs.repo;

import com.sayantha.vehicle.vs.entity.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepo extends JpaRepository<VehicleDetails, Integer> {
    @Query("SELECT MAX(h.vehicleID) FROM VehicleDetails h")
    Integer findMaxID();

    @Query("SELECT v.vehicleID from VehicleDetails v order by v.vehicleID DESC")
    List<Integer> getAllId();
}
