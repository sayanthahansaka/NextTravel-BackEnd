package com.sayantha.ps.repo;


import com.sayantha.ps.entity.PackageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PackageRepo extends JpaRepository<PackageDetails, Integer> {
    @Query("SELECT p.packageID from PackageDetails p order by p.packageID DESC")
    List<Integer> getAllId();

    @Query("SELECT p.packageID from PackageDetails p order by p.packageID DESC ")
    List<Integer> getAllID();

    List<PackageDetails> findByuserID(String userId);

}
