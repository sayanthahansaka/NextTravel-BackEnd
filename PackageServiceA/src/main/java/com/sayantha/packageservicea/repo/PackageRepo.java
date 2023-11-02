package com.sayantha.packageservicea.repo;


import com.sayantha.packageservicea.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PackageRepo extends JpaRepository<Packages, Integer> {
    Optional<Packages> findByPackageCategory(String category);

    @Query("SELECT p.packageId from Packages p order by p.packageId DESC ")
    List<Integer> getAllID();
}
