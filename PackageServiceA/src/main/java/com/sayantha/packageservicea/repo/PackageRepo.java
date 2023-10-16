package com.sayantha.packageservicea.repo;


import com.sayantha.packageservicea.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepo extends JpaRepository<Packages, Integer> {

}
