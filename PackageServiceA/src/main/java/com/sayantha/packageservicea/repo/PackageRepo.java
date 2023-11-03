package com.sayantha.packageservicea.repo;


import com.sayantha.packageservicea.entity.PackagesDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PackageRepo extends JpaRepository<PackagesDetails, String> {
//    @Query("SELECT p.package_id from Packages p order by p.package_id DESC ")
//    List<String> getAllID();

    Optional<PackagesDetails> findByPackageCategory(String category);
}
