package com.sayantha.payments.repo;


import com.sayantha.ps.entity.PackageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepo extends JpaRepository<PackageDetails, Integer> {

}
