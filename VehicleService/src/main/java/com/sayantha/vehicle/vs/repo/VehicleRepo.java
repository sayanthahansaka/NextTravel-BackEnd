package com.sayantha.vehicle.vs.repo;

import com.sayantha.vehicle.vs.entity.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends JpaRepository<VehicleDetails, Integer> {
    @Query("SELECT MAX(h.vehicleID) FROM VehicleDetails h")
    Integer findMaxID();
}
